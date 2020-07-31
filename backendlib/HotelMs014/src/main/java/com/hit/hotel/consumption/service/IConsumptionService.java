package com.hit.hotel.consumption.service;

import java.util.List;
import java.util.Date;

import com.hit.hotel.consumption.model.ConsumptionModel;

//消费记录的业务接口
public interface IConsumptionService {
	
	//增加消费记录
	public int add(ConsumptionModel cm) throws Exception;
	//修改消费记录
	public void modify(ConsumptionModel cm) throws Exception;
	//删除消费记录
	public void delete(ConsumptionModel cm) throws Exception;
	//取得消费记录列表
	public List<ConsumptionModel> getListByAll() throws Exception;
	//取得消费记录列表,分页模式
	public List<ConsumptionModel> getListByAllWithPage(int rows, int page) throws Exception;
	//取得消费记录的个数
	public int getCountByAll() throws Exception;
	//取得消费记录的显示页数
	public int getPageCountByAll(int rows) throws Exception;
	//根据消费记录的no（PK）取得指定对象
	public ConsumptionModel getByNo(int id) throws Exception;
}
