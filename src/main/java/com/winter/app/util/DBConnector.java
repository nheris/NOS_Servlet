package com.winter.app.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnector {
	//1. IP:PORT
	//2. ID,PW
	public void  getConnector() {
		//디비버 에딧 커켓션 그대로
		String user = "user01";
		String password = "user01";
		String url = "jdbc:oracle:thin:@43.201.36.31:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		//oracle.jdbc.driver(패키지명).(클래스명)
	
		//1. dirver를 메모리에 로딩(객체 생성)
		try {
			Class.forName(driver);//없을수도있어서 exception발생
			
			//2.DB에 연결
			Connection con = DriverManager.getConnection(url, user, password);//이정보로 로그인하고 오겠다.실패하면 null
			System.out.println(con);//null아니면 성공
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
