package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Demo UpdataDemo
 *
 * @author sunlianyu
 * @date 2021/8/8 14:18
 */
public class UpdataDemo {
	public static void main(String[] args) {

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bz?serverTimezone=UTC", "root", "root");
			String sql = "UPDATE customers SET cust_city = 'harbin' WHERE cust_id = '10009' ";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.execute();
			System.out.println("修改成功");
			connection.close();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
