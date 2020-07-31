package com.hit.hotel.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hit.hotel.employee.model.EmployeeModel;
import com.hit.hotel.employee.service.IEmployeeService;
import com.hit.hotel.restresult.Result;


@RestController
@RequestMapping(value = "/employee")
@CrossOrigin(origins = {"*", "null"})
public class EmployeeController {
	@Autowired
	private IEmployeeService ds = null;

	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody EmployeeModel em) throws Exception {
		ds.add(em);
		Result<String> result = new Result<String>();
		result.setStatus("OK");
		result.setMessage("增加员工成功!");
		return result;

	}

	@PostMapping(value = "/modify")
	public Result<String> modify(@RequestBody EmployeeModel em) throws Exception {
		ds.modify(em);
		Result<String> result = new Result<String>();
		result.setStatus("OK");
		result.setMessage("修改员工成功!");
		return result;
	}

	@PostMapping(value = "/delete")
	public Result<String> delete(@RequestBody EmployeeModel em) throws Exception {
		ds.delete(em);
		Result<String> result = new Result<String>();
		result.setStatus("OK");
		result.setMessage("删除客户成功!");
		return result;
	}
	//取得所有员工列表（不分页）
	@GetMapping(value="/list/all")
	public Result<EmployeeModel> getListByAll() throws Exception{
		Result<EmployeeModel> result=new Result<EmployeeModel>();
		result.setList(ds.getListByAll());
		result.setStatus("OK");
		result.setMessage("取得全部员工列表成功!");
		return result;
		
	}

//取得列表，分页模式
	@GetMapping(value = "/list/all/page")
	public Result<EmployeeModel> getListByAllWitgPage(@RequestParam(required = false, defaultValue = "10") int rows,
			@RequestParam(required = false, defaultValue = "1") int page) throws Exception {
		Result<EmployeeModel> result = new Result<EmployeeModel>();
		result.setCount(ds.getCountByAll());
		result.setPageCount(ds.getPageCountByAll(rows));
		result.setRows(rows);
		result.setPage(page);
		result.setList(ds.getListByAllWithPage(rows, page));

		result.setStatus("OK");
		result.setMessage("取得员工客户列表分页方式成功!");
		return result;
	}

	@GetMapping(value = "/get")
	public Result<EmployeeModel> getByNo(@RequestParam(required = true) int no) throws Exception {
		Result<EmployeeModel> result = new Result<EmployeeModel>();
		result.setResult(ds.getByNo(no));
		result.setStatus("OK");
		result.setMessage("取得指定员工对象成功!");
		return result;
	}
	
}

