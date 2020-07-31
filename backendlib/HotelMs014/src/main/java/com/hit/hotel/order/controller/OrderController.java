package com.hit.hotel.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hit.hotel.restresult.Result;
import com.hit.hotel.order.model.OrderModel;
import com.hit.hotel.order.service.IOrderService;

@RestController
@RequestMapping(value="/order")
@CrossOrigin(origins = {"*", "null"})
public class OrderController {
	
	@Autowired
	private IOrderService ords=null;
		
	@PostMapping(value="/add")
	public Result<String> add(@RequestBody OrderModel om) throws Exception{
		ords.add(om);
		Result<String> result=new Result<String>();
		result.setStatus("OK");
		result.setMessage("增加订单成功!");
		return result;
		
	}
	@PostMapping(value="/modify")
	public Result<String> modify(@RequestBody OrderModel om) throws Exception{
		ords.modify(om);
		Result<String> result=new Result<String>();
		result.setStatus("OK");
		result.setMessage("修改订单成功!");
		return result;
	}
	@PostMapping(value="/delete")
	public Result<String> delete(@RequestBody OrderModel om) throws Exception{
		ords.delete(om);
		Result<String> result=new Result<String>();
		result.setStatus("OK");
		result.setMessage("删除订单成功!");
		return result;
	}
	//取得所有订单列表（不分页）
	@GetMapping(value="/list/all")
	public Result<OrderModel> getListByAll() throws Exception{
		Result<OrderModel> result=new Result<OrderModel>();
		result.setList(ords.getListByAll());
		result.setStatus("OK");
		result.setMessage("取得全部订单列表成功!");
		return result;
		
	}
	
	//取得订单列表，分页模式
	@GetMapping(value="/list/all/page")
	public Result<OrderModel> getListByAllWitgPage(@RequestParam(required=false,defaultValue="10") int rows,@RequestParam(required=false,defaultValue="1") int page) throws Exception{
		Result<OrderModel> result=new Result<OrderModel>();
		result.setCount(ords.getCountByAll());
		result.setPageCount(ords.getPageCountByAll(rows));
		result.setRows(rows);
		result.setPage(page);
		result.setList(ords.getListByAllWithPage(rows, page));
		
		result.setStatus("OK");
		result.setMessage("取得订单列表分页方式成功!");
		return result;
	}
	@GetMapping(value="/get")
	public Result<OrderModel> getByNo(@RequestParam(required=true) int no) throws Exception{
		Result<OrderModel> result=new Result<OrderModel>();
		result.setResult(ords.getByNo(no));
		
		result.setStatus("OK");
		result.setMessage("取得指定订单对象成功!");
		return result;
	}
	

}
