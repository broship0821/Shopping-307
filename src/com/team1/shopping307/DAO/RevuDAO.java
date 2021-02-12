package com.team1.shopping307.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.team1.shopping307.Libs.Libs;
import com.team1.shopping307.VO.RevuVO;
/*
 RevuDAO 수정사항:
1. selectOne: 
SELECT user_id, product_id, star, title, content, c_date FROM review where product=?
여기서 where product=? 하면 하나만 선택되지 않고 한 상품의 모든 후기가 선택됨

2. insert:
INSERT INTO review (user_id, product_id, star, title, content, c_date) VALUES (?, ?, ?, ?, ?, ?, ?)
여기서 review_id도 같이 넣어주기, 값은 db맨 마지막 후기 review_id +1 값

3. delete:
DELETE FROM review where userId=?
이렇게 하면 한 유저가 쓴 모든 후기가 다 삭제됨

4. update
UPDATE review SET cDate=? WEHRE userId=?
이렇게 하면 날짜만 바뀜
update 매개변수로 RevuVO랑 reivew_id를 받아서 해당 reivew_id지우고 똑같은 reivew_id에 받은 VO insert하면 해결됨

 */
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
		} catch (Exception ex) {
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
		if (conn != null) {
			try {
				conn.close();
				conn = null;
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	private static void close(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	private static void close(PreparedStatement ps) {
		if (ps != null) {
			try {
				ps.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	public static ArrayList<RevuVO> selectAll() {
		System.out.println("후기 selectAll()");
		ArrayList<RevuVO> revuList = new ArrayList<>();
		Connection conn = connect();

		if (conn != null) {
			PreparedStatement ps = null;
			ResultSet rs = null;
			// 나중에 join 해서 상품 테이블의 상품명을 가져와야 할듯
			// 일단 상품 아이디만 가져옴(product_id)
			String sql = "SELECT user_id, product_id, star, title, content, c_date" + "FROM review";

			try {
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();

				while (rs.next()) {
					RevuVO vo = new RevuVO();
					vo.setUserId(rs.getString("user_id"));
					vo.setProduct(rs.getString("product_id"));
					vo.setStar(rs.getInt("star"));
					vo.setTitle(rs.getString("content"));
					vo.setcDate(Libs.sqlDateToDate(rs.getDate("c_date")));
					revuList.add(vo);
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}

			closeDb(conn, ps, rs);
		}

		return revuList;
	}

	////////////// selectOne ////////////
	public static RevuVO selectOne(String product, ArrayList<RevuVO> revuList) {
		System.out.println("selectOne(" + product + ")");
		Connection conn = connect();
		RevuVO vo1 = null;

		if (conn != null) {
			PreparedStatement ps = null;
			ResultSet rs = null;
			String sql = "SELECT user_id, product_id, star, title, content, c_date" + "FROM review where product=?";
			try {
				ps = conn.prepareStatement(sql);
				ps.setString(1, product);
				rs = ps.executeQuery();

				if (rs.next()) {

					vo1.setUserId(rs.getString("user_id"));
					vo1.setProduct(rs.getString("product_id"));
					vo1.setStar(rs.getInt("star"));
					vo1.setTitle(rs.getString("content"));
					vo1.setcDate(Libs.sqlDateToDate(rs.getDate("c_date")));
					revuList.add(vo1);

				}

			} catch (Exception ex) {
				ex.printStackTrace();
			}
			closeDb(conn, ps, rs);
		}
		return vo1;
	}

	// insert
	public int insert(RevuVO VO) {
		int result = 0;
		Connection conn = connect();

		if (conn != null) {
			PreparedStatement ps = null;

			String sql = "INSERT INTO review (user_id, product_id, star, title, content, c_date)"
					+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
			try {
				ps = conn.prepareStatement(sql);

				ps.setString(1, VO.getUserId());
				ps.setString(2, VO.getProduct());
				ps.setInt(3, VO.getStar());
				ps.setString(4, VO.getTitle());
				ps.setString(5, VO.getContent());
				ps.setDate(6, (Date) VO.getcDate());

			} catch (Exception ex) {
				ex.printStackTrace();
			}

			closeDb(conn, ps);
		}

		return result;
	}

	/////// delete//////////
	public static int delete(String userId) {
		int result = 0;
		Connection conn = connect();

		if (conn != null) {
			PreparedStatement ps = null;
			String sql = "DELETE FROM review where userId=?";
			try {
				ps = conn.prepareStatement(sql);
				ps.setString(1, userId);
				result = ps.executeUpdate();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			closeDb(conn, ps);
		}
		return result;
	}

	/////////update///////
	public static int update(String userId, Date cDate) {
		Connection conn = connect();
		int result = 0;

		if (conn != null) {
			PreparedStatement ps = null;
			String sql = "UPDATE review SET cDate=? WEHRE userId=?";

			try {
				ps = conn.prepareStatement(sql);
				ps.setString(1, userId);
				ps.setDate(2, cDate);
				result = ps.executeUpdate();

			} catch (Exception ex) {
				ex.printStackTrace();
			}
			closeDb(conn, ps);
		}
		return result;
	}

}