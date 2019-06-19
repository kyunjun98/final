package com.yunjun.springboot;

import java.util.Date;

import org.springframework.data.annotation.Id;

public class MyDataMongo {
	@Id
	private String id;
	
	private String idNum;
	private String name;
	private int phone1;
	private int phone2;
	private int phone3;
	private String pos;
	private String email;
	private String sex;
	private String memo;
}
