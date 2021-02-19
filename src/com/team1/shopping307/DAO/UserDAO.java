package com.team1.shopping307.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.team1.shopping307.Libs.Libs;
import com.team1.shopping307.VO.UserVO;

public class UserDAO {
	public static ArrayList<UserVO> selectAll() {
		System.out.println("selectAll()");
		ArrayList<UserVO> lstResult = new ArrayList<>();
		Connection conn = Libs.connect();

		if (conn != null) {
			PreparedStatement ps = null;
			ResultSet rs = null;
			String sql = "SELECT USER_ID, PW, NAME, PHONENUMBER, ROLE, ADDRESS, ZIP, SECESSION"
					+ "FORM USERS ORDER BY USER_ID";

			try {
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();

				while (rs.next()) {
					lstResult.add(readUser(rs));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			Libs.closeDb(conn, ps, rs);
		}
		return lstResult;
	}
	
	
	private static UserVO readUser(ResultSet rs) {
	   UserVO result = new UserVO();
	   
      if(rs != null) {
         try {
            String id = rs.getString("USER_ID");
            String pw = rs.getString("PW");
            String name = rs.getString("NAME");
            String phone = rs.getString("PHONENUMBER");
            String role = rs.getString("ROLE");
            String address = rs.getString("ADDRESS");
            int zip = rs.getInt("zip");
            String secession = rs.getString("SECESSION");
            
            result = new UserVO(id, pw, name, phone, role, address, zip, secession);
         } catch (SQLException e) {
            e.printStackTrace();
         }      
      }
      
      return result;
   }


   public static UserVO selectOne(String id) {
		System.out.println("selectOne(" + id + ")");
		UserVO user = new UserVO();
		Connection conn = Libs.connect();
		if (conn != null) {
			PreparedStatement ps = null;
			ResultSet rs = null;
			String sql = "SELECT USER_ID, PW, NAME, PHONENUMBER, ROLE, ADDRESS, ZIP, SECESSION"
					+ "FORM USERS WHERE USER_ID = ?";

			try {
				ps = conn.prepareStatement(sql);
				ps.setString(1, id);
				rs = ps.executeQuery();

				if (rs.next()) {
               user = readUser(rs);
					System.out.println(user);
				}
			} catch (Exception e) {
				e.printStackTrace();
				return new UserVO();
			}
			Libs.closeDb(conn, ps);
		}
		return user;
	}

	
	// 회원가입
	public static int insert(UserVO vo) {
		System.out.println("insert()");
		int result = 0;
		Connection conn = Libs.connect();

		if (conn != null) {
			PreparedStatement ps = null;

			String sql = "INSERT INTO USERS"
					+ "(USER_ID, PW, NAME, PHONENUMBER, ROLE, ADDRESS, ZIP, SECESSION)" + " VALUES"
					+ "(?,?,?,?,?,?,?,?)";
			try {
				ps = conn.prepareStatement(sql);
				ps.setString(1, vo.getUserId());
				ps.setString(2, vo.getPw());
				ps.setString(3, vo.getName());
				ps.setString(4, vo.getPhonenumber());
				ps.setString(5, vo.getRole());
				ps.setString(6, vo.getAddress());
				ps.setInt(7,    vo.getZip());
				ps.setString(8, vo.getSecession());

				result = ps.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
			Libs.closeDb(conn, ps);
		}
		return result;
	}

	public static int delete(String id) {
		System.out.println("deletd()");
		int result = 0;
		Connection conn = Libs.connect();

		if (conn != null) {
			PreparedStatement ps = null;
			String sql = "DELETE USERS WHERE user_id = ?";

			try {
				ps = conn.prepareStatement(sql);
				ps.setString(1, id);
				result = ps.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
			Libs.closeDb(conn, ps);
		}
		return result;
	}

	public static int update(String id, String name, String phone, String address, int zip) {
		System.out.println("update();");
		int result = 0;
		Connection conn = Libs.connect();

		if (conn != null) {
			PreparedStatement ps = null;
			String sql = "UPDATE USERS"
					     + "SET NAME = ?, PHONE=?, ADDRESS =?, ZIP=?"
					     + "WHERE USER_ID = ?";

			try {
				ps = conn.prepareStatement(sql);
				int idx =0;
				ps.setString(++idx, name);
				ps.setString(++idx, phone);
				ps.setString(++idx, address);
				ps.setInt(++idx, zip);
				result = ps.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
			Libs.closeDb(conn, ps);
		}
		return result;
		
	}
	
	
	//로그인 체크 메소드
	public static String checkLogin(String id, String pw) {
		String name = null;
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    
	    try {
			conn = Libs.connect();
			
			if(conn != null) {
   			String sql = "SELECT NAME FROM USERS WHERE USER_ID=? and PW=?";
   			pstmt = conn.prepareStatement(sql);
   			pstmt.setString(1, id);
   			pstmt.setString(2, pw);;
   			
   			rs = pstmt.executeQuery();
   			if(rs.next()) {
   				name = rs.getString("NAME");
   			}
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
		   Libs.closeDb(conn, pstmt, rs);
		}
	    return name;
	} 
	
	//아이디 중복 검사
	public static boolean checkId(String id) {
      System.out.println("checkId()");
      Connection conn = Libs.connect();
      PreparedStatement ps = null;
      ResultSet rs = null;
      boolean idcheck = false;
      if (conn != null) {
         String sql = "SELECT USERS_ID FROM USERS WHERE user_id = ?";

         try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            idcheck = rs.next();
         } catch (Exception e) {
            e.printStackTrace();
         }
         Libs.closeDb(conn, ps);
      }
      return idcheck;
	}
}
