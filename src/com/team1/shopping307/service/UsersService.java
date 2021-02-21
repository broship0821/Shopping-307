package com.team1.shopping307.service;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team1.shopping307.VO.UserVO;

public interface UsersService {
   public ArrayList<UserVO> selectAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;   
   public UserVO selectOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
   public int insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;  
   public int update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException; 
   public int delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;   
   public String checkLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
   public String checkLogout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
   public String findId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
   public String findPw(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
