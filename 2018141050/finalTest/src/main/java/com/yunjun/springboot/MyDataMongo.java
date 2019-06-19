package com.yunjun.springboot;

import java.util.Date;

import org.springframework.data.annotation.Id;

public class MyDataMongo {
	@Id
	private String id; 			//고유번호
	
	private String idNum; 		//회원번호 
	private String name;		//이름
	private String pos;			//주소
	private String email;		//이메일
	private String sex;			//성별
	private String memo;		//메모
	private int phone1;			//전화번호 앞자리
	private int phone2;			//전화번호 중간자리
	private int phone3;			//전화번호 끝자리
	
	
	public MyDataMongo(String idNum, String name, String pos, String email, String sex, String memo, 
					   int phone1, int phone2, int phone3) {
		this.idNum = idNum;
		this.name = name;
		this.pos = pos;
		this.email = email;
		this.sex = sex;
		this.memo = memo;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.phone3 = phone3;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIdNum() {
		return idNum;
	}

	public void setIdNum(String idNum) {
		this.idNum = idNum;
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

	public int getPhone1() {
		return phone1;
	}

	public void setPhone1(int phone1) {
		this.phone1 = phone1;
	}

	public int getPhone2() {
		return phone2;
	}

	public void setPhone2(int phone2) {
		this.phone2 = phone2;
	}

	public int getPhone3() {
		return phone3;
	}

	public void setPhone3(int phone3) {
		this.phone3 = phone3;
	}
}

