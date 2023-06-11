package com.fastcampus.ch2;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class MethodCall {
	public static void main(String[] args) throws Exception{
		HashMap map = new HashMap();  //메인메서드에서 맵 생성함 
		System.out.println("before:"+map);
		
		
		//### 해당 예제는 컨트롤러를 직접 생성 후 호출
		ModelController mc = new ModelController();  
		String viewName = mc.main(map); //컨트롤러 생성 후, map 호출(매개변수로 넘겨 줌) -> view 이름 반환
		//(즉, 컨트롤러는 map관련 정보를 main에 줄 필요 없음(애초에 main메서드가 가지고있는 정보임)
		
		System.out.println("after :"+map); //map의 정보(data)
		
		render(map, viewName); 
	}
	
	static void render(HashMap map, String viewName) throws IOException {
		String result = "";
		
		// 1. 뷰의 내용을 한줄씩 읽어서 하나의 문자열로 만든다.
		Scanner sc = new Scanner(new File(viewName+".txt"));
		
		while(sc.hasNextLine())
			result += sc.nextLine()+ System.lineSeparator();
		
		// 2. map에 담긴 key를 하나씩 읽어서 template의 ${key}를 value바꾼다.
		Iterator it = map.keySet().iterator();
		
		while(it.hasNext()) {
			String key = (String)it.next();

			// 3. replace()로 key를 value 치환한다.
			result = result.replace("${"+key+"}", (String)map.get(key));
		}
		
		// 4.렌더링 결과를 출력한다.
		System.out.println(result);
	}
}

class ModelController { //진짜 컨트롤러는 아님
	public String main(HashMap map) { // 매개변수로 map 을 설정
		//작업결과를 map에 저장
		map.put("id", "asdf");
		map.put("pwd", "1111");
		
		return "txtView2"; //뷰 이름 반환 
		//=> view를 여러개 생성해 두고 반환 타입만 변경시, 해당 view에 맞는 형식으로 출력 됨
	}
}

/*
 * [txtView1.txt] id=${id}, pwd=${pwd}
 * 
 * [txtView2.txt] id:${id} pwd:${pwd}
 * 
 * 
 * 
 * [실행결과] 
 * =>txtView1.txt
 * before:{} 
 * after :{id=asdf, pwd=1111} 
 * id:asdf pwd:1111
 * 
 * txtView2.txt
 * before:{}
 * after :{id=asdf, pwd=1111}
 * id=asdf, pwd=1111
 */

