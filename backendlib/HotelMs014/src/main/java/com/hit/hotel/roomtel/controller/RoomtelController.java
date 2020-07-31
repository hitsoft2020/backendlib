package com.hit.hotel.roomtel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hit.hotel.restresult.Result;
import com.hit.hotel.room.model.RoomModel;
import com.hit.hotel.roomtel.model.RoomtelModel;
import com.hit.hotel.roomtel.service.IRoomtelService;

@RestController
@RequestMapping(value = "/roomtel")
@CrossOrigin(origins = {"*", "null"})
public class RoomtelController {

	@Autowired
	private IRoomtelService ds = null;

	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody RoomtelModel dm) throws Exception {
		ds.add(dm);
		Result<String> result = new Result<String>();
		result.setStatus("OK");
		result.setMessage("增加房间成功!");
		return result;

	}

	@PostMapping(value = "/modify")
	public Result<String> modify(@RequestBody RoomtelModel dm) throws Exception {
		ds.modify(dm);
		Result<String> result = new Result<String>();
		result.setStatus("OK");
		result.setMessage("修改房间成功!");
		return result;
	}

	@PostMapping(value = "/delete")
	public Result<String> delete(@RequestBody RoomtelModel dm) throws Exception {
		ds.delete(dm);
		Result<String> result = new Result<String>();
		result.setStatus("OK");
		result.setMessage("删除房间成功!");
		return result;
	}
	
	//取得所有房间列表（不分页）
	@GetMapping(value="/list/all")
	public Result<RoomtelModel> getListByAll() throws Exception{
		Result<RoomtelModel> result=new Result<RoomtelModel>();
		result.setList(ds.getListByAll());
		result.setStatus("OK");
		result.setMessage("取得全部房间列表成功!");
		return result;
		
	}

	// 取得房间列表，分页模式
	@GetMapping(value = "/list/all/page")
	public Result<RoomtelModel> getListByAllWitgPage(@RequestParam(required = false, defaultValue = "10") int rows,
			@RequestParam(required = false, defaultValue = "1") int page) throws Exception {
		Result<RoomtelModel> result = new Result<RoomtelModel>();
		result.setCount(ds.getCountByAll());
		result.setPageCount(ds.getPageCountByAll(rows));
		result.setRows(rows);
		result.setPage(page);
		result.setList(ds.getListByAllWithPage(rows, page));

		result.setStatus("OK");
		result.setMessage("取得房间列表分页方式成功!");
		return result;
	}

	@GetMapping(value = "/get")
	public Result<RoomtelModel> getByNo(@RequestParam(required = true) int no) throws Exception {
		Result<RoomtelModel> result = new Result<RoomtelModel>();
		result.setResult(ds.getByNo(no));

		result.setStatus("OK");
		result.setMessage("取得指定房间对象成功!");
		return result;
	}

}
