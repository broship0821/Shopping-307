package com.team1.shopping307.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import com.team1.shopping307.Libs.Libs;
import com.team1.shopping307.VO.Member1VO;

public class Member1DAO {
   public static ArrayList<Member1VO> selectAll() {
      System.out.println("selectAll()");
      ArrayList<Member1VO> lstResult = new ArrayList<>();
      Connection conn = Libs.connect();
      
      if(conn != null) {
         PreparedStatement ps = null;
         ResultSet rs = null;
         String sql = "SELECT id, name, tel, d"
               + " FROM teltable4 ORDER BY id";
         
         try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()) {
               int id = rs.getInt("id");
               String name = rs.getString("name");
               String tel = rs.getString("tel");
               Date date = Libs.sqlDateToDate(rs.getDate("d"));
               lstResult.add(new Member1VO(id, name, tel, Libs.dateToStr(date)));
            }      
         }
         catch (Exception ex) {
            ex.printStackTrace();
         }
         
         Libs.closeDb(conn, ps, rs);
      }
      
      return lstResult;
   }
   
   public static Member1VO selectOne(String id) {
      try {
         return selectOne(Integer.valueOf(id));
      }
      catch(Exception ex) {
         ex.printStackTrace();
         return new Member1VO();
      }
   }
   
   public static Member1VO selectOne(int id) {
      System.out.println("selectOne(" + id + ")");
      Member1VO result = new Member1VO();
      Connection conn = Libs.connect();
      
      if(conn != null) {
         PreparedStatement ps = null;
         ResultSet rs = null;
         String sql = "SELECT id, name, tel, d"
               + " FROM teltable4 WHERE id = ?";
         
         try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            
            if(rs.next()) {
               //int id2 = rs.getInt("id");
               String name = rs.getString("name");
               String tel = rs.getString("tel");
               Date date = Libs.sqlDateToDate(rs.getDate("d"));
               result = new Member1VO(id, name, tel, Libs.dateToStr(date));
               System.out.println(result);
            }      
         }
         catch (Exception ex) {
            ex.printStackTrace();
         }
         
         Libs.closeDb(conn, ps, rs);
      }
      
      return result;
   }
   
   public static int insert(String id, String name, String tel, String date) {
      int result = 0;
      
      try {
         int id2 = Integer.valueOf(id);
         Date date2 = Libs.strToDate(date);
         result = insert(id2, name, tel, date2);
      }
      catch(Exception ex) {
         ex.printStackTrace();
      }
      
      return result;      
   }
   
   public static int insert(int id, String name, String tel, Date date) {
      System.out.println("insert()");
      int result = 0;
      Connection conn = Libs.connect();
      
      if(conn != null) {
         PreparedStatement ps = null;

         // INSERT INTO teltable4 (id, name, tel, d) VALUES (4, 'yyy', '111', '2001/01/31')
         String sql = "INSERT INTO teltable4"
               + " (id, name, tel, d)"
               + " VALUES"
               + " (?, ?, ?, ?)";

         try {
            ps = conn.prepareStatement(sql);
            int idx = 0;
            ps.setInt(++idx, id);
            ps.setString(++idx, name);
            ps.setString(++idx, tel);
            ps.setDate(++idx, Libs.dateToSqlDate(date));
            
            result = ps.executeUpdate();
         }
         catch (Exception ex) {
            ex.printStackTrace();
         }
         
         Libs.closeDb(conn, ps);
      }
      
      return result;
   }

   public static int delete(String id) {
      int result = 0;
      
      try {
         int id2 = Integer.valueOf(id);
         result = delete(id2);
      }
      catch(Exception ex) {
         ex.printStackTrace();
      }
      
      return result;      
   }
   
   public static int delete(int id) {
      System.out.println("delete()");
      int result = 0;
      Connection conn = Libs.connect();
      
      if(conn != null) {
         PreparedStatement ps = null;
         String sql = "DELETE teltable4 WHERE id = ?";

         try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            result = ps.executeUpdate();
         }
         catch (Exception ex) {
            ex.printStackTrace();
         }
         
         Libs.closeDb(conn, ps);
      }
      
      return result;
   }
   
   public static int update(String id, String date) {
   //public static int update(String id, String name, String tel, String date) {
      int result = 0;
      
      try {
         int id2 = Integer.valueOf(id);
         Date date2 = Libs.strToDate(date);
         result = update(id2, date2);
      }
      catch(Exception ex) {
         ex.printStackTrace();
      }
      
      return result;      
   }
   
   public static int update(int id, Date date) {
      System.out.println("update()");
      int result = 0;
      Connection conn = Libs.connect();
      
      if(conn != null) {
         PreparedStatement ps = null;

         String sql = "UPDATE teltable4"
               //+ " SET name=?, tel=?, d=?"
               + " SET d=?"
               + " WHERE id=?";

         try {
            ps = conn.prepareStatement(sql);
            int idx = 0;
            //ps.setString(++idx, name);
            //ps.setString(++idx, tel);
            System.out.println(id + ", " + date);
            ps.setDate(++idx, Libs.dateToSqlDate(date));
            ps.setInt(++idx, id);
            result = ps.executeUpdate();
         }
         catch (Exception ex) {
            ex.printStackTrace();
         }
         
         Libs.closeDb(conn, ps);
      }

      return result;
   }
   
}