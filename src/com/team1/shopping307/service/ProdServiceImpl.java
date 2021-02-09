package com.team1.shopping307.service;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

   @Override
   public int insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      System.out.println("ProdServiceImpl.insert()");
      int result = 0; 
      String name = request.getParameter("ProdName");
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
