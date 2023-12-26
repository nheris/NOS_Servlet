package com.winter.app.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.manager.DummyProxySession;

import com.winter.app.regions.RegionDAO;
import com.winter.app.regions.RegionDTO;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("/FrontController")
public class FrontController extends HttpServlet {//HttpServlet:톰캣에서 받은 라이브러리
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    //상속받은 메서드 오버라이딩
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("요청 발생");
		
		RegionDAO regionDAO = new RegionDAO();
		try {
			List<RegionDTO> ar = regionDAO.getList();
			
			PrintWriter out = response.getWriter(); //클라이언트ㅔㅇ게 보내는 소켓같은거??
			//옛날방식 불편...
			out.print("<h1>MyHome</h1>");
			out.println("<table>");
			for(RegionDTO regionDTO : ar) {
				out.println("<tr>");
				out.println("<td>");
				out.println(regionDTO.getRegion_id());
				out.println("</td>");
				out.println("<td>");
				out.println(regionDTO.getRegion_name());
				out.println("</td>");
				out.println("</tr>");
			}
			out.println("</table>");
			
			out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
