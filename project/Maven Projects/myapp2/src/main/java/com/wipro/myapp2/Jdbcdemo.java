package com.wipro.myapp2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Jdbcdemo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		String driverClassName = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String username = "wipro";
		String password = "wipro123";

		Class.forName(driverClassName);
		System.out.println("Driver loaded");

		Connection con = DriverManager.getConnection(url, username, password);
		System.out.println("connected");

		con.close();
		System.out.println("connection closed");

	}
}
