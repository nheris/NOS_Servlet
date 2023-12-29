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
    	//모든 요청 정보 request안에 담음 그요청 보곳싶으면 request 부르면됨
		//응답에대한 정보 response안에 담음
    
    //상속받은 메서드 오버라이딩, 요청get으로 왔을때 실행	 위에걸 매개변수로
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청한걸 보고픔 다하고 페이지 주소창에 루트/아무것나 쳐봐 localhost/asdfasdf
		String contextPath = request.getContextPath();
		System.out.println("Content : " + contextPath);
		
		String method = request.getMethod();
		System.out.println("method : " + method);
		
		String pathInfo = request.getPathInfo();
		System.out.println("pathInfo : " + pathInfo);
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/index.jsp");
		view.forward(request, response);
		
		String uri = request.getRequestURI();
		System.out.println("uri : " + uri);
		
		String url = request.getRequestURL().toString();
		System.out.println("url : " + url);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	//post방식으로 왓을때
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
