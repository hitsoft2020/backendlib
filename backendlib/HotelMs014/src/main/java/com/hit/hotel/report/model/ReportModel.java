package com.hit.hotel.report.model;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import com.fasterxml.jackson.annotation.JsonFormat;

@Alias("Report")
public class ReportModel {
	private Integer id = 0;
	private String in = null;
	private String out = null;
	private String profit = null;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date time = null; 
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String gettodayIncome() {
		return in;
	}

	public void settodayIncome(String in) {
		this.in = in;
	}
	
	public String gettodayOutcome() {
		return out;
	}

	public void settodayOutcome(String out) {
		this.out = out;
	}
	
	public String gettodayProfit() {
		return profit;
	}

	public void settodayProfit(String profit) {
		this.profit = profit;
	}

	public Date getdate() {
		return time;
	}

	public void setdate(Date time) {
		this.time = time;
	}
}