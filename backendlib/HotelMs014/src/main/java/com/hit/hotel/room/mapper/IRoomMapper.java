package com.hit.hotel.room.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.hit.hotel.room.model.RoomModel;

//房间的Mapper接口（DAO接口）
@Mapper
public interface IRoomMapper {
	// 增加房间
	public void insert(RoomModel dm) throws Exception;

	// 修改房间
	public void update(RoomModel dm) throws Exception;

	// 删除房间
	public void delete(RoomModel dm) throws Exception;

	// 取得所有房间列表
	public List<RoomModel> selectByAll() throws Exception;

	// 取得所有房间列表，分页模式 参数： start：起始位置； rows:取得记录格式，
	public List<RoomModel> selectByAllWithPage(@Param("start") int start, @Param("rows") int rows) throws Exception;

	// 取得房间的个数
	public int selectCountByAll() throws Exception;

	// 根据房间的no（PK）取得指定的房间对象
	public RoomModel selectByNo(int no) throws Exception;

	// 取得指定的房间，并取得其关联的员工集合
	public RoomModel selectByNoWithEmployees(int no) throws Exception;

}
