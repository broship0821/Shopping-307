package com.team1.shopping307.service;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team1.shopping307.DAO.RevuDAO;
import com.team1.shopping307.VO.RevuVO;
import com.team1.shopping307.controller.LoginManager;

public class RevuServiceImpl implements RevuService {

	@Override
	public ArrayList<RevuVO> selectAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RevuDAO dao = new RevuDAO();
		ArrayList<RevuVO> list = dao.selectAll();
		request.setAttribute("list", list);
		return null;
	}

	@Override
	public RevuVO selectOne(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RevuDAO dao = new RevuDAO();
		RevuVO vo = dao.selectOne(Integer.parseInt(request.getParameter("id")));
		request.setAttribute("r", vo);
		return null;
	}

	@Override
	public int insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 현재 로그인 사용자 정보 가져오기
		String userID = LoginManager.getUserInfo(request).getUserId();
		request.setAttribute("userID", userID);
		System.out.println(request.getParameter("productId"));
		return 0;
	}
	@Override
	public int insertResult(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RevuDAO dao = new RevuDAO();
		RevuVO vo = new RevuVO();
		vo.setUserId(request.getParameter("userID"));
		vo.setUserName(request.getParameter("userName"));
		vo.setProductID(request.getParameter("prodID"));
		vo.setProductName(request.getParameter("prodName"));
		vo.setStar(Integer.parseInt(request.getParameter("star")));
		vo.setTitle(request.getParameter("title"));
		vo.setContent(request.getParameter("content"));
		int result = dao.insert(vo);
		request.setAttribute("p", (result!=0)?"성공":"실패");
		request.setAttribute("reviewPage", result);
		return 0;
	}

	@Override
	public String update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RevuDAO dao = new RevuDAO();
		String userID = LoginManager.getUserInfo(request).getUserId();
		int reviewID = Integer.parseInt(request.getParameter("id"));
		int check = dao.userCheck(reviewID, userID);
		
		if(check==1) {
			request.setAttribute("reviewID", reviewID);
			RevuVO vo = new RevuVO();
			vo.setUserId(request.getParameter("userID"));
			vo.setProductName(request.getParameter("prodName"));
			vo.setStar(Integer.parseInt(request.getParameter("star")));
			vo.setTitle(request.getParameter("title"));
			vo.setContent(request.getParameter("content"));
			request.setAttribute("r", vo);
			return "RevuUpdate";
		} else
			return "RevuUserCheck";
	}
	@Override
	public int updateResult(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RevuVO vo = new RevuVO();
		vo.setReviewId(Integer.parseInt(request.getParameter("reviewID")));
		vo.setStar(Integer.parseInt(request.getParameter("star")));
		vo.setTitle(request.getParameter("title"));
		vo.setContent(request.getParameter("content"));
		
		RevuDAO dao = new RevuDAO();
		int result = dao.update(vo);
		request.setAttribute("p", (result==1)?"성공":"실패");
		return 0;
	}

	@Override
	public String delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RevuDAO dao = new RevuDAO();
		String userID = LoginManager.getUserInfo(request).getUserId();
		int reviewID = Integer.parseInt(request.getParameter("id"));
		int check = dao.userCheck(reviewID, userID);
		
		if(check==1) {//현재 로그인된 유저가 리뷰 작성한 유저
			int result = dao.delete(reviewID);
			request.setAttribute("p", (result==1)?"성공":"실패");
			return "RevuDelete";
		} else {
			return "RevuUserCheck";
		}
	}
}
