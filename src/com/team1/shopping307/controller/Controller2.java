package com.team1.shopping307.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/TelController")
@WebServlet(urlPatterns = { "*.do1" }) // just test
public class Controller2 extends HttpServlet {
   private static final long serialVersionUID = 1L;

   public TelController2() {
      super();
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // response.getWriter().append("Served at: ").append(request.getContextPath());
      request.setCharacterEncoding("UTF-8");
      response.setCharacterEncoding("UTF-8");
      
      TelService svc = new TelServiceImpl();
      String strUri = request.getRequestURI(); // project명/*.do
      String strPath = request.getContextPath(); // project명
      String strMap = strUri.substring(strPath.length());
      String jspName = null;

      System.out.println("TelController2()");
      System.out.println(strUri);
      System.out.println(strPath);
      System.out.println(strMap);

      try {
         switch (strMap) {
         case "/Tel2.do":
            jspName = "telAllView.jsp";
            break;
         }
      }
      catch(Exception e) {
         e.printStackTrace();
      }

      if (jspName != null) {
         // request.getRequestDispatcher(jspName)
         // .forward(request, response);
         RequestDispatcher rd = request.getRequestDispatcher(jspName);
         rd.forward(request, response);
      }
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      doGet(request, response);
   }

}
