package com.team1.shopping307.VO;

import java.text.ParseException;
import java.util.Date;

import com.team1.shopping307.Libs.Libs;

public class LogHistVO {
   String userId;          // 아이디     
   Date loginTime;         // 로그인 시간
   Date logoutTime;        // 로그아웃 시간
   
   public String getUserId() {
      return userId;
   }

   public void setUserId(String userId) {
      this.userId = userId;
   }

   public Date getLoginTime() {
      return loginTime;
   }

   public void setLoginTime(Date loginTime) {
      this.loginTime = loginTime;
   }

   public Date getLogoutTime() {
      return logoutTime;
   }

   public void setLogoutTime(Date logoutTime) {
      this.logoutTime = logoutTime;
   }

   public LogHistVO() {
   }

   @Override
   public String toString() {
      return "userId: " + userId 
            + ", login: " + Libs.dateTimeToStr(loginTime)
            + ", logout: " + Libs.dateTimeToStr(logoutTime);
   }

}
