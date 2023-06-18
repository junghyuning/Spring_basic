package com.fastcampus.ch2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//서블릿은 기본적으로 싱글톤이므로 1개의 객체만 생성되고 1개의 인스턴스가 무한히 재활용되는 형태
//=> 최초 1회만 객체 생성 및 초기화(init) -> 그 이후에는 계속 재활용하여 서비스 호출

@WebServlet("/hello")
public class HelloSevlet extends HttpServlet{
	
	// 오버라이딩 메서드들 자동생성 방법 >> menubar >> source >> override/implements methods >> 해당 메서드들 check
	@Override
	public void init() throws ServletException {
		//1. 서블릿의 초기화 작업 담당
		System.out.println("[HelloSevlet] init() is called");
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//1. 입력 > 2. 처리 > 3. 출력\
		System.out.println("[HelloSevlet] service() is called");
		
	}

	@Override
	public void destroy() {
		//서블릿 unload : 서블릿이 메모리에서 제거될 때 컨테이너에 의해서 자동 호출됨
		System.out.println("[HelloSevlet] distroy() is called");
	}
}
