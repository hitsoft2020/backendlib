package com.hit.hotel.vip.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hit.hotel.restresult.Result;
import com.hit.hotel.vip.model.VipModel;
import com.hit.hotel.vip.service.IVipService;

@RestController
@RequestMapping(value="/vip")
@CrossOrigin(origins = {"*", "null"})
public class VipController {
	
	@Autowired
	private IVipService vs=null;
		
	@PostMapping(value="/add")
	public Result<String> add(@RequestBody VipModel dm) throws Exception{
		vs.add(dm);
		Result<String> result=new Result<String>();
		result.setStatus("OK");
		result.setMessage("增加会员成功!");
		return result;
		
	}
	@PostMapping(value="/modify")
	public Result<String> modify(@RequestBody VipModel dm) throws Exception{
		vs.modify(dm);
		Result<String> result=new Result<String>();
		result.setStatus("OK");
		result.setMessage("修改会员成功!");
		return result;
	}
	@PostMapping(value="/delete")
	public Result<String> delete(@RequestBody VipModel dm) throws Exception{
		vs.delete(dm);
		Result<String> result=new Result<String>();
		result.setStatus("OK");
		result.setMessage("删除会员成功!");
		return result;
	}
	//取得所有会员列表（不分页）
	@GetMapping(value="/list/all")
	public Result<VipModel> getListByAll() throws Exception{
		Result<VipModel> result=new Result<VipModel>();
		result.setList(vs.getListByAll());
		result.setStatus("OK");
		result.setMessage("取得全部会员列表成功!");
		return result;
		
	}
	
	//取得会员列表，分页模式
	@GetMapping(value="/list/all/page")
	public Result<VipModel> getListByAllWitgPage(@RequestParam(required=false,defaultValue="10") int rows,@RequestParam(required=false,defaultValue="1") int page) throws Exception{
		Result<VipModel> result=new Result<VipModel>();
		result.setCount(vs.getCountByAll());
		result.setPageCount(vs.getPageCountByAll(rows));
		result.setRows(rows);
		result.setPage(page);
		result.setList(vs.getListByAllWithPage(rows, page));
		
		result.setStatus("OK");
		result.setMessage("取得会员列表分页方式成功!");
		return result;
	}
	@GetMapping(value="/get")
	public Result<VipModel> getByNo(@RequestParam(required=true) int no) throws Exception{
		Result<VipModel> result=new Result<VipModel>();
		result.setResult(vs.getByNo(no));
		
		result.setStatus("OK");
		result.setMessage("取得指定会员对象成功!");
		return result;
	}
	

}
