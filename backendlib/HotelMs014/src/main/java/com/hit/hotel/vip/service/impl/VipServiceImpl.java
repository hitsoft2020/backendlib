package com.hit.hotel.vip.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hit.hotel.vip.mapper.IVipMapper;
import com.hit.hotel.vip.model.VipModel;
import com.hit.hotel.vip.service.IVipService;

@Service
@Transactional // 环绕事务Advice的切入点
public class VipServiceImpl implements IVipService {
	@Autowired
	private IVipMapper VipMapper = null;

	@Override
	public int add(VipModel vm) throws Exception {
		VipMapper.insert(vm);
		return vm.getNo();
	}

	@Override
	public void modify(VipModel vm) throws Exception {
		VipMapper.update(vm);
	}

	@Override
	public void delete(VipModel vm) throws Exception {
		VipMapper.delete(vm);
	}

	@Override
	public List<VipModel> getListByAll() throws Exception {

		return VipMapper.selectByAll();
	}

	@Override
	public List<VipModel> getListByAllWithPage(int rows, int page) throws Exception {

		return VipMapper.selectByAllWithPage(rows * (page - 1), rows);
	}

	@Override
	public int getCountByAll() throws Exception {

		return VipMapper.selectCountByAll();
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
	public VipModel getByNo(int no) throws Exception {

		return VipMapper.selectByNo(no);
	}

}
