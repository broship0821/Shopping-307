package com.team1.shopping307.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.team1.shopping307.Libs.Libs;
import com.team1.shopping307.VO.RevuVO;

public class RevuDAO {
   private static Connection connect() {
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
   
   private static void closeDb(Connection conn, PreparedStatement ps, ResultSet rs) {
      close(rs);
      close(ps);
      close(conn);
   }
   
   private static void closeDb(Connection conn, PreparedStatement ps) {
      close(ps);
      close(conn);
   }
   
   private static void close(Connection conn) {
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
   
   private static void close(ResultSet rs) {
      if(rs != null) {
         try {
            rs.close();
         }
         catch(Exception ex) {
            ex.printStackTrace();
         }
      }
   }
   
   private static void close(PreparedStatement ps) {
      if(ps != null) {
         try {
            ps.close();
         }
         catch(Exception ex) {
            ex.printStackTrace();
         }
      }
   }
   
   public static ArrayList<RevuVO> selectAll() {
      System.out.println("후기 selectAll()");
      ArrayList<RevuVO> revuList = new ArrayList<>();
      Connection conn = connect();
      
      if(conn != null) {
         PreparedStatement ps = null;
         ResultSet rs = null;
         //나중에 join 해서 상품 테이블의 상품명을 가져와야 할듯
         //일단 상품 아이디만 가져옴(product_id)
         String sql = "SELECT user_id, product_id, star, title, content, c_date"
         		+ "FROM review";
         
         try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()) {
            	RevuVO vo = new RevuVO();
            	vo.setUserId(rs.getString("user_id"));
            	vo.setProduct(rs.getString("product_id"));
            	vo.setStar(rs.getInt("star"));
            	vo.setTitle(rs.getString("content"));
            	vo.setcDate(Libs.sqlDateToDate(rs.getDate("c_date")));
            	revuList.add(vo);
            }      
         }
         catch (Exception ex) {
            ex.printStackTrace();
         }
         
         closeDb(conn, ps, rs);
      }
      
      return revuList;
   }
   
   /*
    만들어야할거:
    selectOne: 후기 하나만 가져오는 기능
    insert: 작성된 후기 db에 저장하는 기능
    delete: db에 저장된 후기 삭제 기능
    update: db에 저장된 후기 수정 기능
    */
   
   
}