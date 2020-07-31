package com.hit.hotel.payout.service;

import java.util.List;

import com.hit.hotel.payout.model.PayoutModel;

public interface IPayoutService {
	// 增加记录
	public int add(PayoutModel pm) throws Exception;

	// 修改记录
	public void modify(PayoutModel pm) throws Exception;

	// 删除记录
	public void delete(PayoutModel pm) throws Exception;

	// 获取全部记录
	public List<PayoutModel> getListByAll() throws Exception;

	// 取得所有记录列表,分页模式
	public List<PayoutModel> getListByAllWithPage(int rows, int page) throws Exception;

	// 取得记录的个数
	public int getCountByAll() throws Exception;

	// 获取记录的显示页数
	public int getPageCountByAll(int rows) throws Exception;

	// 根据记录的no（PK）取得指定的支出记录对象
	public PayoutModel getByNo(int no) throws Exception;
}
