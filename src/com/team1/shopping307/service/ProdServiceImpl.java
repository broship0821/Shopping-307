package com.team1.shopping307.service;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team1.shopping307.DAO.ProdDAO;
import com.team1.shopping307.VO.ProdVO;

public class ProdServiceImpl implements ProdService {
   private final String className = "ProdServiceImpl";
   
   @Override
   public ArrayList<ProdVO> selectAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      System.out.println(className + ".selectAll()");
      ArrayList<ProdVO> lstResult = ProdDAO.selectAll();
      request.setAttribute("lstAll", lstResult);
      return lstResult;
   }

   @Override
   public ProdVO selectOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      System.out.println(className + ".selectOne()");
      String productId = (String) request.getParameter("productId");
      ProdVO result = ProdDAO.selectOne(productId);
      request.setAttribute("item", result);
      return result;   
   }
   
   @Override
   public String insert(HttpServletRequest request, HttpServletResponse response) throws ParseException, ServletException, IOException {
      System.out.println(className + ".insert()");
      ProdVO vo = getRequesParams(request);
      String result = ProdDAO.insert(vo);
      request.setAttribute("result", result != null ? "상품아이디(" + result + ") 등록 성공" : "등록 실패");
      return result;
   }

   private ProdVO getRequesParams(HttpServletRequest request) throws ParseException {
      // 상품ID
      String productId = (String) request.getParameter("productId"); 

      // 상품명
      String productName = (String) request.getParameter("productName");

      // 카테고리
      String category = (String) request.getParameter("category");
  
      // 신상/이월
      String isNew = (String) request.getParameter("isNew");
  
      // 규격
      String standard = (String) request.getParameter("standard");

      // 가격 
      String price = request.getParameter("price");

      // 수량 
      String stock = request.getParameter("stock");
      
      // 상품설명
      String bigo = (String) request.getParameter("bigo");

      // 판매시작일
      String startDate = request.getParameter("startDate"); 

      // 대표 이미지
      String image1 = (String) request.getParameter("image1");

      // 상세이미지1
      String image2 = (String) request.getParameter("image2");
  
      // 상세이미지2
      String image3 = (String) request.getParameter("image3");

      ProdVO result = new ProdVO(productId, productName, category, isNew, standard,
                     price, stock, bigo, startDate, image1, image2, image3);
      
      return result;
   }

   @Override
   public int update(HttpServletRequest request, HttpServletResponse response) throws ParseException, ServletException, IOException {
      System.out.println(className + ".update()");
      ProdVO vo = getRequesParams(request);
      int result = ProdDAO.update(vo);
      request.setAttribute("result", result == 1 ? "수정 성공" : "수정 실패");
      return result;
   }

   @Override
   public int delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      System.out.println(className + ".delete()");
      String productId = (String) request.getParameter("productId"); 
      int result = ProdDAO.delete(productId);
      request.setAttribute("result", result == 1 ? "삭제 성공" : "삭제 실패");
      return result;
   }
}
