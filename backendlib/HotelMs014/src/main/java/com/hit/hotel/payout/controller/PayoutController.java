package com.hit.hotel.payout.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hit.hotel.payout.model.PayoutModel;
import com.hit.hotel.payout.service.IPayoutService;
import com.hit.hotel.restresult.Result;

@RestController
@RequestMapping(value = "/payout")
@CrossOrigin(origins = {"*", "null"})
public class PayoutController {

	@Autowired
	private IPayoutService ds = null;

	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody PayoutModel pm) throws Exception {
		ds.add(pm);
		Result<String> result = new Result<String>();
		result.setStatus("OK");
		result.setMessage("增加记录成功!");
		return result;

	}

	@PostMapping(value = "/modify")
	public Result<String> modify(@RequestBody PayoutModel pm) throws Exception {
		ds.modify(pm);
		Result<String> result = new Result<String>();
		result.setStatus("OK");
		result.setMessage("修改记录成功!");
		return result;
	}

	@PostMapping(value = "/delete")
	public Result<String> delete(@RequestBody PayoutModel pm) throws Exception {
		ds.delete(pm);
		Result<String> result = new Result<String>();
		result.setStatus("OK");
		result.setMessage("删除记录成功!");
		return result;
	}
	//取得所有记录列表（不分页）
	@GetMapping(value="/list/all")
	public Result<PayoutModel> getListByAll() throws Exception{
		Result<PayoutModel> result=new Result<PayoutModel>();
		result.setList(ds.getListByAll());
		result.setStatus("OK");
		result.setMessage("取得全部客户列表成功!");
		return result;
		
	}
	//取得列表，分页模式
	@GetMapping(value = "/list/all/page")
	public Result<PayoutModel> getListByAllWitgPage(@RequestParam(required = false, defaultValue = "10") int rows,
			@RequestParam(required = false, defaultValue = "1") int page) throws Exception {
		Result<PayoutModel> result = new Result<PayoutModel>();
		result.setCount(ds.getCountByAll());
		result.setPageCount(ds.getPageCountByAll(rows));
		result.setRows(rows);
		result.setPage(page);
		result.setList(ds.getListByAllWithPage(rows, page));

		result.setStatus("OK");
		result.setMessage("取得记录列表分页方式成功!");
		return result;
	}

	@GetMapping(value = "/get")
	public Result<PayoutModel> getByNo(@RequestParam(required = true) int no) throws Exception {
		Result<PayoutModel> result = new Result<PayoutModel>();
		result.setResult(ds.getByNo(no));

		result.setStatus("OK");
		result.setMessage("取得指定记录成功!");
		return result;
	}

}
