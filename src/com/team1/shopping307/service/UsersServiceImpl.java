package com.team1.shopping307.service;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team1.shopping307.VO.ProdVO;
import com.team1.shopping307.VO.UsersVO;

public class UsersServiceImpl implements UsersService {

   @Override
   public ArrayList<UsersVO> selectAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      System.out.println("UsersServiceImpl.selectAll()");
      ArrayList<UsersVO> result = new ArrayList<>();
      return result;
   }

   @Override
   public UsersVO selectOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      System.out.println("UsersServiceImpl.selectOne()");
      UsersVO result = null;
      return result;
   }

   @Override
   public int insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      System.out.println("UsersServiceImpl.insert()");
      int result = 0; 
      
      // ...
      // result = UsersDAO.insert(name, ...); 호출
      result = 1; // 강제로 Ok 설정함
      return result;
   }

   @Override
   public int update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      System.out.println("UsersServiceImpl.update()");
      int result = 0; 
      return result;
   }

   @Override
   public int delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      System.out.println("UsersServiceImpl.delete()");
      int result = 0; 
      return result;
   }
}
