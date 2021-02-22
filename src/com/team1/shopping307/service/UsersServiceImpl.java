package com.team1.shopping307.service;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.Session;

import com.team1.shopping307.DAO.UserDAO;
import com.team1.shopping307.VO.UserVO;
import com.team1.shopping307.controller.Common;

public class UsersServiceImpl implements UsersService {
   private final String className = "UserServiceImpl";
   private final String prefix = "  > ";

   @Override
   public ArrayList<UserVO> selectAll(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      System.out.println(className + ".selectAll()");
      ArrayList<UserVO> result = new ArrayList<>();
      return result;
   }

   @Override
   public UserVO selectOne(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      System.out.println(className + ".selectOne()");
      UserVO result = new UserVO(); 
     
      return result;   
   }

   @Override
   public int insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      System.out.println(className + ".insert()");
      int result = 0;

      String id = request.getParameter("Id");
      String pw = request.getParameter("pw");
      String name = request.getParameter("name");
      String phone = request.getParameter("phone");
      String role = "U";
      String address = request.getParameter("address");
      String zip = request.getParameter("zip");
      String secession = "N";
      
      UserVO vo = new UserVO(id, pw, name, phone, role, address, zip, secession); 
      result = UserDAO.insert(vo);
      System.out.println(result);
      request.setAttribute("result", result);
      
      /*
      try {
      UserDAO dao = new UserDAO();
      result = dao.insert(id, pw, name, phone, role, address, zip, secession);
      if(result ==1) {
         response.setContentType("text/heml; charset=utf-8");
         PrintWriter writer = response.getWriter();
         writer.println("");
         writer.close();
      }else {
         response.setContentType("text/html; charset=utf-8");
         PrintWriter writer = response.getWriter();
         writer.println("<script>alert('회원가입이 실패하였습니다. 다시 가입해주세요.'); location.href='"+"JoinMembership.jsp"+"';</script>");
         writer.close();
      }
   } catch (Exception e) {
      e.printStackTrace();
   }
      // result = UsersDAO.insert(name, ...); 호출
      System.out.println(result);
      */

      return result;
   }

   @Override
   public int update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      System.out.println(className + ".update()");
      int result = 0;
      return result;
   }

   @Override
   public int delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      System.out.println(className + ".delete()");
      int result = 0;
      return result;
   }

   @Override
   public String checkLogin(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      System.out.println(className + ".checkLogin()");
      request.setCharacterEncoding("utf-8");
      response.setCharacterEncoding("utf-8");

      String id = request.getParameter("userId");
      String pw = request.getParameter("userPw");
      String name = UserDAO.checkLogin(id, pw);
      String ok = null;
      
      if (name != null) { 
         System.out.println(name);
         ServletContext app = request.getServletContext();
         app.setAttribute("name", name);
         request.setAttribute("name", name);
         ok = "UserLoginCheck";
      } else {
         System.out.println("여기 왔니?");
         String error = "아이디 없거나 비밀번호가 맞지 않습니다.";
         request.setAttribute("error", error);
         ok = Common.strUserLogin;
      }
      	
      
      return ok;
   }

   @Override
   public String checkLogout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      System.out.println(className + ".chkLogout()");
      String result = "";
      ServletContext app = request.getServletContext();
      app.removeAttribute("name");
      app.removeAttribute("Id");
      result = Common.strProdSelectAll;
      return result;
   }
   @Override
   public String findId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   System.out.println(className + ".findId()");
	   String result = "";
	   request.setCharacterEncoding("utf-8");
	   response.setCharacterEncoding("utf-8");
	   
	   String name = request.getParameter("name");
	   String phone = request.getParameter("phone");
	   String id    = UserDAO.findId(name, phone);
	   String ok    = null;
	   if(id != null) {
		request.setAttribute("id", id);
		ok= Common.strUserFindid;
	   }else {
		   System.out.println("이거 출력이지?");
		   String error1 = "연관된 아이디가 없습니다.";
		   request.setAttribute("error", error1);
		   System.out.println(error1);
		   ok = "UserId_Pwfind.jsp";
	   }
	   return ok;
   }
   @Override
   public String findPw(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   System.out.println(className + ".findPw()");
	   String result = "";
	   request.setCharacterEncoding("utf-8");
	   response.setCharacterEncoding("utf-8");
	   
	   String name = request.getParameter("name1");
	   String id = request.getParameter("userID");
	   String pw = UserDAO.findPw(name, id);
	   String ok = null;
	   if(pw != null) {
		   request.setAttribute("pw", pw);
		   ok=Common.strUserFindid;
	   }else {
		   String error1 = "연관된 정보가 없습니다.";
		   request.setAttribute("error1", error1);
		   ok = "UserId_Pwfind.jsp";
	   }
	   return ok;
   }
}
