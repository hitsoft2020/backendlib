package com.hit.hotel.goods.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hit.hotel.goods.mapper.IGoodsMapper;
import com.hit.hotel.goods.model.GoodsModel;
import com.hit.hotel.goods.service.IGoodsService;

@Service
@Transactional  //环绕事务Advice的切入点
public class GoodsServiceImpl implements IGoodsService {
	@Autowired
	private IGoodsMapper goodsMapper=null;

	@Override
	public int add(GoodsModel gm) throws Exception {
		goodsMapper.insert(gm);
		return gm.getId();
	}

	@Override
	public void modify(GoodsModel gm) throws Exception {
		goodsMapper.update(gm);
	}

	@Override
	public void delete(GoodsModel gm) throws Exception {
		goodsMapper.delete(gm);

	}

	@Override
	public List<GoodsModel> getListByAll() throws Exception {
		
		return goodsMapper.selectByAll();
	}

	@Override
	public List<GoodsModel> getListByAllWithPage(int rows, int page) throws Exception {
		return goodsMapper.selectByAllWithPage(rows*(page-1), rows);
	}

	@Override
	public int getCountByAll() throws Exception {
		
		return goodsMapper.selectCountByAll();
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
	public GoodsModel getByNo(int id) throws Exception {
		
		return goodsMapper.selectByNo(id);
	}

}
