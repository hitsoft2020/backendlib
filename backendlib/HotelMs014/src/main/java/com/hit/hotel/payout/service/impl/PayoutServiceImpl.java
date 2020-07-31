package com.hit.hotel.payout.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hit.hotel.payout.mapper.IPayoutMapper;
import com.hit.hotel.payout.model.PayoutModel;
import com.hit.hotel.payout.service.IPayoutService;

@Service
@Transactional // 环绕事务Advice的切入点
public class PayoutServiceImpl implements IPayoutService {

	@Autowired
	private IPayoutMapper payoutMapper = null;
	
	@Override
	public int add(PayoutModel pm) throws Exception {
		payoutMapper.insert(pm);
		return pm.getNo();
	}

	@Override
	public void modify(PayoutModel pm) throws Exception {
		payoutMapper.update(pm);

	}

	@Override
	public void delete(PayoutModel pm) throws Exception {
		payoutMapper.delete(pm);

	}

	@Override
	public List<PayoutModel> getListByAll() throws Exception {
		return payoutMapper.selectByAll();
	}

	@Override
	public List<PayoutModel> getListByAllWithPage(int rows, int page) throws Exception {
		return payoutMapper.selectByAllWithPage(rows*(page-1), rows);
	}

	@Override
	public int getCountByAll() throws Exception {
		return payoutMapper.selectCountByAll();
	}

	@Override
	public int getPageCountByAll(int rows) throws Exception {
		int count=this.getCountByAll();
		int pageCount=0;
		if(count%rows==0) {
			pageCount=count/rows;
		}
		else {
			pageCount=count/rows+1;
		}
		
		return pageCount;
	}

	@Override
	public PayoutModel getByNo(int no) throws Exception {
		return payoutMapper.selectByNo(no);
	}

}
