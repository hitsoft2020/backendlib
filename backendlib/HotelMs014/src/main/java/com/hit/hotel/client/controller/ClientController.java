/**
 * 
 */
package com.hit.hotel.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hit.hotel.client.model.ClientModel;
import com.hit.hotel.client.service.IClientService;
import com.hit.hotel.restresult.Result;


@RestController
@RequestMapping(value="/client")
@CrossOrigin(origins = {"*", "null"})
public class ClientController {
	
	@Autowired
	private IClientService ords=null;
		
	@PostMapping(value="/add")
	public Result<String> add(@RequestBody ClientModel cm) throws Exception{
		ords.add(cm);
		Result<String> result=new Result<String>();
		result.setStatus("OK");
		result.setMessage("增加客户成功!");
		return result;
		
	}
	@PostMapping(value="/modify")
	public Result<String> modify(@RequestBody ClientModel cm) throws Exception{
		ords.modify(cm);
		Result<String> result=new Result<String>();
		result.setStatus("OK");
		result.setMessage("修改客户成功!");
		return result;
	}
	@PostMapping(value="/delete")
	public Result<String> delete(@RequestBody ClientModel cm) throws Exception{
		ords.delete(cm);
		Result<String> result=new Result<String>();
		result.setStatus("OK");
		result.setMessage("删除客户订单成功!");
		return result;
	}
	//取得所有客户列表（不分页）
	@GetMapping(value="/list/all")
	public Result<ClientModel> getListByAll() throws Exception{
		Result<ClientModel> result=new Result<ClientModel>();
		result.setList(ords.getListByAll());
		result.setStatus("OK");
		result.setMessage("取得全部客户列表成功!");
		return result;
		
	}
	
	//取得客户列表，分页模式
	@GetMapping(value="/list/all/page")
	public Result<ClientModel> getListByAllWithPage(@RequestParam(required=false,defaultValue="10") int rows,@RequestParam(required=false,defaultValue="1") int page) throws Exception{
		Result<ClientModel> result=new Result<ClientModel>();
		result.setCount(ords.getCountByAll());
		result.setPageCount(ords.getPageCountByAll(rows));
		result.setRows(rows);
		result.setPage(page);
		result.setList(ords.getListByAllWithPage(rows, page));
		
		result.setStatus("OK");
		result.setMessage("取得客户列表分页方式成功!");
		return result;
	}
	@GetMapping(value="/get")
	public Result<ClientModel> getByNo(@RequestParam(required=true) int no) throws Exception{
		Result<ClientModel> result=new Result<ClientModel>();
		result.setResult(ords.getByNo(no));
		
		result.setStatus("OK");
		result.setMessage("取得指定客户对象成功!");
		return result;
	}

}
