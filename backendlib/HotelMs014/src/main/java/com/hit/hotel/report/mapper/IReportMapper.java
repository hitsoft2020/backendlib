package com.hit.hotel.report.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.hit.hotel.report.model.ReportModel;

//财务报表的Mapper接口（DAO接口）
@Mapper
public interface IReportMapper {
	//增加财务报表
	public void insert(ReportModel rm) throws Exception;
	// 修改财务报表
	public void update(ReportModel rm) throws Exception;
	// 删除财务报表
	public void delete(ReportModel rm) throws Exception;
	//取得财务报表列表
	public List<ReportModel> selectByAll() throws Exception;
	//取得财务报表列表，分页模式 参数： start：起始位置； rows:取得记录格式， 
	public List<ReportModel> selectByAllWithPage(@Param("start") int start,@Param("rows") int rows) throws Exception;
	//取得财务报表的个数
	public int selectCountByAll() throws Exception;
	//根据财务报表的no（PK）取得指定对象
	public ReportModel selectByNo(int id) throws Exception;
}
