package com.hit.hotel.room.model;

import java.io.Serializable;
import org.apache.ibatis.type.Alias;

@Alias("Room")
public class RoomModel implements Serializable {
	private int no = 0;
	private String type = null;
	private String state = null;

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
