package com.team1.shopping307.service;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team1.shopping307.VO.BagVO;

public interface BagService {
	public ArrayList<BagVO> selectAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
    public void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;  
    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;   
    public void deleteAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;   

}
