package com.fastcampus.ch2;

import java.lang.reflect.Method;

public class PrivateMethodCall {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
//		Hello hello = new Hello();
//		hello.main(); // private �̹Ƿ� �ܺ� ȣ���� �Ұ���.
		// �Ʊ�� Reflection API�� ����� �� -> Ŭ���� ������ ��� �ٷ� �� �ִ� ������ ����� �����ϴ� api
		//java.lang.reflect ��Ű���� ���� ��.
		//HelloŬ������ Class ��ü(Ŭ������ ������ ����ִ� ��ü)�� ����.
		Class helloClass = Class.forName("com.fastcampus.ch2.Hello"); 
		//Ŭ���� ���赵�� ������´ٴ� ���� �ǹ� -> �����ϴ� ��ü, ������� ������ ��� �˰ԵǴ� ��.
		//����, ���� Class ��ü�� ���� ������ ��ü ���� ������ �� ����.
		Hello hello = (Hello)helloClass.newInstance();  // Class ��ü�� ���� ������ ��ü ���� // newInstance()�� ��ȯŸ���� object �̹Ƿ� ����ȯ �ʿ�.
		
		//HelloŬ������ ���� main()�޼��� (->private ������) ��������... getDeclaredMethod (reflect��Ű���� method�� �����Ҷ�����ϴ� Ŭ����)
		Method main = helloClass.getDeclaredMethod("main");
		main.setAccessible(true);
		main.invoke(hello); // == hello.main()

	}

}
