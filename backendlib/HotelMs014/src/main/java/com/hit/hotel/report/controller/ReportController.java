package com.hit.hotel.report.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hit.hotel.report.model.ReportModel;
import com.hit.hotel.report.service.IReportService;
import com.hit.hotel.restresult.Result;

//财务报表 Controller类
@RestController
@RequestMapping(value="/report")
@CrossOrigin(origins = {"*", "null"})
public class ReportController{
	@Autowired
	private IReportService reportService=null;
	
	@PostMapping(value="/add")
	public Result<String> add(@RequestBody ReportModel rm) throws Exception{
		reportService.add(rm);
		Result<String> result=new Result<String>();
		result.setStatus("OK");
		result.setMessage("增加财务报表成功!");
		return result;
		
	}
	@PostMapping(value="/modify")
	public Result<String> modify(@RequestBody ReportModel rm) throws Exception{
		reportService.modify(rm);
		Result<String> result=new Result<String>();
		result.setStatus("OK");
		result.setMessage("修改财务报表成功!");
		return result;
	}
	@PostMapping(value="/delete")
	public Result<String> delete(@RequestBody ReportModel rm) throws Exception{
		reportService.delete(rm);
		Result<String> result=new Result<String>();
		result.setStatus("OK");
		result.setMessage("删除财务报表成功!");
		return result;
	}
	//取得所有财务报表列表（不分页）
		@GetMapping(value="/list/all")
		public Result<ReportModel> getListByAll() throws Exception{
			Result<ReportModel> result=new Result<ReportModel>();
			result.setList(reportService.getListByAll());
			result.setStatus("OK");
			result.setMessage("取得全部财务报表列表成功!");
			return result;
		}
	//取得财务报表列表，分页模式
	@GetMapping(value="/list/all/page")
	public Result<ReportModel> getListByAllWitgPage(@RequestParam(required=false,defaultValue="10") int rows,@RequestParam(required=false,defaultValue="1") int page) throws Exception{
		Result<ReportModel> result=new Result<ReportModel>();
		result.setCount(reportService.getCountByAll());
		result.setPageCount(reportService.getPageCountByAll(rows));
		result.setRows(rows);
		result.setPage(page);
		result.setList(reportService.getListByAllWithPage(rows, page));
		
		result.setStatus("OK");
		result.setMessage("取得财务报表列表分页方式成功!");
		return result;
	}
	@GetMapping(value="/get")
	public Result<ReportModel> getByNo(@RequestParam(required=true) int id) throws Exception{
		Result<ReportModel> result=new Result<ReportModel>();
		result.setResult(reportService.getByNo(id));
		result.setStatus("OK");
		result.setMessage("取得指定财务报表对象成功!");
		return result;
	}
	

}
