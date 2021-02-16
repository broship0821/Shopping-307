package com.team1.shopping307.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.team1.shopping307.Libs.Libs;
import com.team1.shopping307.VO.PayVO;

public class PayDAO {
   private static String className = "PayDAO";
   private static String tableName = "pay_info";

   public static ArrayList<PayVO> selectAll() {
      System.out.println(className + ".selectAll()");
      ArrayList<PayVO> lstResult = new ArrayList<>();
      Connection conn = Libs.connect();
      
      if(conn != null) {
         PreparedStatement ps = null;
         ResultSet rs = null;
         String sql = "SELECT *"
               + " FROM " + tableName + " ORDER BY pay_id";

         try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()) {
               lstResult.add(readPay(rs));
            }      
         }
         catch (Exception ex) {
            ex.printStackTrace();
         }
         
         Libs.closeDb(conn, ps, rs);
      }
      
      return lstResult;
   }
   
   private static PayVO readPay(ResultSet rs) {
      PayVO result = new PayVO();
      
      try {
         long payId = rs.getLong("pay_id");
         String sellerName = rs.getString("seller_name");
         String sellerPhone = rs.getString("seller_phone");
         String sellerZip = rs.getString("seller_zip");
         String sellerAddress = rs.getString("seller_address");
         long buyerId = rs.getLong("buyer_id");
         String buyerName = rs.getString("buyer_name");
         String buyerPhone = rs.getString("buyer_phone");
         String buyerZip = rs.getString("buyer_zip");
         String buyerAddress = rs.getString("buyer_address");
         String itemsInfo = rs.getString("items_info");
         int amount = rs.getInt("amount");
         String cashOrCard = rs.getString("cash_or_card");
         String cardNo = rs.getString("card_no");
         String status = rs.getString("status");
         
         result = new PayVO(payId, sellerName, sellerPhone, sellerZip,
               sellerAddress, buyerId, buyerName, buyerPhone, buyerZip, 
               buyerAddress, itemsInfo, amount, cashOrCard, cardNo, status);
         
         System.out.println(result);
      } catch (SQLException e) {
         e.printStackTrace();
      }
      
      return result;
   }

   public static PayVO selectOne(String payId) {
      System.out.println(className + ".selectOne(" + payId + ")");
      PayVO result = new PayVO();
      Connection conn = Libs.connect();
      
      if(conn != null) {
         PreparedStatement ps = null;
         ResultSet rs = null;
         String sql = "SELECT *"
               + " FROM " + tableName + " WHERE pay_id = ?";
         
         try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, payId);
            rs = ps.executeQuery();
            
            if(rs.next()) {
               result = readPay(rs);
            }      
         }
         catch (Exception ex) {
            ex.printStackTrace();
         }
         
         Libs.closeDb(conn, ps, rs);
      }
      
      return result;
   }
   
   public static long insert(PayVO vo) {
      System.out.println(className + ".insert()");
      long result = 0;
      Connection conn = Libs.connect();
      PreparedStatement ps = null;
      
      if(conn != null) {
         String sql = "INSERT INTO " + tableName 
               + " ("
               + " pay_id, seller_name, seller_phone, seller_zip, seller_address, "
               + " buyer_id, buyer_name, buyer_phone, buyer_zip, buyer_address, "
               + " items_info, amount, cash_or_card, card_no, status "
               + " )"               
               + " VALUES"
               + " ("
               + " ?, ?, ?, ?, ?,"
               + " ?, ?, ?, ?, ?,"
               + " ?, ?, ?, ?, ?,"
               + ")";

         try {
            ps = conn.prepareStatement(sql);
            int idx = 0;
            vo.setPayId(getNewPayId(conn));
            System.out.println(vo);

            ps.setLong(++idx, vo.getPayId());
            ps.setString(++idx, vo.getSellerName());
            ps.setString(++idx, vo.getSellerPhone());
            ps.setString(++idx, vo.getSellerZip());
            ps.setString(++idx, vo.getSellerAddress());
            ps.setLong(++idx, vo.getBuyerId() );
            ps.setString(++idx, vo.getBuyerName());
            ps.setString(++idx, vo.getBuyerPhone());
            ps.setString(++idx, vo.getBuyerZip());
            ps.setString(++idx, vo.getBuyerAddress());
            ps.setString(++idx, vo.getItemsInfo());
            ps.setInt(++idx, vo.getAmount());
            ps.setString(++idx, vo.getCashOrCard());
            ps.setString(++idx, vo.getCardNo());
            ps.setString(++idx, vo.getStatus());
            
            int rtv = ps.executeUpdate();
            
            if(rtv == 1) {
               result = vo.getPayId();
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

   private static long getNewPayId(Connection conn) {
      // System.out.println(className + ".getNewPayId()");
      long result = 0;

      if(conn != null) {
         PreparedStatement ps = null;
         ResultSet rs = null;
         String sql = "SELECT seq_pay.NEXTVAL as pay_id FROM DUAL";
         
         try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            if(rs.next()) {
               result = rs.getLong("pay_id");
            }      
         }
         catch (Exception ex) {
            ex.printStackTrace();
         }
         
         Libs.close(rs);
         Libs.close(ps);
      }
      
      return result;
   }

   public static int update(PayVO vo) {
      System.out.println(className + ".update()");
      int result = 0;
      Connection conn = Libs.connect();
      
      if(conn != null) {
         PreparedStatement ps = null;

         String sql = "UPDATE " + tableName
               + " SET pay_id         = ?" 
               + "   , seller_name    = ?" 
               + "   , seller_phone   = ?" 
               + "   , seller_zip     = ?" 
               + "   , seller_address = ?" 
               + "   , buyer_id       = ?" 
               + "   , buyer_name     = ?" 
               + "   , buyer_phone    = ?" 
               + "   , buyer_zip      = ?" 
               + "   , buyer_address  = ?" 
               + "   , items_info     = ?" 
               + "   , amount         = ?" 
               + "   , cash_or_card   = ?" 
               + "   , card_no        = ?" 
               + "   , status         = ?"         
               + " WHERE pay_id       = ? ";

         try {
            ps = conn.prepareStatement(sql);
            int idx = 0;
            ps.setString(++idx, vo.getSellerName());
            ps.setString(++idx, vo.getSellerPhone());
            ps.setString(++idx, vo.getSellerZip());
            ps.setString(++idx, vo.getSellerAddress());
            ps.setLong  (++idx, vo.getBuyerId() );
            ps.setString(++idx, vo.getBuyerName());
            ps.setString(++idx, vo.getBuyerPhone());
            ps.setString(++idx, vo.getBuyerZip());
            ps.setString(++idx, vo.getBuyerAddress());
            ps.setString(++idx, vo.getItemsInfo());
            ps.setInt   (++idx, vo.getAmount());
            ps.setString(++idx, vo.getCashOrCard());
            ps.setString(++idx, vo.getCardNo());
            ps.setString(++idx, vo.getStatus());
            ps.setLong  (++idx, vo.getPayId());

            result = ps.executeUpdate();
         }
         catch (Exception ex) {
            ex.printStackTrace();
         }
         
         Libs.closeDb(conn, ps);
      }

      return result;
   }

   public static int delete(String payId) {
      System.out.println(className + ".delete(" + payId + ")");
      int result = 0;
      Connection conn = Libs.connect();
      
      if(conn != null) {
         PreparedStatement ps = null;
         String sql = "DELETE FROM " + tableName + " WHERE pay_id = ?";

         try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, payId);
            result = ps.executeUpdate();
         }
         catch (Exception ex) {
            ex.printStackTrace();
         }
         
         Libs.closeDb(conn, ps);
      }
      
      return result;
   }

   public static ArrayList<PayVO> getStatus(String status) {
      System.out.println(className + ".getStatus(" + status + ")");
      ArrayList<PayVO> lstResult = new ArrayList<>();
      Connection conn = Libs.connect();
      
      if(conn != null) {
         PreparedStatement ps = null;
         ResultSet rs = null;
         String sql = "SELECT *"
               + " FROM " + tableName 
               + " WHERE status = ? ORDER BY status, pay_id";
         
         try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, status);
            rs = ps.executeQuery();
            
            while(rs.next()) {
               lstResult.add(readPay(rs));
            }      
         }
         catch (Exception ex) {
            ex.printStackTrace();
         }
         
         Libs.closeDb(conn, ps, rs);
      }
      
      return lstResult;
   }

   public static int setStatus(long payId, String status) {
      System.out.println(className + ".setStatus(" + payId + ", " + status + ")");
      int result = 0;
      Connection conn = Libs.connect();
      
      if(conn != null) {
         PreparedStatement ps = null;

         String sql = "UPDATE " + tableName
               + "   SET status = ?"         
               + " WHERE pay_id = ? AND status = ?";

         try {
            ps = conn.prepareStatement(sql);
            int idx = 0;
            ps.setString(++idx, status);
            ps.setLong(++idx, payId);
            ps.setString(++idx, Libs.getNextPayStatus(status));

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
