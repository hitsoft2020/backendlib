package com.hit.hotel.client.model;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

@Alias("Client")
public class ClientModel implements Serializable {
//客户编号 姓名 性别 身份证号 联系方式(电话号码) 
	private int no = 0;
	private String name = null;
	private String sex = null;
	private String idno = null;
	private String phone_number = null;

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getIdno() {
		return idno;
	}

	public void setIdno(String idno) {
		this.idno = idno;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
}