package com.fastcampus.ch2;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class MethodCall {
	public static void main(String[] args) throws Exception{
		HashMap map = new HashMap();  //���θ޼��忡�� �� ������ 
		System.out.println("before:"+map);
		
		
		//### �ش� ������ ��Ʈ�ѷ��� ���� ���� �� ȣ��
		ModelController mc = new ModelController();  
		String viewName = mc.main(map); //��Ʈ�ѷ� ���� ��, map ȣ��(�Ű������� �Ѱ� ��) -> view �̸� ��ȯ
		//(��, ��Ʈ�ѷ��� map���� ������ main�� �� �ʿ� ����(���ʿ� main�޼��尡 �������ִ� ������)
		
		System.out.println("after :"+map); //map�� ����(data)
		
		render(map, viewName); 
	}
	
	static void render(HashMap map, String viewName) throws IOException {
		String result = "";
		
		// 1. ���� ������ ���پ� �о �ϳ��� ���ڿ��� �����.
		Scanner sc = new Scanner(new File(viewName+".txt"));
		
		while(sc.hasNextLine())
			result += sc.nextLine()+ System.lineSeparator();
		
		// 2. map�� ��� key�� �ϳ��� �о template�� ${key}�� value�ٲ۴�.
		Iterator it = map.keySet().iterator();
		
		while(it.hasNext()) {
			String key = (String)it.next();

			// 3. replace()�� key�� value ġȯ�Ѵ�.
			result = result.replace("${"+key+"}", (String)map.get(key));
		}
		
		// 4.������ ����� ����Ѵ�.
		System.out.println(result);
	}
}

class ModelController { //��¥ ��Ʈ�ѷ��� �ƴ�
	public String main(HashMap map) { // �Ű������� map �� ����
		//�۾������ map�� ����
		map.put("id", "asdf");
		map.put("pwd", "1111");
		
		return "txtView2"; //�� �̸� ��ȯ 
		//=> view�� ������ ������ �ΰ� ��ȯ Ÿ�Ը� �����, �ش� view�� �´� �������� ��� ��
	}
}

/*
 * [txtView1.txt] id=${id}, pwd=${pwd}
 * 
 * [txtView2.txt] id:${id} pwd:${pwd}
 * 
 * 
 * 
 * [������] 
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

