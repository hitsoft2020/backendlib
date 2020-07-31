package com.hit.hotel.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hit.hotel.admin.mapper.IMemberMapper;
import com.hit.hotel.admin.model.UserModel;
import com.hit.hotel.admin.service.IMemberService;

@Service
@Transactional // 环绕事务Advice的切入点
public class MemberServiceImpl implements IMemberService {
	@Autowired
	private IMemberMapper MemberMapper = null;

	@Override
	public String add(UserModel um) throws Exception {
		MemberMapper.insert(um);
		return um.getId();
	}

	@Override
	public void modify(UserModel um) throws Exception {
		MemberMapper.update(um);
	}

	@Override
	public void delete(UserModel um) throws Exception {
		MemberMapper.delete(um);
	}

	@Override
	public List<UserModel> getListByAll() throws Exception {

		return MemberMapper.selectByAll();
	}

	@Override
	public List<UserModel> getListByAllWithPage(int rows, int page) throws Exception {

		return MemberMapper.selectByAllWithPage(rows * (page - 1), rows);
	}

	@Override
	public int getCountByAll() throws Exception {

		return MemberMapper.selectCountByAll();
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
	public UserModel getByNo(int id) throws Exception {

		return MemberMapper.selectByNo(id);
	}

}
