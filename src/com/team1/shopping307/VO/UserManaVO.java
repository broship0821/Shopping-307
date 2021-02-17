package com.team1.shopping307.VO;

import java.text.ParseException;
import java.util.Date;

import com.team1.shopping307.Libs.Libs;

public class UserManaVO {
   String userId;          // 아이디     
   String name;            // 이름
   String phonenumber;     // 전화번호
   String role;            // 'U':일반유저, 'M':매니저, 'A':Admin
   String address;         // 주소
   String zip;             // 우편번호
   String secession;       // 'N':탈퇴안함, 'S':탈퇴함
   
   public String getUserId() {
      return userId;
   }

   public void setUserId(String userId) {
      this.userId = userId;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getPhonenumber() {
      return phonenumber;
   }

   public void setPhonenumber(String phonenumber) {
      this.phonenumber = phonenumber;
   }

   public String getRole() {
      return role;
   }

   public void setRole(String role) {
      this.role = role;
   }

   public String getAddress() {
      return address;
   }

   public void setAddress(String address) {
      this.address = address;
   }

   public String getZip() {
      return zip;
   }

   public void setZip(String zip) {
      this.zip = zip;
   }

   public String getSecession() {
      return secession;
   }

   public void setSecession(String secession) {
      this.secession = secession;
   }

   public UserManaVO() {
   }

   public UserManaVO(String userId, String name,
         String phonenumber, String role, String address, String zip, String secession) {
      this.userId      = userId;     
      this.name        = name;
      this.phonenumber = phonenumber;
      this.role        = role;
      this.address     = address;
      this.zip         = zip;
      this.secession   = secession;
   }

   @Override
   public String toString() {
      return "userId : " + userId     
         + ", name: " + name
         + ", phonenumber: " + phonenumber
         + ", role: " + role
         + ", address: " + address
         + ", zip: " + zip
         + ", secession: " + secession;
   }
   
   public UserManaVO loadFrom(UsersVO voSrc) {
      return voSrc != null
            ? new UserManaVO(
                  voSrc.getUserId(),
                  voSrc.getName(),
                  voSrc.getPhonenumber(),
                  voSrc.getRole(),
                  voSrc.getAddress(),
                  voSrc.getZip(),
                  voSrc.getSecession()
              )
            : null;
   }

}
