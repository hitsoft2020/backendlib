package com.hit.hotel.payout.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.hit.hotel.payout.model.PayoutModel;

@Mapper
public interface IPayoutMapper {
	
	// 增加记录
	public void insert(PayoutModel pm) throws Exception;

	// 修改记录
	public void update(PayoutModel pm) throws Exception;

	// 删除记录
	public void delete(PayoutModel pm) throws Exception;

	// 取得所有记录列表
	public List<PayoutModel> selectByAll() throws Exception;

	// 取得所有记录列表，分页模式 参数： start：起始位置； rows:取得记录格式，
	public List<PayoutModel> selectByAllWithPage(@Param("start") int start, @Param("rows") int rows) throws Exception;

	// 取得记录的个数
	public int selectCountByAll() throws Exception;

	// 根据记录的no（PK）取得指定的记录
	public PayoutModel selectByNo(int no) throws Exception;

}
