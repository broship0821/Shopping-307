package com.team1.shopping307.service;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team1.shopping307.DAO.CateDAO;
import com.team1.shopping307.VO.CateVO;

public class CateServiceImpl implements CateService{

   @Override
   public ArrayList<CateVO> selectAll(HttpServletRequest request, HttpServletResponse response) 
         throws ServletException, IOException {
      ArrayList<CateVO> lstResult = CateDAO.selectAll();
      request.setAttribute("lstAll", lstResult);
      return lstResult;
   }

   @Override
   public CateVO selectOne(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      String name = (String) request.getParameter("name");
      CateVO result = CateDAO.selectOne(name);
      request.setAttribute("item", result);
      return result;
   }

   @Override
   public int insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String name = (String) request.getParameter("name");
      String bigo = (String) request.getParameter("bigo");
      int result = CateDAO.insert(name, bigo);
      request.setAttribute("result", result >= 1 ? "등록 성공" : "등록 실패");
      return result;
   }

   @Override
   public int update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String name = (String) request.getParameter("name");
      String bigo = (String) request.getParameter("bigo");
      int result = CateDAO.update(name, bigo);
      request.setAttribute("result", result >= 1 ? "수정 성공" : "수정 실패");
      return result;
   }

   @Override
   public int delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String name = (String) request.getParameter("name");
      int result = CateDAO.delete(name);
      request.setAttribute("result", result >= 1 ? "삭제 성공" : "삭제 실패");
      return result;
   }
   
}
