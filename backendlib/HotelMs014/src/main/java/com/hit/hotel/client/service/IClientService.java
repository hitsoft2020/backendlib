package com.hit.hotel.client.service;

import java.util.List;

import com.hit.hotel.client.model.ClientModel;

public interface IClientService {
	// 增加客户
	public int add(ClientModel cm) throws Exception;

	// 修改客户
	public void modify(ClientModel cm) throws Exception;

	// 删除客户
	public void delete(ClientModel cm) throws Exception;

	// 获取全部客户
	public List<ClientModel> getListByAll() throws Exception;

	// 取得所有客户列表,分页模式
	public List<ClientModel> getListByAllWithPage(int rows, int page) throws Exception;

	// 取得客户的个数
	public int getCountByAll() throws Exception;

	// 获取客户的显示页数
	public int getPageCountByAll(int rows) throws Exception;

	// 根据客户的no（PK）取得指定的客户对象
	public ClientModel getByNo(int no) throws Exception;
}