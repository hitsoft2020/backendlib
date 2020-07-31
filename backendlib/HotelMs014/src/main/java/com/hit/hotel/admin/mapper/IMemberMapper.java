package com.hit.hotel.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.hit.hotel.admin.model.UserModel;

//用户的Mapper接口（DAO接口）
@Mapper
public interface IMemberMapper {
	// 增加用户
	public void insert(UserModel um) throws Exception;

	// 修改用户
	public void update(UserModel um) throws Exception;

	// 删除用户
	public void delete(UserModel um) throws Exception;

	// 取得所有用户列表
	public List<UserModel> selectByAll() throws Exception;

	// 取得所有用户列表，分页模式 参数： start：起始位置； rows:取得记录格式，
	public List<UserModel> selectByAllWithPage(@Param("start") int start, @Param("rows") int rows) throws Exception;

	// 取得用户的个数
	public int selectCountByAll() throws Exception;

	// 根据用户的no（PK）取得指定的用户对象
	public UserModel selectByNo(int no) throws Exception;

	// 取得指定的用户，并取得其关联的员工集合
	public UserModel selectByNoWithEmployees(int no) throws Exception;

}
