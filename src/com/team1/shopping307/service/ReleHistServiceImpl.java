package com.team1.shopping307.service;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team1.shopping307.DAO.RelePayDAO;
import com.team1.shopping307.VO.PayVO;
import com.team1.shopping307.VO.ReleHistVO;

public class ReleHistServiceImpl implements ReleHistService {

   @Override
   public ArrayList<ReleHistVO> selectAll(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      // 모든 release_history 한눈에 보기
      return null;
   }

   @Override
   public ReleHistVO selectOne(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      // 하나의 release_history 수정 or 삭제 버튼 있음
      return null;
   }

   @Override
   public int insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // 장바구니페이지에서 결제하기 btn 클릭시 페이지 이동하는 역활만 담당
      return 0;
   }

   @Override
   public int update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // 수정한거 db에 반영시키기
      return 0;
   }

   @Override
   public int delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // 하나의 release_history 삭제
      return 0;
   }
   
   @Override
	public int relePayInsert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   //결제페이지에서 보낸 데이터
	   String[] ProdIDs = request.getParameterValues("ProductID");		//상품 번호(상품이 여러개니 배열로 받아야됨)
	   String[] cnt = request.getParameterValues("cnt");				//상품 개수(상품이 여러개니 배열로 받아야됨)
	   String name = request.getParameter("name");						//구매자 이름
	   String zip = request.getParameter("zip");						//구매자 우편번호
	   String address = request.getParameter("address");				//구매자 주소
	   String tel = request.getParameter("tel");						//구매자 전화번호
	   String cashOrCard = request.getParameter("cashOrCard");			//'C':카드, 'S':현금, 'B':무통장입금
	   String cardNo = request.getParameter("cardNO");					//카드번호
	   
	   /* 하나의 트렌젝션으로 처리해야됨
		 1. 장바구니 세션 null로 바꾸기
		 2. 먼저 select로 필요한 Product 정보 추출(product_name,category,is_new,standard,price)
		 3. select로 꺼내온 Product 정보 + 사용자 입력 정보로 상품별로 각각 release_history에 insert
		 4. select로 꺼내온 Product 정보 + 사용자 입력 정보로 pay_info에 insert
		 5. 맨 마지막에 커밋
		 */
	   
	   // 1. 장바구니 세션 null로 바꾸기
	   HttpSession session = request.getSession();
		session.setAttribute("bagList", null);
		
		//2~4 같은 for문 안에서 처리
		RelePayDAO dao = new RelePayDAO();
		//pay_info에 필요한 items_info, amount
		StringBuffer itemsInfo = new StringBuffer();
		int amount = 0;
		
		int result1 = 0;
		for(int i=0;i<ProdIDs.length;i++) {
			//2. 먼저 select로 필요한 Product 정보 추출
			ReleHistVO vo = dao.getProdInfo(ProdIDs[i]);
			//일단 구매한 유저는 "peter"로 통일 -> 로그인 기능 구현하면 로그인된 유저로 사용
			vo.setUserId("peter");
			//3. 상품별로 각각 release_history에 insert(갯수마다 하나씩 insert)
			int size = Integer.parseInt(cnt[i]);//갯수
			for(int j=0;j<size;j++) {
				result1 = dao.insert(vo);
			}
			//4번에 필요한 items_info, amount 값 넣기
			itemsInfo.append(vo.getProdId()+"-");
			itemsInfo.append(vo.getProdName()+"X");
			itemsInfo.append(size+", ");
			System.out.println("****************************************");
			System.out.println(itemsInfo.toString());
			System.out.println("****************************************");
			amount += vo.getPrice()*size;//물품금액*갯수
		}
		//4. pay_info에 insert
		PayVO payVO = new PayVO();
		//판매자 일단 "undefined" 처리
		payVO.setSellerName("undefined");
		payVO.setSellerPhone("0");
		payVO.setSellerZip("00000");
		payVO.setSellerAddress("undefined");
		//일단 구매한 유저는 "peter"로 통일 -> 로그인 기능 구현하면 로그인된 유저로 사용
		payVO.setBuyerId("peter");
		payVO.setBuyerName(name);
		payVO.setBuyerPhone(tel);
		payVO.setBuyerZip(zip);
		payVO.setBuyerAddress(address);
		payVO.setItemsInfo(itemsInfo.toString());
		payVO.setAmount(amount);
		payVO.setCashOrCard(cashOrCard);
		payVO.setCardNo(cardNo);
		payVO.setStatus("입금완료");
		System.out.println("****************************************");
		System.out.println(payVO);
		System.out.println("****************************************");
		int result2 = dao.insertPay(payVO);
	   
		return 0;
	}
}
