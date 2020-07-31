package com.hit.hotel.roomtel.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.hit.hotel.roomtel.model.RoomtelModel;

//房间的Mapper接口（DAO接口）
@Mapper
public interface IRoomtelMapper {
	// 增加房间
	public void insert(RoomtelModel dm) throws Exception;

	// 修改房间
	public void update(RoomtelModel dm) throws Exception;

	// 删除房间
	public void delete(RoomtelModel dm) throws Exception;

	// 取得所有房间列表
	public List<RoomtelModel> selectByAll() throws Exception;

	// 取得所有房间列表，分页模式 参数： start：起始位置； rows:取得记录格式，
	public List<RoomtelModel> selectByAllWithPage(@Param("start") int start, @Param("rows") int rows) throws Exception;

	// 取得房间的个数
	public int selectCountByAll() throws Exception;

	// 根据房间的no（PK）取得指定的房间对象
	public RoomtelModel selectByNo(int no) throws Exception;

	// 取得指定的房间，并取得其关联的员工集合
	public RoomtelModel selectByNoWithEmployees(int no) throws Exception;

}
