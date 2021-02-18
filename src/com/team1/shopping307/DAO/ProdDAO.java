package com.team1.shopping307.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.team1.shopping307.Libs.Libs;
import com.team1.shopping307.VO.ProdVO;

public class ProdDAO {
   private static String className = "ProdDAO";
   private static String tableName = "product";

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
               lstResult.add(readProd(rs));
            }      
         }
         catch (Exception ex) {
            ex.printStackTrace();
         }
         
         Libs.closeDb(conn, ps, rs);
      }
      
      return lstResult;
   }
   
   private static ProdVO readProd(ResultSet rs) {
      ProdVO result = new ProdVO();
      
      try {
         String productId = rs.getString("product_id");
         String productName = rs.getString("product_name");
         String category = rs.getString("category");
         String isNew = rs.getString("is_new");
         String standard = rs.getString("standard");
         long price = rs.getLong("price");
         long stock = rs.getLong("stock");
         String bigo = rs.getString("bigo");
         String startDate = Libs.timestampToStr8(rs.getTimestamp("start_date"));

         String image1 = rs.getString("image_1");
         String image2 = rs.getString("image_2");
         String image3 = rs.getString("image_3");
         
         result = new ProdVO(productId, productName, category, isNew, standard,
               price, stock, bigo, startDate, image1, image2, image3);
         
         System.out.println(result);
      } catch (SQLException e) {
         e.printStackTrace();
      }
      
      return result;
   }

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
               result = readProd(rs);
            }      
         }
         catch (Exception ex) {
            ex.printStackTrace();
         }
         
         Libs.closeDb(conn, ps, rs);
      }
      
      return result;
   }
   
   public static String insert(ProdVO vo) {
      System.out.println(className + ".insert()");
      String result = null;
      Connection conn = Libs.connect();
      PreparedStatement ps = null;
      
      if(conn != null) {
         String sql = "INSERT INTO " + tableName 
               + " ("
               + " product_id, product_name, category, is_new, standard," 
               + " price, stock, bigo, start_date, image_1,"
               + " image_2, image_3"
               + " )"               
               + " VALUES"
               + " ("
               + " ?, ?, ?, ?, ?,"
               + " ?, ?, ?, ?, ?,"
               + " ?, ?"
               + ")";
//INSERT INTO product(
//product_id, product_name, category, is_new, standard, 
//price, stock, bigo, start_date, image_1,
//image_2, image_3)               
//VALUES(
//'PROD_1000000005', '111', 'outer', 'Y', '1111', 
//11111, 111111, '11', null, null,
//null, null      
//);

         try {
            ps = conn.prepareStatement(sql);
            int idx = 0;
            vo.setProductId(Libs.getNewId(conn, "PROD_", "seq_prod", "product_id"));
            System.out.println(vo);

            ps.setString(++idx, vo.getProductId());
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

            int rtv = ps.executeUpdate();
            
            if(rtv == 1) {
               result = vo.getProductId();
            }
         }
         catch (Exception ex) {
            ex.printStackTrace();
         }
         finally {
            Libs.closeDb(conn, ps);
         }
      }
      
      return result;
   }

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
