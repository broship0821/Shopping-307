package com.team1.shopping307.controller;

import com.team1.shopping307.VO.UserManaVO;

public class LoginManagerTemp {
	private void createTempUser() {
		// TODO Auto-generated method stub

	
	   // static 초기화 블럭
	   static {
	      if(isTestMode) {
	         // 임시로 Manager를 만들어 등록함.
	         synchronized (hmUsers) {
	            //hmUsers.put(testSessionId, LoginManagerTemp.createTempUser());
	               UserManaVO user = new UserManaVO();
	                 user.setUserId("ccangse18");
	                 user.setName("손흥민");
	                 user.setZip(12345);
	                 user.setAddress("seoul");
	                 user.setPhonenumber("01012345678");
	                 user.setRole("A");
	                 hmUsers.put(testSessionId, user);
	         }
	      }
	   }
	}
}
