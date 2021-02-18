package com.team1.shopping307.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.team1.shopping307.Libs.Libs;
import com.team1.shopping307.VO.PayVO;
import com.team1.shopping307.VO.ProdVO;
import com.team1.shopping307.VO.ReleHistVO;

public class ReleHistDAO {
   private static String className = "ReleHistDAO";
   private static String tableName = "release_history";

   
   //구현 X
   public static ArrayList<ProdVO> selectAll() {
      System.out.println(className + ".selectAll()");
      ArrayList<ProdVO> lstResult = new ArrayList<>();
      Connection conn = Libs.connect();
      
      if(conn != null) {
         PreparedStatement ps = null;
         ResultSet rs = null;
         String sql = "SELECT *"
               + " FROM " + tableName + " ORDER BY product_id";

         try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()) {
               //lstResult.add(readProd(rs));
            }      
         }
         catch (Exception ex) {
            ex.printStackTrace();
         }
         
         Libs.closeDb(conn, ps, rs);
      }
      
      return lstResult;
   }
   //구현 X
   public static ProdVO selectOne(String productId) {
      System.out.println(className + ".selectOne(" + productId + ")");
      ProdVO result = new ProdVO();
      Connection conn = Libs.connect();
      
      if(conn != null) {
         PreparedStatement ps = null;
         ResultSet rs = null;
         String sql = "SELECT *"
               + " FROM " + tableName + " WHERE product_id = ?";
         
         try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, productId);
            rs = ps.executeQuery();
            
            if(rs.next()) {
               //result = readProd(rs);
            }      
         }
         catch (Exception ex) {
            ex.printStackTrace();
         }
         
         Libs.closeDb(conn, ps, rs);
      }
      
      return result;
   }
 

 //구현 X
   public static int update(ProdVO vo) {
      System.out.println(className + ".update()");
      int result = 0;
      Connection conn = Libs.connect();
      
      if(conn != null) {
         PreparedStatement ps = null;

         String sql = "UPDATE " + tableName
               + " SET product_name = ?"
               + "   , category     = ?"
               + "   , is_new       = ?"
               + "   , standard     = ?"
               + "   , price        = ?"
               + "   , stock        = ?"
               + "   , bigo         = ?"
               + "   , start_date   = ?"
               + "   , image_1      = ?"
               + "   , image_2      = ?"
               + "   , image_3      = ?"
               + " WHERE product_id = ?";

         try {
            ps = conn.prepareStatement(sql);
            int idx = 0;
            ps.setString(++idx, vo.getProductName());
            ps.setString(++idx, vo.getCategory());
            ps.setString(++idx, vo.getIsNew());
            ps.setString(++idx, vo.getStandard());
            ps.setLong(++idx, vo.getPrice());
            ps.setLong(++idx, vo.getStock());
            ps.setString(++idx, vo.getBigo());
            ps.setTimestamp(++idx, Libs.strToTimestamp(vo.getStartDate()));
            ps.setString(++idx, vo.getImage1());
            ps.setString(++idx, vo.getImage2());
            ps.setString(++idx, vo.getImage3());
            ps.setString(++idx, vo.getProductId());

            result = ps.executeUpdate();
         }
         catch (Exception ex) {
            ex.printStackTrace();
         }
         
         Libs.closeDb(conn, ps);
      }

      return result;
   }
 //구현 X
   public static int delete(String productId) {
      System.out.println(className + ".delete(" + productId + ")");
      int result = 0;
      Connection conn = Libs.connect();
      
      if(conn != null) {
         PreparedStatement ps = null;
         String sql = "DELETE FROM " + tableName + " WHERE product_id = ?";

         try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, productId);
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
