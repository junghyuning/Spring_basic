package com.fastcampus.ch2;

import java.lang.reflect.Method;

public class PrivateMethodCall {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
//		Hello hello = new Hello();
//		hello.main(); // private 이므로 외부 호출이 불가함.
		// 아까는 Reflection API를 사용한 것 -> 클래스 정보를 얻고 다룰 수 있는 강력한 기능을 제공하는 api
		//java.lang.reflect 패키지를 제공 함.
		//Hello클래스의 Class 객체(클래스의 정보를 담고있는 객체)를 얻어옴.
		Class helloClass = Class.forName("com.fastcampus.ch2.Hello"); 
		//클래스 설계도를 가지고온다는 것의 의미 -> 구성하는 객체, 멤버들의 정보를 모두 알게되는 것.
		//따라서, 위의 Class 객체를 통해 내부의 객체 또한 생성할 수 있음.
		Hello hello = (Hello)helloClass.newInstance();  // Class 객체가 가진 정보로 객체 생성 // newInstance()의 반환타입이 object 이므로 형변환 필요.
		
		//Hello클래스가 가진 main()메서드 (->private 제한자) 가져오기... getDeclaredMethod (reflect패키지의 method를 참조할때사용하는 클래스)
		Method main = helloClass.getDeclaredMethod("main");
		main.setAccessible(true);
		main.invoke(hello); // == hello.main()

	}

}
