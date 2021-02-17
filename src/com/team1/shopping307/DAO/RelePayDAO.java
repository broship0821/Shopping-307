package com.team1.shopping307.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.team1.shopping307.Libs.Libs;
import com.team1.shopping307.VO.PayVO;
import com.team1.shopping307.VO.ProdVO;
import com.team1.shopping307.VO.ReleHistVO;

//결제시 release_history, pay_info 테이블 insert 작업을 하나의 트랜잭션으로 처리
public class RelePayDAO {
	private static String className = "RelePayDAO";
	// 하나의 커넥션을 사용
	private static Connection conn = Libs.connect();

	public RelePayDAO() {
		try {
			conn.setAutoCommit(false);

		} catch (Exception e) {
			System.out.println("RelePayDAO 커넥션 오류!");
			e.printStackTrace();
		}
	}

	// product 테이블에서 select로 필요한 정보 추출
	public static ReleHistVO getProdInfo(String prodID) {
		System.out.println(className + ".getProdInfo()");
		ReleHistVO vo = new ReleHistVO();

		if (conn != null) {
			PreparedStatement ps = null;
			ResultSet rs = null;
			String sql = "SELECT product_id,product_name,category,is_new,standard,price FROM product "
					+ "WHERE product_id=?";

			try {
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
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			Libs.close(rs);
			Libs.close(ps);
		}
		return vo;
	}

	// release_history에 값 저장하기
	public static int insert(ReleHistVO vo) {
		System.out.println(className + ".insert()");
		int result = 0;
		PreparedStatement ps = null;

		if (conn != null) {
			// + "'peter','PROD_1000000004','드레스','상의','Y','100','49000', "
			String sql = "INSERT INTO release_history VALUES(seq_rele.NEXTVAL, " + "?,?,?,?,?,?,?, "
					+ "'입금완료',sysdate,sysdate)";

			try {
				ps = conn.prepareStatement(sql);
				int idx = 0;
				System.out.println("-------release_history 에 입력할 값----------");
				System.out.println(vo);

				ps.setString(++idx, vo.getUserId());
				ps.setString(++idx, vo.getProdId());
				ps.setString(++idx, vo.getProdName());
				ps.setString(++idx, vo.getCaregory());
				ps.setString(++idx, vo.getIsNew());
				ps.setString(++idx, vo.getStandard());
				ps.setLong(++idx, vo.getPrice());

				int rtv = ps.executeUpdate();

				if (rtv == 1) {// 성공시
					result = 1;
				}
			} catch (Exception ex) {
				ex.printStackTrace();
				return -1;// 실패시
			} finally {
				Libs.close(ps);
			}
		}

		return result;
	}

	// PayDAO의 insert 구현
	public static int insertPay(PayVO vo) {
		PayDAO payDAO = new PayDAO();
		payDAO.insert(conn, vo, true);

		// 제일 마지막으로 사용되는 메소드에 커밋 실행
		try {
			conn.commit();

		} catch (Exception e) {
			System.out.println("RelePayDAO 커밋 실패!");
			e.printStackTrace();
		} finally {// 마지막엔 오토커밋을 다시 true로
			try {
				conn.setAutoCommit(true);
			} catch (Exception e2) {
				System.out.println("RelePayDAO 오토커밋 실패!");
				e2.printStackTrace();
			}
		}

		return 1;
	}

}
