package com.team1.shopping307.Libs;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Libs {
   static SimpleDateFormat fmYyyyMmDd = new SimpleDateFormat("yyyy-MM-dd");
   static SimpleDateFormat fmAll = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
   
   public static Date strToDate(String date) throws ParseException {
      return date != null ? (Date)Libs.fmYyyyMmDd.parse(date) : null; 
   }
   
   public static String dateToStr(Date date){
      return date != null ? Libs.fmYyyyMmDd.format(date) : "";
   }
   
   public static java.sql.Date dateToSqlDate(Date date) {
      return date != null ? new java.sql.Date(date.getTime()) : null;
   }
   
   public static Date sqlDateToDate(java.sql.Date date) {
      return date != null ? new Date(date.getTime()) : null;
   }
   
}
