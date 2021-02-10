package com.team1.shopping307.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team1.shopping307.Libs.Libs;
import com.team1.shopping307.service.ProdService;
import com.team1.shopping307.service.ProdServiceImpl;
import com.team1.shopping307.service.TelService;
import com.team1.shopping307.service.TelServiceImpl;
import com.team1.shopping307.service.UsersService;
import com.team1.shopping307.service.UsersServiceImpl;

//@WebServlet("/TelController")
@WebServlet(urlPatterns = { "*.do", "/" })
public class Controller extends HttpServlet {
   private static final long serialVersionUID = 1L;
      
   public Controller() {
      super();
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      HttpSession session = request.getSession();

      // response.getWriter().append("Served at: ").append(request.getContextPath());
      request.setCharacterEncoding("UTF-8");
      response.setCharacterEncoding("UTF-8");
      
      String strUri = request.getRequestURI(); // project명/*.do
      String strPath = request.getContextPath(); // project명
      String strMap = strUri.substring(strPath.length() + 1);
      String strSessionId = session.getId();
      String jspName = null;
      
      System.out.println("Controller()");
      System.out.println(strUri);
      System.out.println(strPath);
      System.out.println("요청주소: " + strMap);
      System.out.println("session ID.: " + strSessionId);

      try {
         String strRole = LoginManager.getUserRole(strSessionId);
         System.out.println("Role: " + strRole);
         
         switch (strMap) {
         //--------------------------   
         // 사용자 정보
         //--------------------------
         case Common.strUsersSelectAllDo: {
            UsersService svc = new UsersServiceImpl();
            svc.selectAll(request, response);
            jspName = Common.strUsersSelectAll;
            break;
         }
         case Common.strUsersSelectOneDo: {
            UsersService svc = new UsersServiceImpl();
            svc.selectOne(request, response);
            jspName = Common.strUsersSelectOne;
            break;
         }
         case Common.strUsersInsertDo: {
            UsersService svc = new UsersServiceImpl();
            svc.insert(request, response);
            jspName = Common.strUsersInsert;
            break;
         }
         case Common.strUsersUpdateDo: {
            UsersService svc = new UsersServiceImpl();
            svc.update(request, response);
            jspName = Common.strUsersUpdate;
            break;
         }
         case Common.strUsersDeleteDo: {
            UsersService svc = new UsersServiceImpl();
            svc.delete(request, response);
            jspName = Common.strUsersDelete;
            break;
         }
            
         //--------------------------   
         // 상품 정보
         //--------------------------   
         case Common.strProdSelectAllDo: {
            ProdService svc = new ProdServiceImpl();
            svc.selectAll(request, response);
            jspName = Common.strProdInsertDo;
            break;
         }
         case Common.strProdSelectOneDo: {
            ProdService svc = new ProdServiceImpl();
            svc.selectOne(request, response);
            jspName = Common.strProdSelectOne;
            break;
         }
         case Common.strProdInsertDo: {
            ProdService svc = new ProdServiceImpl();
            svc.insert(request, response);
            jspName = Common.strProdInsert;
            break;
         }
         case Common.strProdUpdateDo: {
            ProdService svc = new ProdServiceImpl();
            svc.update(request, response);
            jspName = Common.strProdUpdate;
            break;
         }
         case Common.strProdDeleteDo: {
            ProdService svc = new ProdServiceImpl();
            svc.delete(request, response);
            jspName = Common.strProdDelete;
            break;
         }

         //--------------------------   
         // TelInfo(Example)
         //--------------------------   
         case "TelAllInfo.do": {
            TelService svc = new TelServiceImpl();
            svc.getAllInfo(request, response);
            jspName = "telAllView.jsp";
            break;
         }   
         case "TelOneInfo.do": {
            TelService svc = new TelServiceImpl();
            svc.getOneInfo(request, response);
            jspName = "telOneView.jsp";
            break;
         }   
         case "TelInsertInfo.do": {
            TelService svc = new TelServiceImpl();
            svc.insertInfo(request, response);
            jspName = "telResultView.jsp";
            break;
         }   
         case "TelUpdateInfo.do": {
            TelService svc = new TelServiceImpl();
            svc.updateInfo(request, response);
            jspName = "telResultView.jsp";
            break;
         }
         case "TelDelInfo.do": {
            TelService svc = new TelServiceImpl();
            svc.delInfo(request, response);
            jspName = "telResultView.jsp";
            break;
         }   
         }
      }
      catch(Exception e) {
         e.printStackTrace();
      }

      if (jspName != null) {
         // jspName이 ".jsp"로 끝나게 만들고 jspName를 호출 
         if(!Libs.getFileExt(jspName).toLowerCase().equals(".jsp")) {
            jspName += Common.strJsp;
         }
         System.out.println("처리 후 호출 jsp: " + jspName);
         
         // request.getRequestDispatcher(jspName)
         // .forward(request, response);
         RequestDispatcher rd = request.getRequestDispatcher(jspName);
         rd.forward(request, response);
      }
      else {
         // login
         System.out.println("처리 후 호출 jsp: null입니다.");
      }
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      doGet(request, response);
   }

}
