package com.winter.app.departments;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.winter.app.regions.RegionDTO;
import com.winter.app.util.DBConnector;

public class DepartmentDAO {
	//getDetail, 부서번호로 부서명 조회
	public void getDetail(DepartmentDTO departmentDTO) throws Exception{
		Connection con = DBConnector.getConnector();
		
		String sql = "SELECT DEPARTMENT_NAME FROM DEPARTMENTS WHERE DEPARTMENT_ID =?";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, departmentDTO.getDepartment_id());
		st.setString(2, departmentDTO.getDepartment_name());
		st.setInt(3, departmentDTO.getManager_id());
		st.setInt(4, departmentDTO.getLocation_id());
		
	}
	
	//getList, 부서테이블의모든 정보를 출력
	public List<DepartmentDTO> getList() throws Exception {
		List<DepartmentDTO> ar = new ArrayList<DepartmentDTO>();
		Connection con = DBConnector.getConnector();
		
		String sql = "SELECT * FROM DEPARTMENTS";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			DepartmentDTO dto = new DepartmentDTO();
			dto.setDepartment_id(rs.getInt("DEPARTMENT_ID") );
			dto.setDepartment_name(rs.getString("DEPARTMENT_NAME"));
			dto.setManager_id(rs.getInt("MANAGER_ID"));
			dto.setLocation_id(rs.getInt("LOCATION_ID"));
			
			ar.add(dto);
		}
		
		DBConnector.disConnect(rs, st, con);
		
		return ar;
	
	}
}
