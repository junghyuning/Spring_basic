package com.fastcampus.ch2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//������ �Է� -> ������ �˷��ִ� ���α׷�
//1. �Ͽ��� 2. ������ ...
@Controller
public class YoilTeller {
	@RequestMapping("/getYoil")
	public static void main(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		
		//1. �Է� : �Է��� ���� ���� �Ű����� args�� ����ǰ� �װ��� �޾� �� ������ ������
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		
		//2. �۾�	
		int yyyy = Integer.parseInt(year); // �Է¹��� ���� ������ �����̹Ƿ� ���ڷ� ����ȯ �ʿ�
		int mm = Integer.parseInt(month);
		int dd = Integer.parseInt(day);
		
		Calendar cal = Calendar.getInstance(); //�̱���
		cal.set(yyyy,mm-1,dd);  //�ҷ��� Ķ������ �Է¹��� ������ ���� (���� 0���� ���� ���� -1)
		
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); //�������� ������ Ķ���� ��ü�� ���� ���� �޾ƿ�
		char yoil = " �Ͽ�ȭ�������".charAt(dayOfWeek); //������ 1���� �����ϹǷ� 0�ڸ��� �������� �����
		
		//3.���
		
		//�������� ���� ������ ������ text���� bynary���� �˼� x 
		// Ÿ�� �� ���ڵ��� -> �̸� �˷��� ��.
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter(); //response ��ü���� ���������� ��� ��Ʈ���� ����
		//but, ������ html�̿��ؼ� ������ ��. ���̹����.
		out.println(year+"�� "+month+"�� "+day+"���� ");
		out.println(yoil + "�����Դϴ�.");
//		System.out.println(year+"�� "+month+"�� "+day+"���� ");
//		System.out.println(yoil + "�����Դϴ�.");
		
		
	}

}
