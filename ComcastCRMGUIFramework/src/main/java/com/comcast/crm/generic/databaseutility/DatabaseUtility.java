package com.comcast.crm.generic.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DatabaseUtility {
	Connection con;

	/**
	 * This method is used to establish connection to the database
	 * 
	 * @param url
	 * @param username
	 * @param password
	 */
	public void getDbConnection() {
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method is used to close the database connection
	 */
	public void closeDbConnection() {
		try {
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method is used to execute select query provided query
	 * 
	 * @param query
	 * @return
	 */
	public ResultSet executeSelectQuery(String query) {
		ResultSet result = null;
		try {
			Statement stat = con.createStatement();
			result = stat.executeQuery(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * This method is used to execute non-select queries provided with query
	 * 
	 * @param query
	 * @return
	 */
	public int executeNonSelectQuery(String query) {
		int result = 0;
		try {
			Statement stat = con.createStatement();
			result = stat.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
