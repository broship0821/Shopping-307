package com.team1.shopping307.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.team1.shopping307.Libs.Libs;
import com.team1.shopping307.VO.ExchVO;

public class ExchDAO {
   private static String className = "ExchDAO";
   private static String tableName = "exchange";

   public static ArrayList<ExchVO> selectAll() {
      System.out.println(className + ".selectAll()");
      ArrayList<ExchVO> lstResult = new ArrayList<>();
      Connection conn = Libs.connect();
      
      if(conn != null) {
         PreparedStatement ps = null;
         ResultSet rs = null;
         String sql = "SELECT *"
               + " FROM " + tableName + " ORDER BY exchange_id";

         try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()) {
               lstResult.add(readExch(rs));
            }      
         }
         catch (Exception ex) {
            ex.printStackTrace();
         }
         
         Libs.closeDb(conn, ps, rs);
      }
      
      return lstResult;
   }
   
   private static ExchVO readExch(ResultSet rs) {
      ExchVO result = new ExchVO();
      
      try {
         String exchangeId = rs.getString("exchange_id");
         long payId = rs.getLong("pay_id");
         String exchangeOrRefund = rs.getString("exchange_or_refund");
         String status = rs.getString("status");
         
         result = new ExchVO(exchangeId, payId, exchangeOrRefund, status);
         System.out.println(result);
      } 
      catch (SQLException e) {
         e.printStackTrace();
      }
      
      return result;
   }

   public static ExchVO selectOne(String exchangeId) {
      System.out.println(className + ".selectOne(" + exchangeId + ")");
      ExchVO result = new ExchVO();
      Connection conn = Libs.connect();
      
      if(conn != null) {
         PreparedStatement ps = null;
         ResultSet rs = null;
         String sql = "SELECT *"
               + " FROM " + tableName + " WHERE exchange_id = ?";
         
         try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, exchangeId);
            rs = ps.executeQuery();
            
            if(rs.next()) {
               result = readExch(rs);
            }      
         }
         catch (Exception ex) {
            ex.printStackTrace();
         }
         
         Libs.closeDb(conn, ps, rs);
      }
      
      return result;
   }
   
   public static String insert(ExchVO vo) {
      System.out.println(className + ".insert()");
      String result = null;
      Connection conn = Libs.connect();
      PreparedStatement ps = null;
      
      if(conn != null) {
         String sql = "INSERT INTO " + tableName 
               + " (exchange_id, pay_id, exchange_or_refun, status)"               
               + " VALUES"
               + " (?, ?, ?, ?)";

         try {
            ps = conn.prepareStatement(sql);
            int idx = 0;
            vo.setExchangeId(Libs.getNewId(conn, "", "seq_exch", "exchange_id"));
            System.out.println(vo);

            ps.setString(++idx, vo.getExchangeId());
            ps.setLong(++idx, vo.getPayId());
            ps.setString(++idx, vo.getExchangeOrRefund());
            ps.setString(++idx, vo.getStatus());

            int rtv = ps.executeUpdate();
            
            if(rtv == 1) {
               result = vo.getExchangeId();
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
   
   public static int update(ExchVO vo) {
      System.out.println(className + ".update()");
      int result = 0;
      Connection conn = Libs.connect();
      
      if(conn != null) {
         PreparedStatement ps = null;

         String sql = "UPDATE " + tableName
               + " SET   exchange_id       = ?"
               + "     , pay_id            = ?"
               + "     , exchange_or_refun = ?"
               + "     , status            = ?"
               + " WHERE exchange_id       = ?";

         try {
            ps = conn.prepareStatement(sql);
            int idx = 0;
            ps.setLong(++idx, vo.getPayId());
            ps.setString(++idx, vo.getExchangeOrRefund());
            ps.setString(++idx, vo.getStatus());
            ps.setString(++idx, vo.getExchangeId());

            result = ps.executeUpdate();
         }
         catch (Exception ex) {
            ex.printStackTrace();
         }
         
         Libs.closeDb(conn, ps);
      }

      return result;
   }

   public static int delete(String exchangeId) {
      System.out.println(className + ".delete(" + exchangeId + ")");
      int result = 0;
      Connection conn = Libs.connect();
      
      if(conn != null) {
         PreparedStatement ps = null;
         String sql = "DELETE FROM " + tableName + " WHERE exchange_id = ?";

         try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, exchangeId);
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
