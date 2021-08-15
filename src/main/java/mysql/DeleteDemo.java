package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Demo DeleteDemo
 *
 * @author sunlianyu
 * @date 2021/8/8 14:21
 */
public class DeleteDemo {
	public static void main(String[] args) {
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bz?serverTimezone=UTC", "root", "root");
			String sql = "DELETE FROM customers WHERE cust_id = 10009";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.execute();
			System.out.println("删除成功");
			connection.close();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
