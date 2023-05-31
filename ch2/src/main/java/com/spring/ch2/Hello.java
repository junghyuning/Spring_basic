package com.spring.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//1. ���� ȣ�� ������ ���α׷����� ��� -> @controller
@Controller
public class Hello {
	int iv =10;
	static int cv = 20;
	//2. URL�� �޼����� ���� -> @RequestMapping
	@RequestMapping("/hello")
	//�ش� �޼���� static �޼��尡 �ƴ�, Instance �޼����ε� ��� ȣ�� �Ǵ� ���ΰ�? 
	//=> ��û�� ������ �߰�(��Ĺ����)���� �������� ��ü�� �������ְ� �ִٴ� �ǹ�
	private void main() { //1) �ν��Ͻ� �޼��� �̹Ƿ� -> iv & cv �Ѵ� ��� ���� (Static�� ��� cv�� ��� ������) => ����, ������ �ν��Ͻ� �޼���� �ۼ��ϴ°��� ����
		//3) private �� ���? => ���� ��. why? @RequestMapping �̶�� ������̼��� ���� URL ������ �ϰڴٴ� �ǹ��̹Ƿ� ���������ڿ� ������� �ܺο��� ȣ�� �����ϵ��� �ϰڴٴ� ����
		//=> but Ŭ���� ���ο����� private���� ���� ��.
		//but �ش� ��ɾ�� �ֿܼ� ����ϴ� ��ɾ��̹Ƿ� ������ ��µǴ� ���� ����.
		System.out.println("Hello - private");
		System.out.println(cv);  //ok
//		System.out.println(iv);  //ok
		
	}
	
	public static void main2() {  //2) static �޼��� -> cv�� ��� ����
		System.out.println(cv);  //ok
//		System.out.println(iv);  //�Ұ���
		
		
	}
}
