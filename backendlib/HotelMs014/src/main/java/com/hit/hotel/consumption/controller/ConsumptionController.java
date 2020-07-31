package com.hit.hotel.consumption.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hit.hotel.consumption.model.ConsumptionModel;
import com.hit.hotel.consumption.service.IConsumptionService;
import com.hit.hotel.restresult.Result;

//消费记录Controller类
@RestController
@RequestMapping(value="/consumption")
@CrossOrigin(origins = {"*", "null"})
public class ConsumptionController {
	@Autowired
	private IConsumptionService consumptionService=null;
	
	@PostMapping(value="/add")
	public Result<String> add(@RequestBody ConsumptionModel cm) throws Exception{
		consumptionService.add(cm);
		Result<String> result=new Result<String>();
		result.setStatus("OK");
		result.setMessage("增加消费记录成功!");
		return result;
		
	}
	@PostMapping(value="/modify")
	public Result<String> modify(@RequestBody ConsumptionModel cm) throws Exception{
		consumptionService.modify(cm);
		Result<String> result=new Result<String>();
		result.setStatus("OK");
		result.setMessage("修改消费记录成功!");
		return result;
	}
	@PostMapping(value="/delete")
	public Result<String> delete(@RequestBody ConsumptionModel cm) throws Exception{
		consumptionService.delete(cm);
		Result<String> result=new Result<String>();
		result.setStatus("OK");
		result.setMessage("删除消费记录成功!");
		return result;
	}
	
	//取得所有商品消费列表（不分页）
	@GetMapping(value="/list/all")
	public Result<ConsumptionModel> getListByAll() throws Exception{
		Result<ConsumptionModel> result=new Result<ConsumptionModel>();
		result.setList(consumptionService.getListByAll());
		result.setStatus("OK");
		result.setMessage("取得全部消费记录列表成功!");
		return result;
	}
	
	//取得商品列表，分页模式
	@GetMapping(value="/list/all/page")
	public Result<ConsumptionModel> getListByAllWitgPage(@RequestParam(required=false,defaultValue="10") int rows,@RequestParam(required=false,defaultValue="1") int page) throws Exception{
		Result<ConsumptionModel> result=new Result<ConsumptionModel>();
		result.setCount(consumptionService.getCountByAll());
		result.setPageCount(consumptionService.getPageCountByAll(rows));
		result.setRows(rows);
		result.setPage(page);
		result.setList(consumptionService.getListByAllWithPage(rows, page));
		
		result.setStatus("OK");
		result.setMessage("取得消费记录列表成功!");
		return result;
	}
	
	@GetMapping(value="/get")
	public Result<ConsumptionModel> getByNo(@RequestParam(required=true) int id) throws Exception{
		Result<ConsumptionModel> result=new Result<ConsumptionModel>();
		result.setResult(consumptionService.getByNo(id));
		
		result.setStatus("OK");
		result.setMessage("取得指定消费记录对象成功!");
		return result;
	}

}

