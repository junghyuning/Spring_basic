package com.spring.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//1. 원격 호출 가능한 프로그램으로 등록 -> @controller
@Controller
public class Hello {
	int iv =10;
	static int cv = 20;
	//2. URL과 메서드의 연결 -> @RequestMapping
	@RequestMapping("/hello")
	//해당 메서드는 static 메서드가 아닌, Instance 메서드인데 어떻게 호출 되는 것인가? 
	//=> 요청이 들어오면 중간(톰캣내부)에서 누군가가 객체를 생성해주고 있다는 의미
	private void main() { //1) 인스턴스 메서드 이므로 -> iv & cv 둘다 사용 가능 (Static의 경우 cv만 사용 가능함) => 따라서, 오히려 인스턴스 메서드로 작성하는것이 좋음
		//3) private 일 경우? => 실행 됨. why? @RequestMapping 이라는 어노테이션을 통해 URL 연결을 하겠다는 의미이므로 접근제한자에 관계없이 외부에서 호출 가능하도록 하겠다는 것임
		//=> but 클래스 내부에서는 private으로 진행 됨.
		//but 해당 명령어는 콘솔에 출력하는 명령어이므로 서버에 출력되는 것으 없음.
		System.out.println("Hello - private");
		System.out.println(cv);  //ok
//		System.out.println(iv);  //ok
		
	}
	
	public static void main2() {  //2) static 메서드 -> cv만 사용 가능
		System.out.println(cv);  //ok
//		System.out.println(iv);  //불가능
		
		
	}
}
