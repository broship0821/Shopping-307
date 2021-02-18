package com.team1.shopping307.service;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team1.shopping307.DAO.RelePayDAO;
import com.team1.shopping307.VO.ReleHistVO;
import com.team1.shopping307.VO.UserManaVO;
import com.team1.shopping307.controller.LoginManager;

public class ReleHistServiceImpl implements ReleHistService {

	@Override
	public ArrayList<ReleHistVO> selectAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 모든 release_history 한눈에 보기
		return null;
	}

	@Override
	public ReleHistVO selectOne(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 하나의 release_history 수정 or 삭제 버튼 있음
		return null;
	}

	@Override
	public int insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 장바구니페이지에서 결제하기 btn 클릭시 사용자 정보 입력하는 창으로 이동
		UserManaVO user = LoginManager.getUserInfo(request);
		request.setAttribute("u", user);
		return 0;
	}

	@Override
	public int update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 수정한거 db에 반영시키기
		return 0;
	}

	@Override
	public int delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 하나의 release_history 삭제
		return 0;
	}

	@Override
	public int relePayInsert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int result = new RelePayDAO().insertRelePay(request, response);
		HttpSession session = request.getSession();
		if (result==1)//db처리가 모두 성공일 경우 장바구니 세션 삭제
			session.setAttribute("bagList", null);
		String pay = (result==1)?"성공":"실패";
		request.setAttribute("p", pay);

		return result;
	}
}
