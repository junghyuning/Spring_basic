package com.fastcampus.ch2;

import java.util.Arrays;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class User {
	
	private String id;
	private String pwd;
	private String name;
	private String email;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birth;
	private String[] sns;
	private String[] hobby;
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public String[] getHobby() {
		return hobby;
	}
	public void setHobby(String[] hobby) {
		this.hobby = hobby;
	}
	public User(String id, String pwd, String name, String email, Date birth, String[] sns, String[] hobby) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.email = email;
		this.birth = birth;
		this.sns = sns;
		this.hobby = hobby;
	}
	//ctrl+shift+r
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public String[] getSns() {
		return sns;
	}
	public void setSns(String[] sns) {
		this.sns = sns;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", pwd=" + pwd + ", name=" + name + ", email=" + email + ", birth=" + birth + ", sns="
				+ Arrays.toString(sns) + ", hobby=" + Arrays.toString(hobby) + "]";
	}
	
	
	
}
