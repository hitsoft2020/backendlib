package com.hit.hotel.room.service;

import java.util.List;

import com.hit.hotel.room.model.RoomModel;

//房间的业务接口
public interface IRoomService {

	// 增加房间
	public int add(RoomModel dm) throws Exception;

	// 修改房间
	public void modify(RoomModel dm) throws Exception;

	// 删除房间
	public void delete(RoomModel dm) throws Exception;

	// 取得所有房间列表
	public List<RoomModel> getListByAll() throws Exception;

	// 取得所有房间列表,分页模式
	public List<RoomModel> getListByAllWithPage(int rows, int page) throws Exception;

	// 取得房间的个数
	public int getCountByAll() throws Exception;

	// 取得房间的显示页数
	public int getPageCountByAll(int rows) throws Exception;

	// 根据房间的no（PK）取得指定的房间对象
	public RoomModel getByNo(int no) throws Exception;

}
