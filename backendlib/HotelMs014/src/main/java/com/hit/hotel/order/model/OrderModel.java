package com.hit.hotel.order.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Alias("Order")
public class OrderModel implements Serializable {
	private int no = 0;
	private String customername = null;
	private String idcard = null;
	private String contactinfo = null;
	private String roomtype = null;
	private int quantity = 0;
	private int saleprice = 0;
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private Date creatime = null;
	private String orderstatus = null;
	private int vipcard = 0;

	/**
	 * @return the no
	 */
	public int getNo() {
		return no;
	}

	/**
	 * @param no the no to set
	 */
	public void setNo(int no) {
		this.no = no;
	}

	/**
	 * @return the customername
	 */
	public String getCustomername() {
		return customername;
	}

	/**
	 * @param customername the customername to set
	 */
	public void setCustomername(String customername) {
		this.customername = customername;
	}

	/**
	 * @return the idcard
	 */
	public String getIdcard() {
		return idcard;
	}

	/**
	 * @param idcard the idcard to set
	 */
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	/**
	 * @return the contactinfo
	 */
	public String getContactinfo() {
		return contactinfo;
	}

	/**
	 * @param contactinfo the contactinfo to set
	 */
	public void setContactinfo(String contactinfo) {
		this.contactinfo = contactinfo;
	}

	/**
	 * @return the roomtype
	 */
	public String getRoomtype() {
		return roomtype;
	}

	/**
	 * @param roomtype the roomtype to set
	 */
	public void setRoomtype(String roomtype) {
		this.roomtype = roomtype;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the saleprice
	 */
	public int getSaleprice() {
		return saleprice;
	}

	/**
	 * @param saleprice the saleprice to set
	 */
	public void setSaleprice(int saleprice) {
		this.saleprice = saleprice;
	}

	/**
	 * @return the creatime
	 */
	public Date getCreatime() {
		return creatime;
	}

	/**
	 * @param creatime the creatime to set
	 */
	public void setCreatime(Date creatime) {
		this.creatime = creatime;
	}

	/**
	 * @return the orderstatus
	 */
	public String getOrderstatus() {
		return orderstatus;
	}

	/**
	 * @param orderstatus the orderstatus to set
	 */
	public void setOrderstatus(String orderstatus) {
		this.orderstatus = orderstatus;
	}

	/**
	 * @return the vipcard
	 */
	public int getVipcard() {
		return vipcard;
	}

	/**
	 * @param vipcard the vipcard to set
	 */
	public void setVipcard(int vipcard) {
		this.vipcard = vipcard;
	}

}
