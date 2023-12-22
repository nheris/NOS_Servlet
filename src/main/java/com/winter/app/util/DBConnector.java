package com.winter.app.util;

import java.util.List;

import com.winter.app.departments.DepartmentDAO;
import com.winter.app.regions.RegionDAO;
import com.winter.app.regions.RegionDTO;
import com.winter.app.util.DBConnector;
import com.winter.app.views.View;

public class DBConnector {
	//1. IP:PORT
	//2. ID,PW
	public static Connection getConnector() throws Exception {
		//디비버 우클릭 에딧 커켓션 그대로
		String user = "user01";
		String password = "user01";
		String url = "jdbc:oracle:thin:@43.201.36.31:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		//oracle.jdbc.driver(패키지명).(클래스명)
	
		//1. dirver를 메모리에 로딩(객체 생성)
//		try {
			Class.forName(driver);//없을수도있어서 exception발생
			
			//2.DB에 연결
			Connection con = DriverManager.getConnection(url, user, password);//이정보로 로그인하고 오겠다.실패하면 null
			System.out.println(con);//null아니면 db에 접속 성공, db쿼리 결과 문자열로 받음
			
			return con;
			
			
//			//3.Sql문 생성
//			String sql = "SELECT * FROM REGIONS"; //디비버에 쳐서 되는지 확인하고 집어넣기!
//			
//			//4.SQL문 미리 전송
//			PreparedStatement st = con.prepareStatement(sql);
//			
//			//5.
//			
//			//6.최종 전송 및 결과 처리(db:결과물은 ResultSet에 보관. 자바도 같음)
//			ResultSet rs = st.executeQuery();//최종적으로 쿼리 실행해
//			//row한줄씩 읽는데 다음을 읽어라는 메서드. 내용없으면(null) false
//			while (rs.next()){
//				//한줄ㄹ 읽은걸 rs에 담음. rs = 1, Europe
//				int n = rs.getInt("REGION_ID");//컬럼명. 이걸로 쓰자 타입때문에
////				int n = rs.getInt(1);//인덱스 번호. 컬럼명 너무길때 근데 별칭쓰면됨..
//				String name = rs.getString("REGION_NAME");
////				String name = rs.getString(2);
//				System.out.println(n+" : "+name);
//				System.out.println("----------------------------");
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
	public static void disConnect (ResultSet rs, PreparedStatement st, Connection con) throws Exception {
		rs.close();
		st.close();
		con.close();
	}
}
