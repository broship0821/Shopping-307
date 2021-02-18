package com.team1.shopping307.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.team1.shopping307.VO.UserManaVO;

public class LoginManager {
   public static ArrayList<UserManaVO> lstUsers = new ArrayList<>();

   // static 초기화 블럭
   static {
      // 임시로 Manager를 만들어 등록함
      lstUsers.add(LoginManagerTemp.createTempUser());
   }

   public static UserManaVO getUserInfo(HttpServletRequest request) {
      HttpSession session = request.getSession();
      return getUserInfo(session.getId());
   }

   // 기능: sessionId에 대한 사용자 정보를 응답한다.
   public static UserManaVO getUserInfo(String sessionId) {
      UserManaVO result = null;
      
      if(lstUsers.size() >= 1) {
         result = lstUsers.get(0); 
      }
      
      return result;
   }
   
   // 기능: sessionId에 대한 Login 여부를 검색하여 login한 user이면 그의 role를 응답
   public static String getUserRole(String sessionId) {
      String result = Common.strAnynimous;
      
      // TODO: 여기에 나머지 부분 추가
      
      // 개발 중... 강제로 Admin role 부여
      if(lstUsers.size() >= 1) {
         UserManaVO vo = lstUsers.get(0); 
         result = vo.getRole();
      }
      
      return result;
   }

}
