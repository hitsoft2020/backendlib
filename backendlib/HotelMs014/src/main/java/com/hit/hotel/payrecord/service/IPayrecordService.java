package com.hit.hotel.payrecord.service;

import java.util.List;

import com.hit.hotel.payrecord.model.PayrecordModel;

//支付记录的业务接口
public interface IPayrecordService {

	// 增加支付记录
	public int add(PayrecordModel dm) throws Exception;

	// 修改支付记录
	public void modify(PayrecordModel dm) throws Exception;

	// 删除支付记录
	public void delete(PayrecordModel dm) throws Exception;

	// 取得所有支付记录列表
	public List<PayrecordModel> getListByAll() throws Exception;

	// 取得所有支付记录列表,分页模式
	public List<PayrecordModel> getListByAllWithPage(int rows, int page) throws Exception;

	// 取得支付记录的个数
	public int getCountByAll() throws Exception;

	// 取得支付记录的显示页数
	public int getPageCountByAll(int rows) throws Exception;

	// 根据支付记录的no（PK）取得指定的支付记录对象
	public PayrecordModel getByNo(int no) throws Exception;

}
