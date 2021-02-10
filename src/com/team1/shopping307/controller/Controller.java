package com.team1.shopping307.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team1.shopping307.service.ProdService;
import com.team1.shopping307.service.ProdServiceImpl;

//@WebServlet("/TelController")
@WebServlet(urlPatterns = { "*.do", "/" })
public class Controller extends HttpServlet {
   private static final long serialVersionUID = 1L;
      
   public Controller() {
      super();
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // response.getWriter().append("Served at: ").append(request.getContextPath());
      request.setCharacterEncoding("UTF-8");
      response.setCharacterEncoding("UTF-8");
      
      //TelService svc = new TelServiceImpl();
      String strUri = request.getRequestURI(); // project명/*.do
      String strPath = request.getContextPath(); // project명
      String strMap = strUri.substring(strPath.length() + 1);
      String jspName = null;
      
      System.out.println("Controller()");
      System.out.println(strUri);
      System.out.println(strPath);
      System.out.println("요청주소: " + strMap);

      try {
         switch (strMap) {
         case Common.strUsersSelectAllDo:
            //svc.selectALL(request, response);
            //jspName =  Common.strUsersSelectAll;
            break;

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

            
//         case "/TelAllInfo.do":
//            svc.getAllInfo(request, response);
//            jspName = "telAllView.jsp";
//            break;
//   
//         case "/TelDelInfo.do":
//            svc.delInfo(request, response);
//            jspName = "telResultView.jsp";
//            break;
//   
//         case "/TelInsertInfo.do":
//            svc.insertInfo(request, response);
//            jspName = "telResultView.jsp";
//            break;
//   
//         case "/TelOneInfo.do":
//            svc.getOneInfo(request, response);
//            jspName = "telOneView.jsp";
//            break;
//   
//         case "/TelUpdateInfo.do":
//            svc.updateInfo(request, response);
//            jspName = "telResultView.jsp";
//            break;
         }
      }
      catch(Exception e) {
         e.printStackTrace();
      }

      if (jspName != null) {
         jspName += Common.strJsp;
         System.out.println("처리 후 호출 jsp: " + jspName);
         
         // request.getRequestDispatcher(jspName)
         // .forward(request, response);
         RequestDispatcher rd = request.getRequestDispatcher(jspName);
         rd.forward(request, response);
      }
      else {
         // login
      }
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      doGet(request, response);
   }

}
