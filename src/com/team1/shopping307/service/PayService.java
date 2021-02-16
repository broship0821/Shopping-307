package com.team1.shopping307.service;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team1.shopping307.VO.PayVO;
import com.team1.shopping307.VO.ProdVO;

public interface PayService {
   public ArrayList<PayVO> selectAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;   
   public PayVO selectOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
   public long insert(HttpServletRequest request, HttpServletResponse response) throws ParseException, ServletException, IOException;  
   public int update(HttpServletRequest request, HttpServletResponse response) throws ParseException, ServletException, IOException;
   public int delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
   public ArrayList<PayVO> getStatus(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
   public int setNextStatus(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
