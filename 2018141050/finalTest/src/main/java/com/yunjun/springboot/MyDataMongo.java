package com.yunjun.springboot;

import java.util.Date;

import org.springframework.data.annotation.Id;

public class MyDataMongo {
	@Id
	private String id; 				//회원번호
	
	private String name;			//이름
	private String pos;				//주소
	private String email;			//이메일
	private String sex;				//성별
	private String memo;			//메모
	private String phone1;			//전화번호 앞자리
	private String phone2;			//전화번호 중간자리
	private String phone3;			//전화번호 끝자리
	private Date registerDate;		//가입날짜
	
	
	public MyDataMongo(String name, String pos, String email, String sex, String memo, 
					   String phone1, String phone2, String phone3) {
		this.name = name;
		this.pos = pos;
		this.email = email;
		this.sex = sex;
		this.memo = memo;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.phone3 = phone3;
		this.registerDate = new Date();
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPos() {
		return pos;
	}

	public void setPos(String pos) {
		this.pos = pos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public String getPhone3() {
		return phone3;
	}

	public void setPhone3(String phone3) {
		this.phone3 = phone3;
	}


	public Date getRegisterDate() {
		return registerDate;
	}


	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
}

