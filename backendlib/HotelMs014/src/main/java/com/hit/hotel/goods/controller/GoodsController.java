package com.hit.hotel.goods.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hit.hotel.goods.model.GoodsModel;
import com.hit.hotel.goods.service.IGoodsService;
import com.hit.hotel.restresult.Result;

//商品Controller类
@RestController
@RequestMapping(value="/goods")
@CrossOrigin(origins = {"*", "null"})
public class GoodsController {
	@Autowired
	private IGoodsService goodsService=null;
	
	@PostMapping(value="/add")
	public Result<String> add(@RequestBody GoodsModel gm) throws Exception{
		goodsService.add(gm);
		Result<String> result=new Result<String>();
		result.setStatus("OK");
		result.setMessage("增加商品成功!");
		return result;
		
	}
	@PostMapping(value="/modify")
	public Result<String> modify(@RequestBody GoodsModel gm) throws Exception{
		goodsService.modify(gm);
		Result<String> result=new Result<String>();
		result.setStatus("OK");
		result.setMessage("修改商品成功!");
		return result;
	}
	@PostMapping(value="/delete")
	public Result<String> delete(@RequestBody GoodsModel gm) throws Exception{
		goodsService.delete(gm);
		Result<String> result=new Result<String>();
		result.setStatus("OK");
		result.setMessage("删除商品成功!");
		return result;
	}
	
	//取得所有商品列表（不分页）
	@GetMapping(value="/list/all")
	public Result<GoodsModel> getListByAll() throws Exception{
		Result<GoodsModel> result=new Result<GoodsModel>();
		result.setList(goodsService.getListByAll());
		result.setStatus("OK");
		result.setMessage("取得全部商品列表成功!");
		return result;
	}
	//取得商品列表，分页模式
	@GetMapping(value="/list/all/page")
	public Result<GoodsModel> getListByAllWitgPage(@RequestParam(required=false,defaultValue="10") int rows,@RequestParam(required=false,defaultValue="1") int page) throws Exception{
		Result<GoodsModel> result=new Result<GoodsModel>();
		result.setCount(goodsService.getCountByAll());
		result.setPageCount(goodsService.getPageCountByAll(rows));
		result.setRows(rows);
		result.setPage(page);
		result.setList(goodsService.getListByAllWithPage(rows, page));
		
		result.setStatus("OK");
		result.setMessage("取得商品列表成功!");
		return result;
	}
	
	@GetMapping(value="/get")
	public Result<GoodsModel> getByNo(@RequestParam(required=true) int id) throws Exception{
		Result<GoodsModel> result=new Result<GoodsModel>();
		result.setResult(goodsService.getByNo(id));
		
		result.setStatus("OK");
		result.setMessage("取得指定商品对象成功!");
		return result;
	}

}
