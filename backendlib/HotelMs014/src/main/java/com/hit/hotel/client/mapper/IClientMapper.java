package com.hit.hotel.client.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.hit.hotel.client.model.ClientModel;

@Mapper
public interface IClientMapper {
	// 增加客户
	@Mapper
	public void insert(ClientModel cm) throws Exception;

	// 修改客户
	@Mapper
	public void update(ClientModel cm) throws Exception;

	// 删除客户
	@Mapper
	public void delete(ClientModel cm) throws Exception;

	// 取得所有客户列表
	@Mapper
	public List<ClientModel> selectByAll() throws Exception;

	// 取得所有客户列表，分页模式 参数： start：起始位置； rows:取得记录格式，
	@Mapper
	public List<ClientModel> selectByAllWithPage(@Param("start") int start, @Param("rows") int rows) throws Exception;


	// 取得客户的个数
	@Mapper
	public int selectCountByAll() throws Exception;

	// 根据客户的no（PK）取得指定的客户对象
	@Mapper
	public ClientModel selectByNo(int no) throws Exception;

}