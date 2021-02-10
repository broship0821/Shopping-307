package com.team1.shopping307.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team1.shopping307.VO.Member1VO;

public interface TelService {
   public void getAllInfo(HttpServletRequest request, HttpServletResponse response) throws Exception;
   public void delInfo(HttpServletRequest request, HttpServletResponse response) throws Exception;
   public void insertInfo(HttpServletRequest request, HttpServletResponse response) throws Exception;
   public void getOneInfo(HttpServletRequest request, HttpServletResponse response) throws Exception;
   public void updateInfo(HttpServletRequest request, HttpServletResponse response) throws Exception;
   
}
