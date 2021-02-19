package com.team1.shopping307.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.team1.shopping307.Libs.Libs;
import com.team1.shopping307.VO.RevuVO;

public class RevuDAO {
	private static String className = "RevuDAO";
	private static String tableName = "review";

	public ArrayList<RevuVO> selectAll() {
		System.out.println(className + ".selectAll()");
		ArrayList<RevuVO> lstResult = new ArrayList<>();
		Connection conn = Libs.connect();

		if (conn != null) {
			PreparedStatement ps = null;
			ResultSet rs = null;
			String sql = "SELECT *" + " FROM " + tableName + " ORDER BY c_date DESC";

			try {
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();

				while (rs.next()) {
					RevuVO vo = new RevuVO();
					vo.setReviewId(rs.getInt("review_id"));
					vo.setTitle(rs.getString("title"));
					vo.setProductName(rs.getString("product_name"));
					vo.setUserId(rs.getString("user_id"));
					vo.setStar(rs.getInt("star"));
					vo.setcDate(rs.getDate("c_date"));
					lstResult.add(vo);
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}

			Libs.closeDb(conn, ps, rs);
		}

		return lstResult;

	}

	public RevuVO selectOne(int reviewId) {
		System.out.println(className + ".selectOne(" + reviewId + ")");
		RevuVO result = new RevuVO();
		Connection conn = Libs.connect();
		if (conn != null) {
			PreparedStatement ps = null;
			ResultSet rs = null;
			String sql = "SELECT *" + " FROM " + tableName + " WHERE review_id = ?";

			try {
				ps = conn.prepareStatement(sql);
				ps.setInt(1, reviewId);
				rs = ps.executeQuery();

				if (rs.next()) {
					result.setReviewId(rs.getInt("review_id"));
					result.setProductName(rs.getString("product_name"));
					result.setTitle(rs.getString("title"));
					result.setUserId(rs.getString("user_id"));
					result.setContent(rs.getString("content"));
					result.setStar(rs.getInt("star"));
					result.setcDate(rs.getDate("c_date"));
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}

			Libs.closeDb(conn, ps, rs);
		}

		return result;

	}
	
	public int insert(RevuVO vo) {
		System.out.println(className + ".insert()");
		int result = 0;
		Connection conn = Libs.connect();
		if(conn!=null) {
			PreparedStatement ps = null;
			String sql = "INSERT INTO review(review_id,user_id,user_name, " + 
					" product_id,product_name,star,title,content) " + 
					" VALUES(?,?,?,?,?,?,?,?)";
			try {
				ps = conn.prepareStatement(sql);
				int idx = 0;
				vo.setReviewId(Integer.parseInt(Libs.getNewId(conn, "", "seq_revu", "review_id")));
				System.out.println(vo);
				
				ps.setInt(++idx, vo.getReviewId());
				ps.setString(++idx, vo.getUserId());
				ps.setString(++idx, vo.getUserName());
				ps.setString(++idx, vo.getProductID());
				ps.setString(++idx, vo.getProductName());
				ps.setInt(++idx, vo.getStar());
				ps.setString(++idx, vo.getTitle());
				ps.setString(++idx, vo.getContent());
				
				int rtv = ps.executeUpdate();
				if(rtv == 1) {
					result = vo.getReviewId();
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			Libs.closeDb(conn, ps);
		}
		
		return result;
	}

	public int delete(int reviewId) {
		System.out.println(className + ".delete(" + reviewId + ")");
		int result = 0;
		Connection conn = Libs.connect();
		if (conn != null) {
			PreparedStatement ps = null;
			String sql = "DELETE FROM " + tableName + " WHERE review_id = ?";

			try {
				ps = conn.prepareStatement(sql);
				ps.setLong(1, reviewId);
				result = ps.executeUpdate();
			} catch (Exception ex) {
				ex.printStackTrace();
			}

			Libs.closeDb(conn, ps);
		}

		return result;
	}
}