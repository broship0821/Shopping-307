package com.team1.shopping307.DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team1.shopping307.Libs.Libs;
import com.team1.shopping307.VO.PayVO;
import com.team1.shopping307.VO.ProdVO;
import com.team1.shopping307.VO.ReleHistVO;
import com.team1.shopping307.controller.LoginManager;

public class RelePayDAO {
	private static String className = "RelePayDAO";
	private static final String STATUS = "입금완료";

	// 결제시 release_history, pay_info 테이블 insert 작업을 하나의 메소드로 하나의 트랜잭션으로 처리
	public int insertRelePay(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 결제페이지에서 보낸 데이터
		String[] ProdIDs = request.getParameterValues("ProductID"); // 상품 번호(상품이 여러개니 배열로 받아야됨)
		String[] cnt = request.getParameterValues("cnt"); // 상품 개수(상품이 여러개니 배열로 받아야됨)
		String name = request.getParameter("name"); // 구매자 이름
		String zip = request.getParameter("zip"); // 구매자 우편번호
		String address = request.getParameter("address"); // 구매자 주소
		String tel = request.getParameter("tel"); // 구매자 전화번호
		String cashOrCard = request.getParameter("cashOrCard"); // 'C':카드, 'S':현금, 'B':무통장입금
		String cardNo = request.getParameter("cardNO"); // 카드번호
		// pay_info에 필요한 items_info, amount
		StringBuffer itemsInfo = new StringBuffer();
		int amount = 0;

		// 현재 로그인 사용자 정보 가져오기
		String userID = LoginManager.getUserInfo(request).getUserId();

		// db 작업
		Connection conn = null;
		long result1 = 0;// release_history insert 결과 성공시 release_id 반환
		long result2 = 0;// pay_info insert 결과 성공시 pay_id 반환
		try {
			conn = Libs.connectWithManualCommit();

			for (int i = 0; i < ProdIDs.length; i++) {
				// 먼저 select로 필요한 Product 정보 추출
				ReleHistVO vo = getProdInfo(conn, ProdIDs[i]);
				// 구매한 유저는 로그인된 유저
				vo.setUserId(userID);
				// 상품별로 각각 release_history에 insert(갯수마다 하나씩 insert)
				int size = Integer.parseInt(cnt[i]);// 갯수
				for (int j = 0; j < size; j++) {
					result1 = insert(conn, vo);
				}
				// pay_info에 필요한 items_info, amount 값 넣기
				itemsInfo.append(vo.getProdId() + "-");
				itemsInfo.append(vo.getProdName() + "X");
				itemsInfo.append(size + ", ");
				amount += vo.getPrice() * size;// 물품금액*갯수
			}
			// pay_info에 insert
			PayVO payVO = new PayVO();
			// 판매자 일단 "undefined" 처리
			payVO.setSellerName("undefined");
			payVO.setSellerPhone("0");
			payVO.setSellerZip("0");
			payVO.setSellerAddress("undefined");
			// 구매한 유저는 로그인된 유저
			payVO.setBuyerId(userID);
			payVO.setBuyerName(name);
			payVO.setBuyerPhone(tel);
			payVO.setBuyerZip(zip);
			payVO.setBuyerAddress(address);
			payVO.setItemsInfo(itemsInfo.toString());
			payVO.setAmount(amount);
			payVO.setCashOrCard(cashOrCard);
			payVO.setCardNo(cardNo);
			payVO.setStatus(STATUS);

			result2 = new PayDAO().insert(conn, payVO, true);
			//마지막에 커밋
			conn.commit();
			conn.setAutoCommit(true);

		} catch (Exception e) {
			e.printStackTrace();
			if (conn != null)
				try {
					conn.rollback();
				} catch (Exception e2) {
				}
		}

		return (result1 != 0 && result2 != 0) ? 1 : 0;
	}

	// product 테이블에서 select로 필요한 정보 추출
	public static ReleHistVO getProdInfo(Connection conn, String prodID) throws SQLException {
		System.out.println(className + ".getProdInfo()");
		ReleHistVO vo = new ReleHistVO();

		if (conn != null) {
			PreparedStatement ps = null;
			ResultSet rs = null;
			String sql = "SELECT product_id,product_name,category,is_new,standard,price FROM product "
					+ "WHERE product_id=?";

			ps = conn.prepareStatement(sql);
			ps.setString(1, prodID);
			rs = ps.executeQuery();

			if (rs.next()) {
				vo.setProdId(rs.getString("product_id"));
				vo.setProdName(rs.getString("product_name"));
				vo.setCaregory(rs.getString("category"));
				vo.setIsNew(rs.getString("is_new"));
				vo.setStandard(rs.getString("standard"));
				vo.setPrice(rs.getLong("price"));
			}
			Libs.close(rs);
			Libs.close(ps);
		}
		return vo;
	}

	// release_history에 값 저장하기
	public static long insert(Connection conn, ReleHistVO vo) throws SQLException {
		System.out.println(className + ".insert()");
		long result = 0;
		PreparedStatement ps = null;

		if (conn != null) {
			/*
			 * INSERT INTO release_history (release_id, user_id, product_id, product_name,
			 * category, is_new, standard, price, status) VALUES
			 * (seq_rele.NEXTVAL,'peter','PROD_1000000004','드레스','상의','Y','100',39990,'입금완료'
			 * );
			 */
			String sql = "INSERT INTO release_history(release_id, user_id, product_id, product_name, category, is_new, standard, price, status)"
					+ " VALUES(?,?,?,?,?,?,?,?,?)";
			// seq_rele.NEXTVAL,'입금완료' 바꿔야됨
			ps = conn.prepareStatement(sql);
			int idx = 0;
			vo.setReleId(Long.valueOf(Libs.getNewId(conn, "", "seq_rele", "release_id")));

			ps.setLong(++idx, vo.getReleId());
			ps.setString(++idx, vo.getUserId());
			ps.setString(++idx, vo.getProdId());
			ps.setString(++idx, vo.getProdName());
			ps.setString(++idx, vo.getCaregory());
			ps.setString(++idx, vo.getIsNew());
			ps.setString(++idx, vo.getStandard());
			ps.setLong(++idx, vo.getPrice());
			ps.setString(++idx, STATUS);

			int rtv = ps.executeUpdate();

			if (rtv == 1) {// 성공시
				result = vo.getReleId();
			}
			Libs.close(ps);
		}

		return result;
	}

}
