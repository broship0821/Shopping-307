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

   /* 이부분 따로 dao 만들어서 구현
   //product 테이블에서 select로 필요한 정보 추출
   public static ReleHistVO getProdInfo(String prodID) {
	   System.out.println(className + ".getProdInfo()");
	   ReleHistVO vo = new ReleHistVO();
	   Connection conn = Libs.connect();
	   
	   if(conn != null) {
	         PreparedStatement ps = null;
	         ResultSet rs = null;
	         String sql = "SELECT product_id,product_name,category,is_new,standard,price FROM product "
	         		+ "WHERE product_id=?";

	         try {
	            ps = conn.prepareStatement(sql);
	            ps.setString(1, prodID);
	            rs = ps.executeQuery();
	            
	            if(rs.next()) {
	               vo.setProdId(rs.getString("product_id"));
	               vo.setProdName(rs.getString("product_name"));
	               vo.setCaregory(rs.getString("category"));
	               vo.setIsNew(rs.getString("is_new"));
	               vo.setStandard(rs.getString("standard"));
	               vo.setPrice(rs.getLong("price"));
	            }      
	         }
	         catch (Exception ex) {
	            ex.printStackTrace();
	         }
	         
	         Libs.closeDb(conn, ps, rs);
	      }
	   return vo;
   }
   //release_history에 값 저장하기
   public static int insert(ReleHistVO vo) {
	   System.out.println(className + ".insert()");
	   int result = 0;
	   Connection conn = Libs.connect();
	   PreparedStatement ps = null;
	   
	   if(conn != null) {
		   //+ "'peter','PROD_1000000004','드레스','상의','Y','100','49000', "
		   String sql = "INSERT INTO release_history VALUES(seq_rele.NEXTVAL, "
		   		+ "?,?,?,?,?,?,?, "
		   		+ "'입금완료',sysdate,sysdate)";
		   
		   try {
			   ps = conn.prepareStatement(sql);
			   int idx = 0;
			   System.out.println("-------release_history 에 입력할 값----------");
			   System.out.println(vo);
			   
			   ps.setString(++idx, vo.getUserId());
			   ps.setString(++idx, vo.getProdId());
			   ps.setString(++idx, vo.getProdName());
			   ps.setString(++idx, vo.getCaregory());
			   ps.setString(++idx, vo.getIsNew());
			   ps.setString(++idx, vo.getStandard());
			   ps.setLong(++idx, vo.getPrice());
			   
			   int rtv = ps.executeUpdate();
			   
			   if(rtv == 1) {//성공시
				   result = 1;
			   }
		   }
		   catch (Exception ex) {
			   ex.printStackTrace();
			   return -1;//실패시
		   }
		   finally {
			   Libs.closeDb(conn, ps);
		   }
	   }
	   
	   return result;
   }
   //PayDAO의 insert 구현
   public static int insertPay(PayVO vo) {
	   PayDAO payDAO = new PayDAO();
	   payDAO.insert(vo);
	   return 1;
   }
   */
   
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
