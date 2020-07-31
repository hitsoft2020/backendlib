package com.hit.hotel.consumption.model;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import com.fasterxml.jackson.annotation.JsonFormat;

@Alias("Consumption")
public class ConsumptionModel {
	private int id = 0;
	private String room = null;
	private String goods = null;
	private String num = null;
	private String totel = null;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date time = null; 
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public String getGoods() {
		return goods;
	}

	public void setGoods(String goods) {
		this.goods = goods;
	}
	
	public String getconsumptionNumber() {
		return num;
	}

	public void setconsumptionNumber(String num) {
		this.num = num;
	}
	
	public String getconsumptionMoney() {
		return totel;
	}

	public void setconsumptionMoney(String totel) {
		this.totel = totel;
	}

	public Date getconsumptionTime() {
		return time;
	}

	public void setconsumptionTime(Date time) {
		this.time = time;
	}
}
