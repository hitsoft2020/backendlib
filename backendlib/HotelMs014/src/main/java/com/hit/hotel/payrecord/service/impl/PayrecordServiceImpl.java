package com.hit.hotel.payrecord.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hit.hotel.payrecord.mapper.IPayrecordMapper;
import com.hit.hotel.payrecord.model.PayrecordModel;
import com.hit.hotel.payrecord.service.IPayrecordService;

@Service
@Transactional // 环绕事务Advice的切入点
public class PayrecordServiceImpl implements IPayrecordService {
	@Autowired
	private IPayrecordMapper payrecordMapper = null;

	@Override
	public int add(PayrecordModel dm) throws Exception {
		payrecordMapper.insert(dm);
		return dm.getNo();
	}

	@Override
	public void modify(PayrecordModel dm) throws Exception {
		payrecordMapper.update(dm);
	}

	@Override
	public void delete(PayrecordModel dm) throws Exception {
		payrecordMapper.delete(dm);
	}

	@Override
	public List<PayrecordModel> getListByAll() throws Exception {

		return payrecordMapper.selectByAll();
	}

	@Override
	public List<PayrecordModel> getListByAllWithPage(int rows, int page) throws Exception {

		return payrecordMapper.selectByAllWithPage(rows * (page - 1), rows);
	}

	@Override
	public int getCountByAll() throws Exception {

		return payrecordMapper.selectCountByAll();
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
	public PayrecordModel getByNo(int no) throws Exception {

		return payrecordMapper.selectByNo(no);
	}

}
