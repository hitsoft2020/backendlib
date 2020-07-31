package com.hit.hotel.roomtel.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hit.hotel.roomtel.mapper.IRoomtelMapper;
import com.hit.hotel.roomtel.model.RoomtelModel;
import com.hit.hotel.roomtel.service.IRoomtelService;

@Service
@Transactional // 环绕事务Advice的切入点
public class RoomtelServiceImpl implements IRoomtelService {
	@Autowired
	private IRoomtelMapper roomtelMapper = null;

	@Override
	public int add(RoomtelModel dm) throws Exception {
		roomtelMapper.insert(dm);
		return dm.getNo();
	}

	@Override
	public void modify(RoomtelModel dm) throws Exception {
		roomtelMapper.update(dm);
	}

	@Override
	public void delete(RoomtelModel dm) throws Exception {
		roomtelMapper.delete(dm);
	}

	@Override
	public List<RoomtelModel> getListByAll() throws Exception {

		return roomtelMapper.selectByAll();
	}

	@Override
	public List<RoomtelModel> getListByAllWithPage(int rows, int page) throws Exception {

		return roomtelMapper.selectByAllWithPage(rows * (page - 1), rows);
	}

	@Override
	public int getCountByAll() throws Exception {

		return roomtelMapper.selectCountByAll();
	}

	@Override
	public int getPageCountByAll(int rows) throws Exception {

		int count = this.getCountByAll();
		int pageCount = 0;
		if (count % rows == 0) {
			pageCount = count / rows;
		} else {
			pageCount = count / rows + 1;
		}

		return pageCount;
	}

	@Override
	public RoomtelModel getByNo(int no) throws Exception {

		return roomtelMapper.selectByNo(no);
	}

}
