package com.team1.shopping307.service;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team1.shopping307.DAO.CateDAO;
import com.team1.shopping307.VO.ProdVO;

public class ProdServiceImpl implements ProdService {

   @Override
   public ArrayList<ProdVO> selectAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      System.out.println("ProdServiceImpl.selectAll()");
      ArrayList<ProdVO> result = new ArrayList<>();
      return result;
   }

   @Override
   public ProdVO selectOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      System.out.println("ProdServiceImpl.selectOne()");
      ProdVO result = null;
      return result;
   }
   /*public int insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      String name = (String) request.getParameter("name");
	      String bigo = (String) request.getParameter("bigo");
	      int result = CateDAO.insert(name, bigo);
	      request.setAttribute("result", result >= 1 ? "등록 성공" : "등록 실패");
	      return result;
	   }*/
   @Override
   public int insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  Date startDate = java.sql.Date.valueOf(request.getParameter("startDate")); 
	  String productId = (String) request.getParameter("productId");
	  String isNew = (String) request.getParameter("isNew");
	  String productName = (String) request.getParameter("productName");
	  String category = (String) request.getParameter("category");
	  String standard = (String) request.getParameter("standard");
	  long price = Integer.parseInt(request.getParameter("price"));
	  long stock = Integer.parseInt(request.getParameter("stock"));
	  String image1 = (String) request.getParameter("image1");
	  String image2 = (String) request.getParameter("image2");
	  String image3 = (String) request.getParameter("image3");
	  
      int result = 0;
      
      // ...
      // result = ProdDAO.insert(name, ...); 호출
      result = 1; // 강제로 Ok 설정함
      return result;
   }

   @Override
   public int update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      System.out.println("ProdServiceImpl.update()");
      int result = 0; 
      return result;
   }

   @Override
   public int delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      System.out.println("ProdServiceImpl.delete()");
      int result = 0; 
      return result;
   }
}
