package com.team1.shopping307.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team1.shopping307.DAO.Member1DAO;
import com.team1.shopping307.VO.Member1VO;

public class TelServiceImpl implements TelService {

   @Override
   public void getAllInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
      ArrayList<Member1VO> lstAll = Member1DAO.selectAll();
      request.setAttribute("lstAll", lstAll);
   }

   @Override
   public void delInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
      String id = (String) request.getParameter("id");
      int result = Member1DAO.delete(id);
      request.setAttribute("result", result >= 1 ? "삭제 성공" : "삭제 실패");
   }

   @Override
   public void insertInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
      String id = (String) request.getParameter("id");
      String name = (String) request.getParameter("name");
      String tel = (String) request.getParameter("tel");
      String date = (String) request.getParameter("date");
      int result = Member1DAO.insert(id, name, tel, date);
      request.setAttribute("result", result >= 1 ? "등록 성공" : "수정 실패");
   }

   @Override
   public void getOneInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
      String id = (String) request.getParameter("id");
      Member1VO one = Member1DAO.selectOne(id);
      request.setAttribute("item", one);
   }

   @Override
   public void updateInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
      String id = (String) request.getParameter("id");
      String date = (String) request.getParameter("date");
      int result = Member1DAO.update(id, date);
      request.setAttribute("result", result >= 1 ? "수정 성공" : "수정 실패");
   }
}
