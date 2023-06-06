package com.fastcampus.ch2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
//< Ch. 02 Spring MVC - 06. 설정 파일 - server.xml, web.xml > 에서 포트 번호 80으로 수정 -> url에 포트번호 작성 불필요
//연월일 입력 -> 요일을 알려주는 프로그램
//1. 일요일 2. 월요일 ...
@Controller
public class YoilTellerMVC { //http://localhost/ch2/getYoilMVC?year=2021&month=10&day=1 
	@RequestMapping("/getYoilMVC")
//	public static void main(HttpServletRequest request, HttpServletResponse response) throws IOException {
	//MVC_1. 입력부의 분리
//	public static void main(String year, String month, String month, HttpServletResponse response) throws IOException {
	//MVC_2. 자동 형변환 (디스패처 서블릿) 
	public static String main(int year, int month, int day, Model model) throws IOException {
		
		
		//필요한 부분 1. 유효성검사
		if(!isValid(year,month,day))
			return "yoilError";
		
		char yoil = getYoil(year, month, day);
		
		model.addAttribute("year", year);
		model.addAttribute("month", month);
		model.addAttribute("day", day);
		model.addAttribute("yoil", yoil);
		

		//MVC_3 모델객체를 전달할 view 지정 
		//-> return의 자료형이 String 이므로 main메서드의 반환 자료형이 String 이 돼야 함
		return "yoil"; // WEB-INF/views/yoil.jsp를 이용하여 값을 출력하라는 의미
	}

	
private static boolean isValid(int year, int month, int day) {
	// TODO Auto-generated method stub
	return true;
}


//block 지정 >> refactor >> extract Method >> 프라이빗 메서드로 분리 됨.
private static char getYoil(int year, int month, int day) {
	Calendar cal = Calendar.getInstance(); // 싱글톤
	cal.set(year, month - 1, day); // 불러올 캘린더에 입력받은 연월일 설정 (월이 0부터 시작 따라서 -1)

	int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); // 연월일을 저장한 캘린더 객체를 통해 요일 받아옴
	//리턴타입 char로 설정
	return " 일월화수목금토".charAt(dayOfWeek); // 요일이 1부터 시작하므로 0자리는 공백으로 비워둠
}

}
