package com.Minko.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBConnector {
	private static final String UNICODE = "?useUnicode=true&serverTimezone=UTC&useSSL=true&verifyServerCertificate=false";
	private static final String URL = "jdbc:mysql://localhost/diplomadb" + UNICODE;
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	private static Connection connection;

	public JDBConnector() {
		try {
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Connection getConnection() {
		return connection;
	}
}
