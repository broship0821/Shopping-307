package com.team1.shopping307.service;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team1.shopping307.VO.ReleHistVO;

public interface ReleHistService {
   public ArrayList<ReleHistVO> selectAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;   
   public ReleHistVO selectOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
   //결제 btn 클릭 후 사용자 정보 입력하는 화면 띄우는 기능
   public int insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;  
   public int update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException; 
   public int delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
   //insert에서 사용자 정보 입력 후 release_history, pay_info 에 하나의 트랜잭션으로 insert 하는 기능
   public int relePayInsert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
   
}
