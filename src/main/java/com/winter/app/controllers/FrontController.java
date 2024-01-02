package com.winter.app.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.winter.app.regions.RegionDAO;
import com.winter.app.regions.RegionDTO;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("/FrontController")
public class FrontController extends HttpServlet {//HttpServlet:톰캣에서 받은 라이브러리
	RegionDAO regionDAO; //Dependency Inject
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
	//모든 요청 정보 request안에 담음 그요청 보곳싶으면 request 부르면됨
	//응답에대한 정보 response안에 담음

    //상속받은 메서드 오버라이딩, 요청get으로 왔을때 실행	 위에걸 매개변수로
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String contextPath = request.getContextPath();
//		
//		System.out.println("Contenxt : "+contextPath);
//		
//		String method = request.getMethod();
//		System.out.println("method : "+method);
//		
//		String pathInfo = request.getPathInfo();
//		System.out.println("PathInfo : "+pathInfo);
//		
//		String uri = request.getRequestURI();
//		System.out.println("URI : "+uri);
//		String url = request.getRequestURL().toString();
//		System.out.println("URL : "+url);
//		String [] names = uri.split("/");
//		System.out.println(names.length);
//		for(String n:names) {
//			System.out.println(n);
//		}
		
		String uri = request.getRequestURI();
		String [] names = uri.split("/");
		String v = "/WEB-INF/views/index.jsp";//서버내부에서 움직이,접근하는 주소
		try {
			if(names[1].equals("regions")) {
				//regionDAO 사용
				RegionDAO regionDAO = new RegionDAO();//위에 선언해도됨
				if(names[2].equals("list")) {//이런식이면 길어지니 따로 클래스 만듦
					List<RegionDTO> ar = regionDAO.getList();
					request.setAttribute("list", ar);//키, 벨루
					v = "/WEB-INF/views/regions/list.jsp";
				}else if(names[2].equals("detail")) {
					String id = request.getParameter("region_id");
					RegionDTO regionDTO = new RegionDTO();
					regionDTO.setRegion_id(Integer.parseInt(id));
					regionDTO = regionDAO.getDetail(regionDTO);
					v= "/WEB-INF/views/regions/detail.jsp";
					request.setAttribute("dto", regionDTO);  //dto 말고 알아서 해도됨
				}
			}else if(names[1].equals("countries")) {
				//countriesDAO 사용
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		//jsp 경로 입력하는곳 (절대경로) "/WEB-INF/views/index.jsp" 밑 주소(jsp)로 request, response 보냄
		RequestDispatcher view = request.getRequestDispatcher(v);
		view.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
