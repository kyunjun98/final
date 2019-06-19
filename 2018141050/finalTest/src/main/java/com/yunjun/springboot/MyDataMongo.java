package com.yunjun.springboot;

import java.util.Date;

import org.springframework.data.annotation.Id;

public class MyDataMongo {
	@Id
	private String id;
	
	private String idNum;
	private String name;
	private String pos;
	private String email;
	private String sex;
	private String memo;
	private int phone1;
	private int phone2;
	private int phone3;
	
	
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
	
}

