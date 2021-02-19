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
	private static String ver = "0.1"; // for Commit

	public static ArrayList<ReleHistVO> selectAll() {
		System.out.println(className + ".selectAll()");
		ArrayList<ReleHistVO> lstResult = new ArrayList<>();
		Connection conn = Libs.connect();

		if (conn != null) {
			PreparedStatement ps = null;
			ResultSet rs = null;
			String sql = "SELECT *" + " FROM " + tableName + " ORDER BY release_id";

			try {
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();

				while (rs.next()) {
					ReleHistVO vo = new ReleHistVO();
					vo.setReleId(rs.getString("release_id"));
					vo.setUserId(rs.getString("user_id"));
					vo.setProdId(rs.getString("product_id"));
					vo.setProdName(rs.getString("product_name"));
					vo.setCaregory(rs.getString("category"));
					vo.setIsNew(rs.getString("is_new"));
					vo.setStandard(rs.getString("standard"));
					vo.setPrice(rs.getLong("price"));
					vo.setStatus(rs.getString("status"));
					vo.setcDate(rs.getDate("c_date"));
					vo.setuDate(rs.getDate("u_date"));
					lstResult.add(vo);
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}

			Libs.closeDb(conn, ps, rs);
		}

		return lstResult;
	}

	public static int delete(String releHistId) {
		System.out.println(className + ".delete(" + releHistId + ")");
		int result = 0;
		Connection conn = Libs.connect();

		if (conn != null) {
			PreparedStatement ps = null;
			String sql = "DELETE FROM " + tableName + " WHERE release_id = ?";

			try {
				ps = conn.prepareStatement(sql);
				ps.setString(1, releHistId);
				result = ps.executeUpdate();
			} catch (Exception ex) {
				ex.printStackTrace();
			}

			Libs.closeDb(conn, ps);
		}

		return result;
	}

}
