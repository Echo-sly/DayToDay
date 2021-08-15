package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Demo SelectDemo
 *
 * @author sunlianyu
 * @date 2021/8/6 18:11
 */
public class SelectDemo {
	public static void main(String[] args) {
		Connection con;
		PreparedStatement pstmt;
		ResultSet rs;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bz?serverTimezone=UTC", "root", "root");
			String sql = "SELECT * FROM customers;";

			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				System.out.println(rs.getInt("cust_id")
						+ rs.getString("cust_name")
						+ rs.getString("cust_address")
						+ rs.getString("cust_city")
						+ rs.getString("cust_state")
						+ rs.getString("cust_zip")
						+ rs.getString("cust_country")
						+ rs.getString("cust_contact")
						+ rs.getString("cust_email")
				);
			}
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
