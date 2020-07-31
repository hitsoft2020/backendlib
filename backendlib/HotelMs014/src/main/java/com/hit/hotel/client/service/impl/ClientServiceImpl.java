package com.hit.hotel.client.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hit.hotel.client.mapper.IClientMapper;
import com.hit.hotel.client.model.ClientModel;
import com.hit.hotel.client.service.IClientService;

@Service
@Transactional // 环绕事务Advice的切入点
public class ClientServiceImpl implements IClientService {
	@Autowired
	private IClientMapper ClientMapper = null;

	@Override
	public int add(ClientModel cm) throws Exception {
		ClientMapper.insert(cm);
		return cm.getNo();
	}

	@Override
	public void modify(ClientModel cm) throws Exception {
		ClientMapper.update(cm);
	}

	@Override
	public void delete(ClientModel cm) throws Exception {
		ClientMapper.delete(cm);
	}

	@Override
	public List<ClientModel> getListByAll() throws Exception {

		return ClientMapper.selectByAll();
	}

	@Override
	public List<ClientModel> getListByAllWithPage(int rows, int page) throws Exception {

		return ClientMapper.selectByAllWithPage(rows * (page - 1), rows);
	}

	@Override
	public int getCountByAll() throws Exception {

		return ClientMapper.selectCountByAll();
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
	public ClientModel getByNo(int no) throws Exception {

		return ClientMapper.selectByNo(no);
	}

}