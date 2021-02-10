package com.team1.shopping307.controller;

public class LoginManager {
   // 기능: sessionId에 대한 Login 여부를 검색하여 login한 user이면 그의 role를 응답
   public static String getUserRole(String sessionId) {
      String result = Common.strAnynimous;
      
      // TODO: 여기에 나머지 부분 추가
      
      // 개발 중... 강제로 Admin role 부여
      result = Common.strAdmin;
      return result;
   }
}
