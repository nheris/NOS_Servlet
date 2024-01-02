package com.winter.app.test;

import java.util.List;

import com.winter.app.departments.DepartmentDAO;
import com.winter.app.departments.DepartmentDTO;
import com.winter.app.regions.RegionDAO;
import com.winter.app.regions.RegionDTO;
import com.winter.app.util.DBConnector;
import com.winter.app.views.View;

public class AppMain {

	public static void main(String[] args) throws Exception {
		DepartmentDAO dao = new DepartmentDAO();
		DepartmentDTO dto = new DepartmentDTO();
		RegionDAO regionDAO = new RegionDAO();
//		View view = new View();
		
		dto.setDepartment_id(3);
		dto.setDepartment_name("2");
		dto.setLocation_id(1700);
		dto.setManager_id(196);
		int result = dao.insert(dto);
		System.out.println(result);
		

		
//		try {
//			 RegionDTO regionDTO = new RegionDTO();
//			 regionDTO.setRegion_id(6);
//			 regionDTO = regionDAO.getDetail(regionDTO);
//			 
//			 if(regionDTO!=null) {
//				 System.out.println(regionDTO.getRegion_name());
//			 }else {
//				 System.out.println("없는 ID");
//			 }
//			 
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}

}
