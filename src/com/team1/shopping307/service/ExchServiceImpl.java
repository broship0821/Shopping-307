package com.team1.shopping307.service;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team1.shopping307.DAO.ExchDAO;
import com.team1.shopping307.Libs.Libs;
import com.team1.shopping307.VO.ExchVO;

public class ExchServiceImpl implements ExchService {
   private final String className = "ExchServiceImpl";
   private final String prefix = "  > ";
   
   @Override
   public ArrayList<ExchVO> selectAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      System.out.println(className + ".selectAll()");
      ArrayList<ExchVO> lstResult = ExchDAO.selectAll();
      request.setAttribute("lstAll", lstResult);
      return lstResult;
   }

   @Override
   public ExchVO selectOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      System.out.println(className + ".selectOne()");
      String exchangeId = (String) request.getParameter("exchangeId");
      ExchVO result = ExchDAO.selectOne(exchangeId);
      request.setAttribute("item", result);
      return result;   
   }
   
   @Override
   public String insert(HttpServletRequest request, HttpServletResponse response) throws ParseException, ServletException, IOException {
      System.out.println(className + ".insert()");
      ExchVO vo = getRequestParams(request);
      String result = ExchDAO.insert(vo);
      request.setAttribute("result", Libs.isEmpty(result) ? "등록 실패" : "상품아이디(" + result + ") 등록 성공");
      return result;
   }

   private ExchVO getRequestParams(HttpServletRequest request) throws ParseException {
      // 교환/환불ID
      String exchangeId = (String) request.getParameter("exchangeId"); 

      // 구매ID
      String payId = (String) request.getParameter("payId");              

      // ‘E’:교환, ‘R’:환불
      String exchangeOrRefund = (String) request.getParameter("exchangeOrRefund");              

      // 상태('교환신청', '환불신청', '교환완료', '환불완료'))
      String status = (String) request.getParameter("status");          

      ExchVO result = new ExchVO(exchangeId, payId, exchangeOrRefund, status);

      return result;
   }

   @Override
   public int update(HttpServletRequest request, HttpServletResponse response) throws ParseException, ServletException, IOException {
      System.out.println(className + ".update()");
      ExchVO vo = getRequestParams(request);
      int result = ExchDAO.update(vo);
      request.setAttribute("result", result == 1 ? "수정 성공" : "수정 실패");
      return result;
   }

   @Override
   public int delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      System.out.println(className + ".delete()");
      String exchangeId = (String) request.getParameter("exchangeId"); 
      int result = ExchDAO.delete(exchangeId);
      request.setAttribute("result", result == 1 ? "삭제 성공" : "삭제 실패");
      return result;
   }
}
