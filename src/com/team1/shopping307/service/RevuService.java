package com.team1.shopping307.service;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team1.shopping307.VO.RevuVO;

public interface RevuService {
	public ArrayList<RevuVO> selectAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	public RevuVO selectOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
    public int insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;  
    public int insertResult(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;  
    public String update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException; 
    public int updateResult(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException; 
    public String delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;   
}
