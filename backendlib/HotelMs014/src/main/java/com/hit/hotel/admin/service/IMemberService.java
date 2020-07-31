package com.hit.hotel.admin.service;

import java.util.List;

import com.hit.hotel.admin.model.UserModel;

//用户的业务接口
public interface IMemberService {

	// 增加用户
	public String add(UserModel um) throws Exception;

	// 修改用户
	public void modify(UserModel um) throws Exception;

	// 删除用户
	public void delete(UserModel um) throws Exception;

	// 取得所有用户列表
	public List<UserModel> getListByAll() throws Exception;

	// 取得所有用户列表,分页模式
	public List<UserModel> getListByAllWithPage(int rows, int page) throws Exception;

	// 取得用户的个数
	public int getCountByAll() throws Exception;

	// 取得用户的显示页数
	public int getPageCountByAll(int rows) throws Exception;

	// 根据用户的no（PK）取得指定的用户对象
	public UserModel getByNo(int id) throws Exception;

}
