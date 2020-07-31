package com.hit.hotel.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hit.hotel.restresult.Result;
import com.hit.hotel.admin.model.UserModel;
import com.hit.hotel.admin.service.IMemberService;

@RestController
@RequestMapping(value="/user")
@CrossOrigin(origins = {"*", "null"})
public class MemberController {
	
	@Autowired
	private IMemberService ords=null;
		
	@PostMapping(value="/add")
	public Result<String> add(@RequestBody UserModel om) throws Exception{
		ords.add(om);
		Result<String> result=new Result<String>();
		result.setStatus("OK");
		result.setMessage("增加用户成功!");
		return result;
		
	}
	@PostMapping(value="/modify")
	public Result<String> modify(@RequestBody UserModel om) throws Exception{
		ords.modify(om);
		Result<String> result=new Result<String>();
		result.setStatus("OK");
		result.setMessage("修改用户成功!");
		return result;
	}
	@PostMapping(value="/delete")
	public Result<String> delete(@RequestBody UserModel om) throws Exception{
		ords.delete(om);
		Result<String> result=new Result<String>();
		result.setStatus("OK");
		result.setMessage("删除用户成功!");
		return result;
	}
	//取得所有用户列表（不分页）
	@GetMapping(value="/list/all")
	public Result<UserModel> getListByAll() throws Exception{
		Result<UserModel> result=new Result<UserModel>();
		result.setList(ords.getListByAll());
		result.setStatus("OK");
		result.setMessage("取得全部用户列表成功!");
		return result;
		
	}
	
	//取得用户列表，分页模式
	@GetMapping(value="/list/all/page")
	public Result<UserModel> getListByAllWitgPage(@RequestParam(required=false,defaultValue="10") int rows,@RequestParam(required=false,defaultValue="1") int page) throws Exception{
		Result<UserModel> result=new Result<UserModel>();
		result.setCount(ords.getCountByAll());
		result.setPageCount(ords.getPageCountByAll(rows));
		result.setRows(rows);
		result.setPage(page);
		result.setList(ords.getListByAllWithPage(rows, page));
		
		result.setStatus("OK");
		result.setMessage("取得用户列表分页方式成功!");
		return result;
	}
	@GetMapping(value="/get")
	public Result<UserModel> getByNo(@RequestParam(required=true) int no) throws Exception{
		Result<UserModel> result=new Result<UserModel>();
		result.setResult(ords.getByNo(no));
		
		result.setStatus("OK");
		result.setMessage("取得指定用户对象成功!");
		return result;
	}
	

}
