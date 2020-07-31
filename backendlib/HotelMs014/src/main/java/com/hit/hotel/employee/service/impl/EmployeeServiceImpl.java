package com.hit.hotel.employee.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hit.hotel.employee.mapper.IEmployeeMapper;
import com.hit.hotel.employee.model.EmployeeModel;
import com.hit.hotel.employee.service.IEmployeeService;

@Service
@Transactional
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private IEmployeeMapper employeeMapper=null;
	
	@Override
	public int add(EmployeeModel em) throws Exception {
		employeeMapper.insert(em);
		return em.getNo();
	}

	@Override
	public void modify(EmployeeModel em) throws Exception {
		employeeMapper.update(em);
	}

	@Override
	public void delete(EmployeeModel em) throws Exception {
		employeeMapper.delete(em);
	}

	@Override
	public List<EmployeeModel> getListByAll() throws Exception {
		return employeeMapper.selectByAll();
	}

	@Override
	public List<EmployeeModel> getListByAllWithPage(int rows, int page) throws Exception {
		return employeeMapper.selectByAllWithPage(rows*(page-1), rows);
	}

	@Override
	public int getCountByAll() throws Exception {
		return employeeMapper.selectCountByAll();
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
	public EmployeeModel getByNo(int no) throws Exception {
		return employeeMapper.selectByNo(no);
	}

}
