package com.hit.hotel.goods.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.hit.hotel.goods.model.GoodsModel;

//商品的Mapper接口（DAO接口）
@Mapper
public interface IGoodsMapper {
	
	//增加商品
	public void insert(GoodsModel gm) throws Exception;
	//修改商品
	public void update(GoodsModel gm) throws Exception;
	//删除商品
	public void delete(GoodsModel gm) throws Exception;
	//取得商品列表
	public List<GoodsModel> selectByAll() throws Exception;
	//取得商品列表，分页模式 参数： start：起始位置； rows:取得记录格式， 
	public List<GoodsModel> selectByAllWithPage(@Param("start") int start,@Param("rows") int rows) throws Exception;
	//取得商品的个数
	public int selectCountByAll() throws Exception;
	//根据商品的no（PK）取得指定对象
	public GoodsModel selectByNo(int id) throws Exception;

}
