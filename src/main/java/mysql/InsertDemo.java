package mysql;

import java.sql.*;
import java.util.Scanner;

/**
 * Demo InsertDemo
 *
 * @author sunlianyu
 * @date 2021/8/8 13:53
 */
public class InsertDemo {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bz?serverTimezone=UTC", "root", "root");
			String sql = "INSERT INTO customers VALUE(10009,'','eeee','sssss','rrrrr','fffff','sssss','llll','ssss')";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.execute();
			System.out.println("添加成功");
			connection.close();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
