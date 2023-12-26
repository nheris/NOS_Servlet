package com.winter.app.regions;

import java.lang.reflect.Executable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.winter.app.util.DBConnector;

public class RegionDAO {
	//getDetail, 지역번호로 지역이 조회
	public RegionDTO getDetail(RegionDTO regionDTO) throws Exception {
		Connection con = DBConnector.getConnector();
		String sql = "SELECT * FROM REGIONS WHERE REGION_ID=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, regionDTO.getRegion_id());
		ResultSet rs = st.executeQuery();
		
		regionDTO = null;
		if(rs.next()) {
			regionDTO = new RegionDTO();
			regionDTO.setRegion_id(rs.getInt("REGION_ID"));
			regionDTO.setRegion_name(rs.getString("REGION_NAME"));
		}
		
		return regionDTO;
	}
	
	
	
	//getList, 모든 정보를 출력
	public List<RegionDTO> getList() throws Exception{
		//코드 중복되니 제거
		Connection con = DBConnector.getConnector();
		
		String sql = "SELECT * FROM REGIONS";
	
		PreparedStatement st = con.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		List<RegionDTO> ar = new ArrayList<>();
		
		while(rs.next()){ //rs = 1, Europe
			RegionDTO dto = new RegionDTO();
			dto.setRegion_id(rs.getInt("REGION_ID"));
			dto.setRegion_name(rs.getString("REGION_NAME"));
			ar.add(dto);
		}
		
		DBConnector.disConnect(rs, st, con);
		
		return ar;
	}
	
}
