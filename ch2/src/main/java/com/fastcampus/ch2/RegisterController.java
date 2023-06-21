package com.fastcampus.ch2;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller // ctrl+shift+o : 자동 import
public class RegisterController {
//	@GetMapping("/register/add") => GET 방식만 허용
//	@RequestMapping(value="/register/save", method={RequestMethod.POST, RequestMethod.GET})	
	@RequestMapping("/register/add")
	// 해당 메서드의 경우, 단순히 매핑을 하여 registerForm.jsp 페이지를 띄우는데 그치고 별도의 처리 작업이 없음
	// => 따라서 이 메서드는 viewController로 바꿀 수 있음.
	public String register() {
		return "registerForm"; //WEB-INF/view/registerForm.jsp
	} 

//	=> <view-controller path="/register/add" view-name="registerForm"/>

//	@RequestMapping(value="/register/save", method=RequestMethod.POST)
	@PostMapping("/register/save")
	public String save(User user, Model m) {
		// 1. 유효성 검사
	if (!isValid(user)) { // user가 유효하지 않은 정보라면? -> 다시 회원가입 창으로 돌아가야 함.
			@SuppressWarnings("deprecation")
			String msg = URLEncoder.encode("id를 잘못입력하셨습니다.");
			
			m.addAttribute("msg", msg);
			return "forward:/register/add";
//			return "redirect:/register/add?msg=" + msg; // msg속성값으로 경고 메세지 전송.
		}
		// 2. DB에 신규회원 정보 저장
		return "registerInfo";
	}

	private boolean isValid(User user) {
		// TODO Auto-generated method stub
		return false;
	}
}
