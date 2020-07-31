package com.hit.hotel.goods.model;

import org.apache.ibatis.type.Alias;

@Alias("Goods")
public class GoodsModel {
	private Integer id = 0;
	private String uom = null;  //计量单位名称
	private String name = null;
	private String price = null;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUOM() {
		return uom;
	}

	public void setUOM(String uom) {
		this.uom = uom;
	}

	public String getgoodsName() {
		return name;
	}

	public void setgoodsName(String name) {
		this.name = name;
	}

	public String getSalePrice() {
		return price;
	}

	public void setSalePrice(String price) {
		this.price = price;
	}
}
