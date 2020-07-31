package com.hit.hotel.vip.service;

import java.util.List;

import com.hit.hotel.vip.model.VipModel;

//会员的业务接口
public interface IVipService {

	// 增加会员
	public int add(VipModel dm) throws Exception;

	// 修改会员
	public void modify(VipModel dm) throws Exception;

	// 删除会员
	public void delete(VipModel dm) throws Exception;

	// 取得所有会员列表
	public List<VipModel> getListByAll() throws Exception;

	// 取得所有会员列表,分页模式
	public List<VipModel> getListByAllWithPage(int rows, int page) throws Exception;

	// 取得会员的个数
	public int getCountByAll() throws Exception;

	// 取得会员的显示页数
	public int getPageCountByAll(int rows) throws Exception;

	// 根据会员的no（PK）取得指定的会员对象
	public VipModel getByNo(int no) throws Exception;

}
