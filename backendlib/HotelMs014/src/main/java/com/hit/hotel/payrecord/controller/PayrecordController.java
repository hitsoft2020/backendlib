package com.hit.hotel.payrecord.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hit.hotel.payrecord.model.PayrecordModel;
import com.hit.hotel.payrecord.service.IPayrecordService;
import com.hit.hotel.restresult.Result;

@RestController
@RequestMapping(value = "/payrecord")
@CrossOrigin(origins = {"*", "null"})
public class PayrecordController {

	@Autowired
	private IPayrecordService ds = null;

	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody PayrecordModel dm) throws Exception {
		ds.add(dm);
		Result<String> result = new Result<String>();
		result.setStatus("OK");
		result.setMessage("增加支付记录成功!");
		return result;

	}

	@PostMapping(value = "/modify")
	public Result<String> modify(@RequestBody PayrecordModel dm) throws Exception {
		ds.modify(dm);
		Result<String> result = new Result<String>();
		result.setStatus("OK");
		result.setMessage("修改支付记录成功!");
		return result;
	}

	@PostMapping(value = "/delete")
	public Result<String> delete(@RequestBody PayrecordModel dm) throws Exception {
		ds.delete(dm);
		Result<String> result = new Result<String>();
		result.setStatus("OK");
		result.setMessage("删除支付记录成功!");
		return result;
	}
	
	//取得所有支付列表（不分页）
	@GetMapping(value="/list/all")
	public Result<PayrecordModel> getListByAll() throws Exception{
		Result<PayrecordModel> result=new Result<PayrecordModel>();
		result.setList(ds.getListByAll());
		result.setStatus("OK");
		result.setMessage("取得全部房间列表成功!");
		return result;
		
	}
	// 取得支付记录列表，分页模式
	@GetMapping(value = "/list/all/page")
	public Result<PayrecordModel> getListByAllWitgPage(@RequestParam(required = false, defaultValue = "10") int rows,
			@RequestParam(required = false, defaultValue = "1") int page) throws Exception {
		Result<PayrecordModel> result = new Result<PayrecordModel>();
		result.setCount(ds.getCountByAll());
		result.setPageCount(ds.getPageCountByAll(rows));
		result.setRows(rows);
		result.setPage(page);
		result.setList(ds.getListByAllWithPage(rows, page));

		result.setStatus("OK");
		result.setMessage("取得支付记录列表分页方式成功!");
		return result;
	}

	@GetMapping(value = "/get")
	public Result<PayrecordModel> getByNo(@RequestParam(required = true) int no) throws Exception {
		Result<PayrecordModel> result = new Result<PayrecordModel>();
		result.setResult(ds.getByNo(no));

		result.setStatus("OK");
		result.setMessage("取得指定支付记录对象成功!");
		return result;
	}

}
