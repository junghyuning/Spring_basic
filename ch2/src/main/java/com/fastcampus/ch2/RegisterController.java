package com.fastcampus.ch2;

import java.net.URLEncoder;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringArrayPropertyEditor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller // ctrl+shift+o : 자동 import
@RequestMapping("/register")
public class RegisterController {
	@InitBinder 
	public void toDate(WebDataBinder binder){
		ConversionService conversionService = binder.getConversionService();
		//System.out.println("conversionService = "+ conversionService);
		//SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		//binder.registerCustomEditor(Date.class, new CustomDateEditor(df, false)); //false = 빈값을 허용할 것인지...
		binder.registerCustomEditor(String[].class, new StringArrayPropertyEditor("#")); // #을 구분자로하여 String을 String[] 배열에 저장하라는 의미
		//검증방법 (3) 수동검증
		//binder.setValidator(new UserValidator()); //로컬 발리데이터를 등록
		binder.addValidators(new UserValidator()); // 글로벌 벨리데이터가 있는 상황에서는 local이나 user validator는 추가로 등록하는 형태
		List<Validator> validList = binder.getValidators();
		System.out.println("validatorList = " + validList);
	}
	
//	@GetMapping("/register/add") => GET 방식만 허용
	@RequestMapping(value="/add", method={RequestMethod.POST, RequestMethod.GET})	
//	@RequestMapping("/register/add")
	// 해당 메서드의 경우, 단순히 매핑을 하여 registerForm.jsp 페이지를 띄우는데 그치고 별도의 처리 작업이 없음
	// => 따라서 이 메서드는 viewController로 바꿀 수 있음.
	public String register() {
		return "registerForm"; //WEB-INF/view/registerForm.jsp
	} 

//	=> <view-controller path="/register/add" view-name="registerForm"/>

//	@RequestMapping(value="/register/save", method=RequestMethod.POST)
	@PostMapping("/save")
	public String save(@Valid User user, BindingResult result, Model m) {
	System.out.println("result = "+result);
	System.out.println("user = "+user);
		// 1. 유효성 검사
	//검증방법 (2) validator를 사용한 수동 검증( 직접 생성 및 직접 호출)
//	UserValidator userValidator = new UserValidator();
//	userValidator.validate(user, result);//BindingResult는 Errors의 자손이므로 사용 가능
//	//User 객체를 검증한 결과 에러가 있으면, registerForm을 이용하여 에러를 보여줘야 함.
//	if(result.hasErrors()) {
//		return "registerForm";
//	}
	
//	if (!isValid(user)) { // user가 유효하지 않은 정보라면? -> 다시 회원가입 창으로 돌아가야 함.
//			@SuppressWarnings("deprecation")
//			String msg = URLEncoder.encode("id를 잘못입력하셨습니다.");
//			
//			m.addAttribute("msg", msg);
//			return "forward:/register/add";
////			return "redirect:/register/add?msg=" + msg; // msg속성값으로 경고 메세지 전송.
//		}
		// 2. DB에 신규회원 정보 저장
		return "registerInfo";
	}

	private boolean isValid(User user) {
		// TODO Auto-generated method stub
		return true;
	}
}
