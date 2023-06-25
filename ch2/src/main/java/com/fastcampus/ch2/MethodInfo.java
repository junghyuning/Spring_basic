package com.fastcampus.ch2;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.StringJoiner;

public class MethodInfo {
	public static void main(String[] args) throws Exception{
		
		//1.YoilTeller 클래스의 객체를 생성
		Class clazz = Class.forName("com.fastcampus.ch2.YoilTellerMVC");
		Object obj = clazz.newInstance();
		
		//2. 모든 메서드의 정보를 가져와 배열에 저장
		Method[] methodArr = clazz.getDeclaredMethods();
		
		for(Method m : methodArr) {
			String name = m.getName(); // 메서드의 이름
			Parameter[] paramArr = m.getParameters(); // 매개변수 목록
//			Class[] paramTypeArr = m.getParameterTypes();
			Class returnType = m.getReturnType(); //반환타입
			
			//"," : 구분자 / "(" : 접두사 / ")" : 접미사
			//메서드 매개변수 목록을 접두사 접미사로 감싸고 구분자로 구분하여 매개변수를 출력 
			StringJoiner paramList = new StringJoiner(", ", "(", ")");
			
			for(Parameter param : paramArr) {
				String paramName = param.getName();
				Class  paramType = param.getType();
				
				paramList.add(paramType.getName() + " " + paramName);
			}
			
			System.out.printf("%s %s%s%n", returnType.getName(), name, paramList);
		}
	} // main
}

/* [실행결과] Run on JavaApplication
void main(javax.servlet.http.HttpServletRequest arg0, javax.servlet.http.HttpServletResponse arg1) 
->  매개변수 이름 : arg0 / arg1
-> 실제 YoilTeller 클래스를 보면 매개변수의 이름은 request와 response 임
=> why? arg0,arg1로 저장됐을까? 컴파일러에게 매개변수의 이름은 중요한 정보가 아님 따라서 매개변수의 이름을 따로 저장하지는 않음
-> 따라서 컴파일한 후 매개변수의 이름을 요쳥할시 배열값으로 반환함
1. if 매개변수명이 꼭 필요하다면?  컴파일 옵션에 javac -parameters : 매개변수 이름 저장옵션 설정해야함
windows >> preferences >> compiler >> java >> compiler >> store information about method parameters
2. java version 설정
3. 프로젝트 업데이트
=> 실행결과 void main(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)


# YoilTellerMVC로 실행한 결과
java.lang.String main(java.lang.String year, java.lang.String month, java.lang.String day, org.springframework.ui.Model model)
boolean isValid(int year, int month, int day)
*/


