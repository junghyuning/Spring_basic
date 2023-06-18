package com.fastcampus.ch2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//������ �⺻������ �̱����̹Ƿ� 1���� ��ü�� �����ǰ� 1���� �ν��Ͻ��� ������ ��Ȱ��Ǵ� ����
//=> ���� 1ȸ�� ��ü ���� �� �ʱ�ȭ(init) -> �� ���Ŀ��� ��� ��Ȱ���Ͽ� ���� ȣ��

@WebServlet("/hello")
public class HelloSevlet extends HttpServlet{
	
	// �������̵� �޼���� �ڵ����� ��� >> menubar >> source >> override/implements methods >> �ش� �޼���� check
	@Override
	public void init() throws ServletException {
		//1. ������ �ʱ�ȭ �۾� ���
		System.out.println("[HelloSevlet] init() is called");
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//1. �Է� > 2. ó�� > 3. ���\
		System.out.println("[HelloSevlet] service() is called");
		
	}

	@Override
	public void destroy() {
		//���� unload : ������ �޸𸮿��� ���ŵ� �� �����̳ʿ� ���ؼ� �ڵ� ȣ���
		System.out.println("[HelloSevlet] distroy() is called");
	}
}
