package com.hit.hotel.consumption.mapper;

import java.util.List;
import java.util.Date;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.hit.hotel.consumption.model.ConsumptionModel;

//消费记录的Mapper接口（DAO接口）
@Mapper
public interface IConsumptionMapper {
	//增加消费记录
	public void insert(ConsumptionModel cm) throws Exception;
	//修改消费记录
	public void update(ConsumptionModel cm) throws Exception;
	//删除消费记录
	public void delete(ConsumptionModel cm) throws Exception;
	//取得消费记录列表
	public List<ConsumptionModel> selectByAll() throws Exception;
	//取得消费记录列表，分页模式 参数： start：起始位置； rows:取得记录格式， 
	public List<ConsumptionModel> selectByAllWithPage(@Param("start") int start,@Param("rows") int rows) throws Exception;
	//取得消费记录的个数
	public int selectCountByAll() throws Exception;
	//根据消费记录的no（PK）取得指定对象
	public ConsumptionModel selectByNo(int id) throws Exception;
}
