package com.hit.hotel.employee.service;

import java.util.List;

import com.hit.hotel.employee.model.EmployeeModel;

public interface IEmployeeService {

	//增加员工
	public int add(EmployeeModel em) throws Exception;

	// 修改员工
	public void modify(EmployeeModel em) throws Exception;

	// 删除员工
	public void delete(EmployeeModel em) throws Exception;

	// 获取全部员工
	public List<EmployeeModel> getListByAll() throws Exception;

	// 取得所有员工列表,分页模式
	public List<EmployeeModel> getListByAllWithPage(int rows, int page) throws Exception;

	// 取得员工的个数
	public int getCountByAll() throws Exception;

	// 获取员工的显示页数
	public int getPageCountByAll(int rows) throws Exception;

	// 根据员工的no（PK）取得指定的员工对象
	public EmployeeModel getByNo(int no) throws Exception;
}
