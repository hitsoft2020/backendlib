package com.hit.hotel.payrecord.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.hit.hotel.payrecord.model.PayrecordModel;

//支付记录的Mapper接口（DAO接口）
@Mapper
public interface IPayrecordMapper {
	// 增加支付记录
	public void insert(PayrecordModel dm) throws Exception;

	// 修改支付记录
	public void update(PayrecordModel dm) throws Exception;

	// 删除支付记录
	public void delete(PayrecordModel dm) throws Exception;

	// 取得所有支付记录列表
	public List<PayrecordModel> selectByAll() throws Exception;

	// 取得所有支付记录列表，分页模式 参数： start：起始位置； rows:取得记录格式，
	public List<PayrecordModel> selectByAllWithPage(@Param("start") int start, @Param("rows") int rows) throws Exception;

	// 取得支付记录的个数
	public int selectCountByAll() throws Exception;

	// 根据支付记录的no（PK）取得指定的支付记录对象
	public PayrecordModel selectByNo(int no) throws Exception;

	// 取得指定的支付记录，并取得其关联的员工集合
	public PayrecordModel selectByNoWithEmployees(int no) throws Exception;

}
