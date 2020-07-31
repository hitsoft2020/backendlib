package com.hit.hotel.consumption.service.impl;

import java.util.List;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hit.hotel.consumption.mapper.IConsumptionMapper;
import com.hit.hotel.consumption.model.ConsumptionModel;
import com.hit.hotel.consumption.service.IConsumptionService;

@Service
@Transactional  //环绕事务Advice的切入点
public class ConsumptionServiceImpl implements IConsumptionService {
	@Autowired
	private IConsumptionMapper consumptionMapper=null;

	@Override
	public int add(ConsumptionModel cm) throws Exception {
		consumptionMapper.insert(cm);
		return cm.getId();
	}
	
	@Override
	public void modify(ConsumptionModel cm) throws Exception {
		consumptionMapper.update(cm);
	}

	@Override
	public void delete(ConsumptionModel cm) throws Exception {
		consumptionMapper.delete(cm);

	}

	@Override
	public List<ConsumptionModel> getListByAll() throws Exception {
		return consumptionMapper.selectByAll();
	}

	@Override
	public List<ConsumptionModel> getListByAllWithPage(int rows, int page) throws Exception {
		return consumptionMapper.selectByAllWithPage(rows*(page-1), rows);
	}

	@Override
	public int getCountByAll() throws Exception {
		return consumptionMapper.selectCountByAll();
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
	public ConsumptionModel getByNo(int id) throws Exception {
		return consumptionMapper.selectByNo(id);
	}
}

