package com.hit.hotel.report.service;

import java.util.List;

import com.hit.hotel.report.model.ReportModel;

//财务报表的业务接口
public interface IReportService {
	
	//增加财务报表
	public int add(ReportModel rm) throws Exception;
	// 修改财务报表
	public void modify(ReportModel rm) throws Exception;
	// 删除财务报表
	public void delete(ReportModel rm) throws Exception;
	//取得财务报表列表
	public List<ReportModel> getListByAll() throws Exception;
	//取得财务报表列表,分页模式
	public List<ReportModel> getListByAllWithPage(int rows, int page) throws Exception;
	//取得财务报表的个数
	public int getCountByAll() throws Exception;
	//取得财务报表的显示页数
	public int getPageCountByAll(int rows) throws Exception;
	//根据财务报表的no（PK）取得指定对象
	public ReportModel getByNo(int id) throws Exception;
}
