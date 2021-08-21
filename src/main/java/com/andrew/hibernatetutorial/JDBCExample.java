package com.andrew.hibernatetutorial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExample {
	private final String DB_HOST = "jdbc:mysql://0.0.0.0/users";
	private final String DB_USER = "root";
	private final String DB_PASSWORD = "eequeiNuedeeGhae1ua6iejeith2Zee6";

	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection(DB_HOST, DB_USER, DB_PASSWORD);
	}

	public void getUsers() {
		try (Connection connection = getConnection();
				Statement statement = connection.createStatement();) {
			String query = "SELECT * FROM example";
			ResultSet resultSet = statement.executeQuery(query);

			while (resultSet.next()) {
				System.out.println("ID: " + resultSet.getInt("id"));
				System.out.println("Name: " + resultSet.getString("name"));
			}
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
	}

	public static void main(String[] args) {
		JDBCExample jdbcExample = new JDBCExample();
		jdbcExample.getUsers();
	}
}
