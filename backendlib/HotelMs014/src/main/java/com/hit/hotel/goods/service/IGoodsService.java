package com.hit.hotel.goods.service;

import java.util.List;

import com.hit.hotel.goods.model.GoodsModel;

//商品业务接口
public interface IGoodsService {

	//增加商品
	public int add(GoodsModel gm) throws Exception;
	//修改商品
	public void modify(GoodsModel gm) throws Exception;
	//删除商品
	public void delete(GoodsModel gm) throws Exception;
	//取得商品列表
	public List<GoodsModel> getListByAll() throws Exception;
	//取得商品列表,分页模式
	public List<GoodsModel> getListByAllWithPage(int rows, int page) throws Exception;
	//取得商品的个数
	public int getCountByAll() throws Exception;
	//取得商品的显示页数
	public int getPageCountByAll(int rows) throws Exception;
	//根据商品的no（PK）取得指定对象
	public GoodsModel getByNo(int id) throws Exception;
}
