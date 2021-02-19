package com.team1.shopping307.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.team1.shopping307.VO.UserManaVO;

public class LoginManager {
   private static final boolean isTestMode = true; 
   private static final String testSessionId = "_test_session_id_";
   public static HashMap<String, UserManaVO> hmUsers = new HashMap<>();

   // static 초기화 블럭
   static {
      if(isTestMode) {
         // 임시로 Manager를 만들어 등록함
         hmUsers.put(testSessionId, LoginManagerTemp.createTempUser());
      }
   }

   public static UserManaVO getUserInfo(HttpServletRequest request) {
      String sessionId = LoginManager.isTestMode 
            ? LoginManager.testSessionId
            : request.getSession().getId();
      return getUserInfo(sessionId);
   }

   // 기능: sessionId에 대한 사용자 정보를 응답한다.
   public static UserManaVO getUserInfo(String sessionId) {
      UserManaVO result = null;
      
      if(hmUsers.size() >= 1) {
         if(LoginManager.isTestMode) {
            sessionId = LoginManager.testSessionId;
         }
         
         result = hmUsers.get(sessionId); 
      }
      
      return result;
   }
   
   public static boolean setUserInfo(String sessionId, UserManaVO vo) {
      boolean result = false;

      return result;
   }

   // TODO: DB에서 관리자 ID(Common.strManagerId)릏 읽도록 구현해야 함.
   public static UserManaVO getSellerInfo() {
      UserManaVO result = new UserManaVO(
            Common.strManagerId, "몰쥔", "01099999999", "M", "서울특별시 영등포구", "99999", "N"      
      );
      return result;
      
   }

   // 기능: sessionId에 대한 Login 여부를 검색하여 login한 user이면 그의 role를 응답
   public static String getUserRole(String sessionId) {
      String result = Common.strAnynimous;
      
      // TODO: 여기에 나머지 부분 추가
      
      // 개발 중... 강제로 Admin role 부여
      if(hmUsers.size() >= 1) {
         UserManaVO vo = hmUsers.get(0); 
         result = vo.getRole();
      }
      
      return result;
   }

}
