package com.fastcampus.ch2;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.StringJoiner;

public class MethodInfo {
	public static void main(String[] args) throws Exception{
		
		//1.YoilTeller Ŭ������ ��ü�� ����
		Class clazz = Class.forName("com.fastcampus.ch2.YoilTellerMVC");
		Object obj = clazz.newInstance();
		
		//2. ��� �޼����� ������ ������ �迭�� ����
		Method[] methodArr = clazz.getDeclaredMethods();
		
		for(Method m : methodArr) {
			String name = m.getName(); // �޼����� �̸�
			Parameter[] paramArr = m.getParameters(); // �Ű����� ���
//			Class[] paramTypeArr = m.getParameterTypes();
			Class returnType = m.getReturnType(); //��ȯŸ��
			
			//"," : ������ / "(" : ���λ� / ")" : ���̻�
			//�޼��� �Ű����� ����� ���λ� ���̻�� ���ΰ� �����ڷ� �����Ͽ� �Ű������� ��� 
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

/* [������] Run on JavaApplication
void main(javax.servlet.http.HttpServletRequest arg0, javax.servlet.http.HttpServletResponse arg1) 
->  �Ű����� �̸� : arg0 / arg1
-> ���� YoilTeller Ŭ������ ���� �Ű������� �̸��� request�� response ��
=> why? arg0,arg1�� ���������? �����Ϸ����� �Ű������� �̸��� �߿��� ������ �ƴ� ���� �Ű������� �̸��� ���� ���������� ����
-> ���� �������� �� �Ű������� �̸��� �䫊�ҽ� �迭������ ��ȯ��
1. if �Ű��������� �� �ʿ��ϴٸ�?  ������ �ɼǿ� javac -parameters : �Ű����� �̸� ����ɼ� �����ؾ���
windows >> preferences >> compiler >> java >> compiler >> store information about method parameters
2. java version ����
3. ������Ʈ ������Ʈ
=> ������ void main(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)


# YoilTellerMVC�� ������ ���
java.lang.String main(java.lang.String year, java.lang.String month, java.lang.String day, org.springframework.ui.Model model)
boolean isValid(int year, int month, int day)
*/


