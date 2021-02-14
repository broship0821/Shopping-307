package com.team1.shopping307.Libs;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Libs {
   
   //------------------------------------------------
   // File 관련 
   //------------------------------------------------

   // 기능: path에서 확장자를 응답한다.
   // 테스트코드 및 결과
   //  String str;
   //  str = null; 
   //  System.out.println("1 :" + Libs.getFileExt(str)); // ""
   //  str = ""; 
   //  System.out.println("2 :" + Libs.getFileExt(str)); // ""
   //  str = "123"; 
   //  System.out.println("3 :" + Libs.getFileExt(str)); // ""
   //  str = "1234."; 
   //  System.out.println("4 :" + Libs.getFileExt(str)); // "."
   //  str = "1234.56"; 
   //  System.out.println("5 :" + Libs.getFileExt(str)); // ".56"
   //  str = "1234.56/"; 
   //  System.out.println("6 :" + Libs.getFileExt(str)); // ".56"
   //  str = "1234.56/7"; 
   //  System.out.println("7 :" + Libs.getFileExt(str)); // ""
   //  str = "1234.56/78."; 
   //  System.out.println("8 :" + Libs.getFileExt(str)); // "."
   //  str = "1234.56/78.9"; 
   //  System.out.println("9 :" + Libs.getFileExt(str)); // ".9"
   //  str = "C:"; 
   //  System.out.println("A :" + Libs.getFileExt(str)); // ""
   //  str = "C:123"; 
   //  System.out.println("B :" + Libs.getFileExt(str)); // ""
   //  str = "C:123."; 
   //  System.out.println("C :" + Libs.getFileExt(str)); // "."
   //  str = "C:123.45"; 
   //  System.out.println("D :" + Libs.getFileExt(str)); // ".45"
   //  str = "C:123.45/5"; 
   //  System.out.println("E :" + Libs.getFileExt(str)); // ""
   //  str = "C:123.45/5.6"; 
   //  System.out.println("F :" + Libs.getFileExt(str)); // ".6"
   public static String getFileExt(String path) {
      String result = "";
      
      if(path != null && path.length() >= 1) {
         File fi = new File(path);
         String fileName = fi.getName();
         int idx = fileName.lastIndexOf(".");
         
         result = idx >= 0 ? fileName.substring(idx) : "";
      }
      
      return result;
   }
   
   
   //------------------------------------------------
   // Date/Time 관련 
   //------------------------------------------------
   static SimpleDateFormat fmYyyyMmDd = new SimpleDateFormat("yyyy-MM-dd");
   static SimpleDateFormat fmYyyyMmDd8 = new SimpleDateFormat("yyyyMMdd");
   static SimpleDateFormat fmAll = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
   static SimpleDateFormat fmAll15 = new SimpleDateFormat("yyyyMMdd HHmmss");
   
   //--------------------------------------
   // 기능: 1. "yyyy-MM-dd HH:mm:ss" >> java.util.Date
   public static Date strToDate(String date) throws ParseException {
      Date result = null;
      
      if(date != null) {
         date = date.trim();
         SimpleDateFormat fmt = null;
         
         switch(date.length()) {
         case 8: fmt = fmYyyyMmDd8; break;
         case 10: fmt = fmYyyyMmDd; break;
         case 15: fmt = fmAll15; break;
         case 19: fmt = fmAll; break;
         }
         
         if(fmt != null) {
            result = (Date)fmt.parse(date);
         } 
      }
      
      return result;
   }
   
   // 기능: java.util.Date >> "yyyy-MM-dd HH:mm:ss"
   public static String dateToStr(Date date){
      return date != null ? Libs.fmAll.format(date) : "";
   }

   // 기능: java.util.Date >> "yyyy-MM-dd"
   public static String dateToStr8(Date date){
      return date != null ? Libs.fmYyyyMmDd.format(date) : "";
   }

   //--------------------------------------
   // 기능: 2. "yyyy-MM-dd" >> java.sql.Date
   public static java.sql.Date strToSqlDate(String date) throws ParseException {
      return date != null && date.trim().length() != 0
            ? dateToSqlDate(strToDate(date)) : null; 
   }
   
   // 기능: java.sql.Date >> "yyyy-MM-dd"
   public static String sqlDateToStr(java.sql.Date date) {
      return date != null ? dateToStr(sqlDateToDate(date)) : null;
   }
   
   //--------------------------------------
   // 기능: 3. java.util.Date >> java.sql.Date 
   public static java.sql.Date dateToSqlDate(Date date) {
      return date != null ? new java.sql.Date(date.getTime()) : null;
   }
   
   // 기능: java.sql.Date >> java.util.Date 
   public static Date sqlDateToDate(java.sql.Date date) {
      return date != null ? new Date(date.getTime()) : null;
   }

   //--------------------------------------
   // 기능: 4. java.sql.Date >> java.util.Date 
   public static java.sql.Timestamp strToTimestamp(String date) throws ParseException {
      return date != null && date.trim().length() != 0
            ? new java.sql.Timestamp(strToDate(date).getTime()) : null; 
   }
   
   public static String timestampToStr(java.sql.Timestamp date){
      return date != null ? dateToStr(new Date(date.getTime())) : "";
   }
   
   public static String timestampToStr8(java.sql.Timestamp date){
      return date != null ? dateToStr8(new Date(date.getTime())) : "";
   }

   public static String dateTimeToStr(Date date) throws ParseException {
      return dateToStr(date);
   }
   
   
   //------------------------------------------------
   // 변환 관련 
   //------------------------------------------------
   public static int strToInt(String str, int defValue) {
      if(str == null || str.trim().length() == 0) {
         return defValue;
      }
      else {
         return Integer.valueOf(str.trim());
      }
   }
   
   
   //------------------------------------------------
   // DB 관련 
   //------------------------------------------------
   public static Connection connect() {
      System.out.println("connect()");
      Connection conn = null;
      String driverName = "oracle.jdbc.driver.OracleDriver";
      String url = "jdbc:oracle:thin:@localhost:1521:xe"; // localhost대신 ip주소가 들어갈수도
      String id = "hr";
      String pw = "hr";
      
      try {
         Class.forName(driverName);
         conn = DriverManager.getConnection(url, id, pw);
         System.out.println("connect OK!!!");
      }
      catch(Exception ex) {
         ex.printStackTrace();
         close(conn);
      }
      
      return conn;
   }
   
   public static void closeDb(Connection conn, PreparedStatement ps, ResultSet rs) {
      close(rs);
      close(ps);
      close(conn);
   }
   
   public static void closeDb(Connection conn, PreparedStatement ps) {
      close(ps);
      close(conn);
   }
   
   public static void close(Connection conn) {
      if(conn != null) {
        try {
            conn.close();
            conn = null;
         }
         catch(Exception ex) {
            ex.printStackTrace();
         }
      }   
   }
   
   public static void close(ResultSet rs) {
      if(rs != null) {
         try {
            rs.close();
         }
         catch(Exception ex) {
            ex.printStackTrace();
         }
      }
   }
   
   public static void close(PreparedStatement ps) {
      if(ps != null) {
         try {
            ps.close();
         }
         catch(Exception ex) {
            ex.printStackTrace();
         }
      }
   }
   
}
