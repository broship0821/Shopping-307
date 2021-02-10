package com.team1.shopping307.service;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team1.shopping307.VO.ProdVO;
import com.team1.shopping307.VO.UsersVO;

public interface ProdService {
   public ArrayList<ProdVO> selectAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;   
   public ProdVO selectOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
   public int insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;  
   public int update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException; 
   public int delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;   
}
