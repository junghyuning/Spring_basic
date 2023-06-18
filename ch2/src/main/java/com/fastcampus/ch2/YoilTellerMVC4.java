package com.fastcampus.ch2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
//< Ch. 02 Spring MVC - 06. ���� ���� - server.xml, web.xml > ���� ��Ʈ ��ȣ 80���� ���� -> url�� ��Ʈ��ȣ �ۼ� ���ʿ�
//������ �Է� -> ������ �˷��ִ� ���α׷�
//1. �Ͽ��� 2. ������ ...
@Controller
public class YoilTellerMVC4 { //http://localhost/ch2/getYoilMVC?year=2021&month=10&day=1 
	@ExceptionHandler
	public String catcher(Exception ex) {
		ex.printStackTrace();
		return "yoilError";
	}
	
	@RequestMapping("/getYoilMVC4")
	//year,month,day -> MydateŬ������ �����Ͽ� �ϳ��� �Ű������� ���
	public static String main(MyDate date, Model model) throws IOException {
		
		
		//�ʿ��� �κ� 1. ��ȿ���˻�
		if(!isValid(date))
			return "yoilError";
		
		char yoil = getYoil(date);
		
		model.addAttribute("myDate", date);
		model.addAttribute("yoil", yoil);
		

		//MVC_3 �𵨰�ü�� ������ view ���� 
		//-> return�� �ڷ����� String �̹Ƿ� main�޼����� ��ȯ �ڷ����� String �� �ž� ��
		return "yoil"; // WEB-INF/views/yoil.jsp�� �̿��Ͽ� ���� ����϶�� �ǹ�
	}

	
private static boolean isValid(MyDate date) {
		// TODO Auto-generated method stub
		return isValid(date.getYear(), date.getMonth(), date.getDay());
	}

private static char getYoil(MyDate date) {
		// TODO Auto-generated method stub
		return getYoil(date.getYear(), date.getMonth(), date.getDay());
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
