package com.fastcampus.  ch2;

import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {
	@GetMapping("/login")
	public String loginForm() {
		return "loginForm";
	}
	
	@PostMapping("/login")
	public String login(String id, String pwd, boolean rememberId, HttpServletResponse response) throws Exception{
		System.out.println("id = "+ id);
		System.out.println("pwd = "+ pwd);
		// check박스 체크 시, String rememberedId = on 반환. 
		// rememberedId자료형을 boolean으로 변경 시 T/F반환
		System.out.println("rememberId = "+ rememberId); 
		//1. id와 pw 확인
		if(!(loginCheck(id,pwd))) {
			String msg= URLEncoder.encode("id 또는 pwd가 일치하지 않습니다.","utf-8");
			//2. id,pw 불일치시, loginForm으로 이동(+ 오류메세지 출력)
			return "redirect:/login/login?msg="+msg ;
		}
		
		//2-1. id, pw 일치 시, 홈으로 이동
		if(rememberId) {
			//1) 쿠키생성
			Cookie cookie = new Cookie("id", id);
			//2) 응답에 저장
			response.addCookie(cookie);			
		} else {
			Cookie cookie = new Cookie("id", id);
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
			//3) 홈으로 이동
		return "redirect:/";
	}
	
	private boolean loginCheck(String id, String pwd) {
		return "asdf".equals(id) && "1234".equals(pwd);
	}
}
