package com.team1.shopping307.service;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team1.shopping307.VO.BagVO;

public class BagServiceImpl implements BagService {
	@Override
	public ArrayList<BagVO> selectAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		ArrayList<BagVO> bagList = (ArrayList<BagVO>)session.getAttribute("bagList");
		//페이지이동: null일경우 BagSelectAllEmpty.jsp
		//null 아닐경우 BagSelectAll.jsp
		return bagList;
	}
	@Override
	public void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		ArrayList<BagVO> bagList = null;
		if(session.getAttribute("bagList")==null) {
			bagList = new ArrayList<BagVO>();
		} else {
			bagList = (ArrayList<BagVO>)session.getAttribute("bagList");
		}
		
		BagVO bagVO = new BagVO();
		bagVO.setProdName(request.getParameter("prodName"));
		bagVO.setProdPrice(Integer.parseInt(request.getParameter("prodPrice")));
		bagVO.setProdCnt(Integer.parseInt(request.getParameter("prodCnt")));
		bagVO.setProdSize(request.getParameter("prodSize"));
		bagList.add(bagVO);
		
		session.setAttribute("bagList", bagList);
		//페이지 이동: ProdSelectOne.jsp
	}
	@Override
	public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//아직 구현 X
	}
	@Override
	public void deleteAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.setAttribute("bagList", null);//초기화
		//페이지 이동: BagSelectAll.jsp
	}
}
