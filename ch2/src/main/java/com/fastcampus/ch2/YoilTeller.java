package com.fastcampus.ch2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//연월일 입력 -> 요일을 알려주는 프로그램
//1. 일요일 2. 월요일 ...
@Controller
public class YoilTeller {
	@RequestMapping("/getYoil")
	public static void main(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		
		//1. 입력 : 입력을 받은 값이 매개변수 args에 저장되고 그것을 받아 각 변수에 저장함
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		
		//2. 작업	
		int yyyy = Integer.parseInt(year); // 입력받은 값의 형식이 문자이므로 숫자로 형변환 필요
		int mm = Integer.parseInt(month);
		int dd = Integer.parseInt(day);
		
		Calendar cal = Calendar.getInstance(); //싱글톤
		cal.set(yyyy,mm-1,dd);  //불러올 캘린더에 입력받은 연월일 설정 (월이 0부터 시작 따라서 -1)
		
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); //연월일을 저장한 캘린더 객체를 통해 요일 받아옴
		char yoil = " 일월화수목금토".charAt(dayOfWeek); //요일이 1부터 시작하므로 0자리는 공백으로 비워둠
		
		//3.출력
		
		//브라우저는 내가 보내는 내용이 text인지 bynary인지 알수 x 
		// 타입 및 인코딩을 -> 미리 알려야 함.
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter(); //response 객체에서 브라우저로의 출력 스트림을 얻음
		//but, 원래는 html이용해서 보내야 함. 간이방식임.
		out.println(year+"년 "+month+"월 "+day+"일은 ");
		out.println(yoil + "요일입니다.");
//		System.out.println(year+"년 "+month+"월 "+day+"일은 ");
//		System.out.println(yoil + "요일입니다.");
		
		
	}

}
