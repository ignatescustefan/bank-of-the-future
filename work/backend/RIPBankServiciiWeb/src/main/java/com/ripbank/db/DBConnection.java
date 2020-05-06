package com.ripbank.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.logging.Log4J;

public class DBConnection {
	private static final String URL = "jdbc:mysql://localhost:3306/ripbank";
	private static final String USERNAME = "adminRIP";
	private static final String PASSWORD = "fqspL6rOcSyIRNbp";
	private static final DBConnection instance = new DBConnection();
	Connection conn;
	public static DBConnection getInstance() {
		return instance;
	}
	private DBConnection() {
		Log4J.getLogger().info("Loading driver...");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Log4J.getLogger().info("Driver loaded!");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException(
					"Cannot find the driver in the classpath!", e);
		}
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
