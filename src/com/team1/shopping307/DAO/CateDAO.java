package com.team1.shopping307.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import com.team1.shopping307.Libs.Libs;
import com.team1.shopping307.VO.CateVO;
import com.team1.shopping307.VO.Member1VO;

public class CateDAO {
   private static String className = "CateDao";
   private static String tableName = "Category";

   public static ArrayList<CateVO> selectAll() {
      System.out.println(className + ".selectAll()");
      ArrayList<CateVO> lstResult = new ArrayList<>();
      Connection conn = Libs.connect();
      
      if(conn != null) {
         PreparedStatement ps = null;
         ResultSet rs = null;
         String sql = "SELECT category_name, bigo"
               + " FROM " + tableName + " ORDER BY category_name";

         try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()) {
               String name = rs.getString("category_name");
               String bigo = rs.getString("bigo");
               lstResult.add(new CateVO(name, bigo));
            }      
         }
         catch (Exception ex) {
            ex.printStackTrace();
         }
         
         Libs.closeDb(conn, ps, rs);
      }
      
      return lstResult;
   }
   
//   public static CateVO selectOne(String id) {
//      try {
//         return selectOne(Integer.valueOf(id));
//      }
//      catch(Exception ex) {
//         ex.printStackTrace();
//         return new CateVO();
//      }
//   }
   
   public static CateVO selectOne(String name) {
      System.out.println(className + ".selectOne(" + name + ")");
      CateVO result = new CateVO();
      Connection conn = Libs.connect();
      
      if(conn != null) {
         PreparedStatement ps = null;
         ResultSet rs = null;
         String sql = "SELECT category_name, bigo"
               + " FROM " + tableName + " WHERE category_name = ?";
         
         try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            rs = ps.executeQuery();
            
            if(rs.next()) {
               //String name1 = rs.getString("category_name");
               String bigo = rs.getString("bigo");
               result = new CateVO(name, bigo);
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
   
//   public static int insert(String id, String bigo) {
//      int result = 0;
//      
//      try {
//         int id2 = Integer.valueOf(id);
//         result = insert(id2, bigo);
//      }
//      catch(Exception ex) {
//         ex.printStackTrace();
//      }
//      
//      return result;      
//   }
   
   public static int insert(String name, String bigo) {
      System.out.println(className + ".insert()");
      int result = 0;
      Connection conn = Libs.connect();
      
      if(conn != null) {
         PreparedStatement ps = null;

         String sql = "INSERT INTO " + tableName 
               + " (category_name, bigo)"
               + " VALUES"
               + " (?, ?)";

         try {
            ps = conn.prepareStatement(sql);
            int idx = 0;
            ps.setString(++idx, name);
            ps.setString(++idx, bigo);
            
            result = ps.executeUpdate();
         }
         catch (Exception ex) {
            ex.printStackTrace();
         }
         
         Libs.closeDb(conn, ps);
      }
      
      return result;
   }

//   public static int delete(String id) {
//      int result = 0;
//      
//      try {
//         int id2 = Integer.valueOf(id);
//         result = delete(id2);
//      }
//      catch(Exception ex) {
//         ex.printStackTrace();
//      }
//      
//      return result;      
//   }
   
//   public static int update(String id, String bigo) {
//      int result = 0;
//      
//      try {
//         int id2 = Integer.valueOf(id);
//         result = update(id2, bigo);
//      }
//      catch(Exception ex) {
//         ex.printStackTrace();
//      }
//      
//      return result;      
//   }
   
   public static int update(String name, String bigo) {
      System.out.println(className + ".update()");
      int result = 0;
      Connection conn = Libs.connect();
      
      if(conn != null) {
         PreparedStatement ps = null;

         String sql = "UPDATE " + tableName
               + " SET bigo=?"
               + " WHERE category_name=?";

         try {
            ps = conn.prepareStatement(sql);
            int idx = 0;
            ps.setString(++idx, name);
            ps.setString(++idx, bigo);
            result = ps.executeUpdate();
         }
         catch (Exception ex) {
            ex.printStackTrace();
         }
         
         Libs.closeDb(conn, ps);
      }

      return result;
   }

//   public static int delete(String id) {
//      int result = 0;
//      
//      try {
//         int id2 = Integer.valueOf(id);
//         result = delete(id2);
//      }
//      catch(Exception ex) {
//         ex.printStackTrace();
//      }
//      
//      return result;      
//   }
   
   public static int delete(String name) {
      System.out.println(className + ".delete()");
      int result = 0;
      Connection conn = Libs.connect();
      
      if(conn != null) {
         PreparedStatement ps = null;
         String sql = "DELETE " + tableName + " WHERE category_name = ?";

         try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
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