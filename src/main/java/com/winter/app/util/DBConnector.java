package com.winter.app.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnector{
	public static Connection getConnector() throws Exception {
		String user = "user01";
		String password = "user01";
		String url = "jdbc:oracle:thin:@43.201.36.31:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, user, password);
//		System.out.println(con);
		
		return con;
	}
	
	//SELECT
	public static void disConnect(ResultSet rs,PreparedStatement st, Connection con) throws Exception {
		rs.close();
		st.close();
		con.close();
	}
	
	//INSERT, UPDATE, DELETE
	public static void disConnext(PreparedStatement st, Connection con) throws Exception {
		st.close();
		con.close();
	}
}
