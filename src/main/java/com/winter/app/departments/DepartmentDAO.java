package com.winter.app.departments;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.winter.app.util.DBConnector;

public class DepartmentDAO {
	//DB접속 후 부서테이블의 모든 정보를 출력
	//1.접속정보
	//2.DB 연결
	//3.SQL문 생성
	//4.SQL문 미리 전송
	//5.? 값 세팅
	//6.최종 전송 및 결과 처리
	//7.자원해제
	public void getList() throws Exception {
		Connection con = DBConnector.getConnector();
		
		//3.
		String sql = "SELECT * FROM DEPARTMENTS";
		
		//4.
		PreparedStatement st = con.prepareStatement(sql);
		
		//5.
		
		//6.
		ResultSet rs = st.executeQuery(sql);
		while(rs.next()){
			int id =rs.getInt("DEPARTMENT_ID");
			String name =rs.getString("DEPARTMENT_NAME");
			int manager =rs.getInt("MANAGER_ID");
			int location =rs.getInt("LOCATION_ID");
			System.out.println(id+" : "+name+" : "+manager+" : "+location);
			System.out.println("--------------------------------");
			
		}
		
		DBConnector.disConnect(rs, st, con);
	}
}
