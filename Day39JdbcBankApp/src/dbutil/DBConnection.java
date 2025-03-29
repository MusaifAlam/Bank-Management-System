package dbutil;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private static Connection con = null;

	public static Connection getConnection() {

		try {

			if (con == null || con.isClosed()) {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Ranchi", "root", "Root");
				return con;
			}

		} catch (ClassNotFoundException | SQLException e) {

			System.err.println("Connection Issue ..... " + e.getMessage());

		}
		return con;
	}
}
