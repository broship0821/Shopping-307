package com.team1.shopping307.VO;

public class UserVO {
   String userId;          // 아이디     
   String pw;              // 비밀번호
   String name;            // 이름
   String phonenumber;     // 전화번호
   String role;            // 'U':일반유저, 'M':매니저, 'A':Admin
   String address;         // 주소
   int zip;                // 우편번호
   String secession;       // 'N':탈퇴안함, 'S':탈퇴함
   
   public String getUserId() {
      return userId;
   }

   public void setUserId(String userId) {
      this.userId = userId;
   }

   public String getPw() {
      return pw;
   }

   public void setPw(String pw) {
      this.pw = pw;
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

   public int getZip() {
      return zip;
   }

   public void setZip(int zip) {
      this.zip = zip;
   }

   public String getSecession() {
      return secession;
   }

   public void setSecession(String secession) {
      this.secession = secession;
   }

   public UserVO() {
   }

   public UserVO(String userId, String pw, String name,
         String phonenumber, String role, String address, String zip, String secession) {
      this(userId, pw, name, phonenumber, role, address, 
            Integer.valueOf(zip), secession);
   }

   public UserVO(String userId, String pw, String name,
         String phonenumber, String role, String address, int zip, String secession) {
      this.userId      = userId;     
      this.pw          = pw;
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
         + ", pw: " + pw
         + ", name: " + name
         + ", phonenumber: " + phonenumber
         + ", role: " + role
         + ", address: " + address
         + ", zip: " + zip
         + ", secession: " + secession;
   }

}
