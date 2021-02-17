package com.team1.shopping307.controller;

import java.util.ArrayList;

import com.team1.shopping307.VO.UserManaVO;

public class LoginManager {
   public static ArrayList<UserManaVO> lstUsers = new ArrayList<>();

   // static 초기화 블럭
   static {
      String userId = "yskim";
      String name = "ys김";
      String phonenumber = "01011111111";
      String role = "A";
      String address = "서울시 서울특별시 강남구 반포동 123-4";
      String zip = "11111";
      String secession = "N";
            
      lstUsers.add(new UserManaVO(userId, name, phonenumber, role, address, zip, secession));
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

   public static UserManaVO getUserInfo(String sessionId) {
      UserManaVO result = null;
      
      if(lstUsers.size() >= 1) {
         result = lstUsers.get(0); 
      }
      
      return result;
   }
   
}
