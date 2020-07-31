package com.hit.hotel.order.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hit.hotel.order.mapper.IOrderMapper;
import com.hit.hotel.order.model.OrderModel;
import com.hit.hotel.order.service.IOrderService;

@Service
@Transactional // 环绕事务Advice的切入点
public class OrderServiceImpl implements IOrderService {
	@Autowired
	private IOrderMapper OrderMapper = null;

	@Override
	public int add(OrderModel om) throws Exception {
		OrderMapper.insert(om);
		return om.getNo();
	}

	@Override
	public void modify(OrderModel om) throws Exception {
		OrderMapper.update(om);
	}

	@Override
	public void delete(OrderModel om) throws Exception {
		OrderMapper.delete(om);
	}

	@Override
	public List<OrderModel> getListByAll() throws Exception {

		return OrderMapper.selectByAll();
	}

	@Override
	public List<OrderModel> getListByAllWithPage(int rows, int page) throws Exception {

		return OrderMapper.selectByAllWithPage(rows * (page - 1), rows);
	}

	@Override
	public int getCountByAll() throws Exception {

		return OrderMapper.selectCountByAll();
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
	public OrderModel getByNo(int no) throws Exception {

		return OrderMapper.selectByNo(no);
	}

}
