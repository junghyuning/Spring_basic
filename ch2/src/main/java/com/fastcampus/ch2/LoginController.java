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
		// check�ڽ� üũ ��, String rememberedId = on ��ȯ. 
		// rememberedId�ڷ����� boolean���� ���� �� T/F��ȯ
		System.out.println("rememberId = "+ rememberId); 
		//1. id�� pw Ȯ��
		if(!(loginCheck(id,pwd))) {
			String msg= URLEncoder.encode("id �Ǵ� pwd�� ��ġ���� �ʽ��ϴ�.","utf-8");
			//2. id,pw ����ġ��, loginForm���� �̵�(+ �����޼��� ���)
			return "redirect:/login/login?msg="+msg ;
		}
		
		//2-1. id, pw ��ġ ��, Ȩ���� �̵�
		if(rememberId) {
			//1) ��Ű����
			Cookie cookie = new Cookie("id", id);
			//2) ���信 ����
			response.addCookie(cookie);			
		} else {
			Cookie cookie = new Cookie("id", id);
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
			//3) Ȩ���� �̵�
		return "redirect:/";
	}
	
	private boolean loginCheck(String id, String pwd) {
		return "asdf".equals(id) && "1234".equals(pwd);
	}
}
