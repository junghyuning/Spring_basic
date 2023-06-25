package com.fastcampus.ch2;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


	public class GlobalValidator implements Validator {
		@Override
		public boolean supports(Class<?> clazz) {
//			return User.class.equals(clazz); // 검증하려는 객체가 User타입인지 확인
			return User.class.isAssignableFrom(clazz); // clazz가 User 또는 그 자손인지 확인
		}

		@Override
		public void validate(Object target, Errors errors) { 
			System.out.println("GlobalValidator.validate() is called");

			User user = (User)target;
			
			String id = user.getId();
			
	//		if(id==null || "".equals(id.trim())) { // 아이디가 null이거나 빈문자열일경우, errors에다가 에러 저장
	//			errors.rejectValue("id", "required");// errors 객체의 id필드에 required라는 에러코드를 저장함
	//		}
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id",  "required"); //id 필드가 비엇거나, 여백공간일 경우 에러 반환하는 메서드
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pwd", "required");
			
			if(id==null || id.length() <  5 || id.length() > 12) {
				errors.rejectValue("id", "invalidLength" , new String[]{"","5","12"}, null);
			}
		}
	}


