package com.hit.hotel.roomtel.service;

import java.util.List;

import com.hit.hotel.roomtel.model.RoomtelModel;

//房间的业务接口
public interface IRoomtelService {

	// 增加房间
	public int add(RoomtelModel dm) throws Exception;

	// 修改房间
	public void modify(RoomtelModel dm) throws Exception;

	// 删除房间
	public void delete(RoomtelModel dm) throws Exception;

	// 取得所有房间列表
	public List<RoomtelModel> getListByAll() throws Exception;

	// 取得所有房间列表,分页模式
	public List<RoomtelModel> getListByAllWithPage(int rows, int page) throws Exception;

	// 取得房间的个数
	public int getCountByAll() throws Exception;

	// 取得房间的显示页数
	public int getPageCountByAll(int rows) throws Exception;

	// 根据房间的no（PK）取得指定的房间对象
	public RoomtelModel getByNo(int no) throws Exception;

}
