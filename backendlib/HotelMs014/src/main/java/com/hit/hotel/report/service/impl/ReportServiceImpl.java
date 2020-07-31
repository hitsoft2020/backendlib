package com.hit.hotel.report.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hit.hotel.report.mapper.IReportMapper;
import com.hit.hotel.report.model.ReportModel;
import com.hit.hotel.report.service.IReportService;

@Service
@Transactional  //环绕事务Advice的切入点
public class ReportServiceImpl implements IReportService {
	@Autowired
	private IReportMapper reportMapper=null;

	@Override
	public int add(ReportModel rm) throws Exception {
		reportMapper.insert(rm);
		return rm.getId();
	}
	
	@Override
	public void modify(ReportModel rm) throws Exception {
		reportMapper.update(rm);
	}

	@Override
	public void delete(ReportModel rm) throws Exception {
		reportMapper.delete(rm);
	}

	@Override
	public List<ReportModel> getListByAll() throws Exception {
		return reportMapper.selectByAll();
	}

	@Override
	public List<ReportModel> getListByAllWithPage(int rows, int page) throws Exception {
		return reportMapper.selectByAllWithPage(rows*(page-1), rows);
	}

	@Override
	public int getCountByAll() throws Exception {
		return reportMapper.selectCountByAll();
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
	public ReportModel getByNo(int id) throws Exception {
		return reportMapper.selectByNo(id);
	}
}
