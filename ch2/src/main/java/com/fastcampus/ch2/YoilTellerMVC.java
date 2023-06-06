package com.fastcampus.ch2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
//< Ch. 02 Spring MVC - 06. ���� ���� - server.xml, web.xml > ���� ��Ʈ ��ȣ 80���� ���� -> url�� ��Ʈ��ȣ �ۼ� ���ʿ�
//������ �Է� -> ������ �˷��ִ� ���α׷�
//1. �Ͽ��� 2. ������ ...
@Controller
public class YoilTellerMVC { //http://localhost/ch2/getYoilMVC?year=2021&month=10&day=1 
	@RequestMapping("/getYoilMVC")
//	public static void main(HttpServletRequest request, HttpServletResponse response) throws IOException {
	//MVC_1. �Էº��� �и�
//	public static void main(String year, String month, String month, HttpServletResponse response) throws IOException {
	//MVC_2. �ڵ� ����ȯ (����ó ����) 
	public static String main(int year, int month, int day, Model model) throws IOException {
		
		
		//�ʿ��� �κ� 1. ��ȿ���˻�
		if(!isValid(year,month,day))
			return "yoilError";
		
		char yoil = getYoil(year, month, day);
		
		model.addAttribute("year", year);
		model.addAttribute("month", month);
		model.addAttribute("day", day);
		model.addAttribute("yoil", yoil);
		

		//MVC_3 �𵨰�ü�� ������ view ���� 
		//-> return�� �ڷ����� String �̹Ƿ� main�޼����� ��ȯ �ڷ����� String �� �ž� ��
		return "yoil"; // WEB-INF/views/yoil.jsp�� �̿��Ͽ� ���� ����϶�� �ǹ�
	}

	
private static boolean isValid(int year, int month, int day) {
	// TODO Auto-generated method stub
	return true;
}


//block ���� >> refactor >> extract Method >> �����̺� �޼���� �и� ��.
private static char getYoil(int year, int month, int day) {
	Calendar cal = Calendar.getInstance(); // �̱���
	cal.set(year, month - 1, day); // �ҷ��� Ķ������ �Է¹��� ������ ���� (���� 0���� ���� ���� -1)

	int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); // �������� ������ Ķ���� ��ü�� ���� ���� �޾ƿ�
	//����Ÿ�� char�� ����
	return " �Ͽ�ȭ�������".charAt(dayOfWeek); // ������ 1���� �����ϹǷ� 0�ڸ��� �������� �����
}

}
