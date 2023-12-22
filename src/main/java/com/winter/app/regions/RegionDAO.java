package com.winter.app.regions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.winter.app.util.DBConnector;

public class RegionDAO {
	public void getList() throws Exception{

		//코드 중복되니 제거
		Connection con =DBConnector.getConnector();
		
		//3.Sql문 생성
		String sql = "SELECT * FROM REGIONS"; 
		
		//4.SQL문 미리 전송
		PreparedStatement st = con.prepareStatement(sql);
		
		//5.
		
		//6.최종 전송 및 결과 처리(db:결과물은 ResultSet에 보관. 자바도 같음)
		ResultSet rs = st.executeQuery();
		
		List<RegionDTO> ar = new ArrayList<RegionDTO>();
		
		while (rs.next()){
			RegionDTO regionDTO = new RegionDTO();
			int n = rs.getInt("REGION_ID");
			regionDTO.setRegion_id(n);
			regionDTO.setRegion_name(rs.getString("REGION_NAME"));
			
			ar.add(regionDTO);
		}
		
		DBConnector.disConnect(rs, st, con);
		return ar;
	}
	
	
}
