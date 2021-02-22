package com.team1.shopping307.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.team1.shopping307.Libs.Libs;
import com.team1.shopping307.VO.UserManaVO;

public class LoginManager {
   private static final boolean isTestMode = true; 
   private static final String testSessionId = "_test_session_id_";
   public static HashMap<String, UserManaVO> hmUsers = new HashMap<>();

   // static 초기화 블럭
   static {
      if(isTestMode) {
         // 임시로 Manager를 만들어 등록함
         //hmUsers.put(testSessionId, LoginManagerTemp.createTempUser());
   	   UserManaVO user = new UserManaVO();
   	   user.setUserId("peter");
   	   user.setName("손흥민");
   	   user.setZip(12345);
   	   user.setAddress("seoul");
   	   user.setPhonenumber("01012345678");
   	   user.setRole("A");
   	   hmUsers.put(testSessionId, user);
      }
   }

   public static UserManaVO getUserInfo(HttpServletRequest request) {
      return getUserInfo(request.getSession().getId());
   }

   // 기능: sessionId에 대한 사용자 정보를 응답한다. 단, 등록안 된 sessionId일 경우 bull를 앙답한다. 
   public static UserManaVO getUserInfo(String sessionId) {
      UserManaVO result = null;
      
      if(hmUsers.size() >= 1) {
         if(LoginManager.isTestMode) {
            sessionId = LoginManager.testSessionId;
         }
         
         synchronized (hmUsers) {
            result = hmUsers.get(sessionId); // 없으면 null 응답
         }
      }
      
      return result;
   }
   
   public static boolean setUserInfo(String sessionId, UserManaVO newVo) {
      boolean result = false;

      if (Libs.isNotEmptyExt(sessionId) && newVo != null) {
         synchronized (hmUsers) {
            UserManaVO userVo = hmUsers.get(sessionId);

            if (userVo != null) {
               hmUsers.remove(sessionId);
            }

            hmUsers.put(sessionId, newVo);
         }
      }
      
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
