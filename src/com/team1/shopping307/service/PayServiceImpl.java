package com.team1.shopping307.service;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team1.shopping307.DAO.PayDAO;
import com.team1.shopping307.VO.PayVO;

public class PayServiceImpl implements PayService {
   private final String className = "PayServiceImpl";
   private final String prefix = "  > ";
   
   @Override
   public ArrayList<PayVO> selectAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      System.out.println(className + ".selectAll()");
      ArrayList<PayVO> lstResult = PayDAO.selectAll();
      request.setAttribute("lstAll", lstResult);
      return lstResult;
   }

   @Override
   public PayVO selectOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      System.out.println(className + ".selectOne()");
      String payId = (String) request.getParameter("payId");
      PayVO result = PayDAO.selectOne(Integer.valueOf(payId));
      request.setAttribute("item", result);
      return result;   
   }
   
   @Override
   public long insert(HttpServletRequest request, HttpServletResponse response) throws ParseException, ServletException, IOException {
      System.out.println(className + ".insert()");
      PayVO vo = getRequestParams(request);
      long result = PayDAO.insert(vo);
      request.setAttribute("result", result == 0 ? "등록 실패" : "상품아이디(" + result + ") 등록 성공");
      return result;
   }

   private PayVO getRequestParams(HttpServletRequest request) throws ParseException {
      // 구분번호   YYYYMMDDNNNNN
      String payId = (String) request.getParameter("payId"); 

      // 판매자 이름
      String sellerName = (String) request.getParameter("sellerName");       

      // 판매자 전화번호
      String sellerPhone = (String) request.getParameter("sellerPhone");
      
      // 판매자 우편번호(우편번호 검색 기능은 생략)
      String sellerZip = (String) request.getParameter("sellerZip");
      
      // 판매자 주소
      String sellerAddress = (String) request.getParameter("sellerAddress");   
             
      //구매자 아이디
      String  buyerId = (String) request.getParameter("buyerId");
      
      // 구매자 이름
      String buyerName = (String) request.getParameter("buyerName");
      
      // 구매자 전화번호
      String buyerPhone = (String) request.getParameter("buyerPhone");
      
      // 구매자 우편번호
      String buyerZip = (String) request.getParameter("buyerZip");
      
      // 구매자 주소
      String buyerAddress = (String) request.getParameter("buyerAddress");    

      // 상품 정보(수량, 품목 리스트)
      String itemsInfo = (String) request.getParameter("itemsInfo");
      
      // 결제금액
      String amount = (String) request.getParameter("amount");
      
      // 'C':카드, 'S':현금, 'B':무통장입금
      String cashOrCard = (String) request.getParameter("cashOrCard");
      
      // 카드번호
      String cardNo = (String) request.getParameter("cardNo");

      // 상태('입금완료', '결제승인', '출고', '교환', '환불', '구매완료')
      String status = (String) request.getParameter("status");

      PayVO result = new PayVO(payId, sellerName, sellerPhone, sellerZip, sellerAddress,
                           buyerId, buyerName, buyerPhone, buyerZip, buyerAddress, itemsInfo,
                           amount, cashOrCard, cardNo, status);
      return result;
   }

   @Override
   public int update(HttpServletRequest request, HttpServletResponse response) throws ParseException, ServletException, IOException {
      System.out.println(className + ".update()");
      PayVO vo = getRequestParams(request);
      int result = PayDAO.update(vo);
      request.setAttribute("result", result == 1 ? "수정 성공" : "수정 실패");
      return result;
   }

   @Override
   public int delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      System.out.println(className + ".delete()");
      String payId = (String) request.getParameter("payId"); 
      int result = PayDAO.delete(Integer.valueOf(payId));
      request.setAttribute("result", result == 1 ? "삭제 성공" : "삭제 실패");
      return result;
   }

   @Override
   public ArrayList<PayVO> getStatus(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      System.out.println(className + ".getStatus()");
      String status = (String) request.getParameter("status"); 
      ArrayList<PayVO> lstResult = PayDAO.getStatus(status);
      request.setAttribute("lstAll", lstResult);
      return lstResult;
   }

   @Override
   public int setNextStatus(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      System.out.println(className + ".setStatus()");
      String payId = (String) request.getParameter("payId"); 
      String status = (String) request.getParameter("payId"); 
      int result = PayDAO.setNextStatus(Integer.valueOf(payId), status);
      request.setAttribute("result", result == 1 ? "상태 변경 성공" : "상태 변경 실패");
      return result;
   }

}
