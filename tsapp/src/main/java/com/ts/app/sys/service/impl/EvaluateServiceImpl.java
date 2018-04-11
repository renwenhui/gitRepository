package com.ts.app.sys.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ts.app.sys.dao.EvaluateMapper;
import com.ts.app.sys.domain.Evaluate;
import com.ts.app.sys.service.EvaluateService;

@Service
public class EvaluateServiceImpl implements EvaluateService {

	@Autowired
	private EvaluateMapper evaluateMapper;
	
	@Override
	public int deleteByPrimaryKey(Integer evaluateid) {
		return evaluateMapper.deleteByPrimaryKey(evaluateid);
	}


	@Override
	public int insertSelective(Evaluate record) {
		return evaluateMapper.insertSelective(record);
	}

	@Override
	public int insert(Evaluate record) {
		return evaluateMapper.insert(record);
	}


	@Override
	public Evaluate selectByPrimaryKey(Integer evaluateid) {
		return evaluateMapper.selectByPrimaryKey(evaluateid);
	}

	@Override	
	public int updateByPrimaryKeySelective(Evaluate record) {
		return evaluateMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Evaluate record) {
		return evaluateMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<Evaluate> queryListByArticeId(Map<String, Object> filterMap) {
		return evaluateMapper.queryListByArticeId(filterMap);
	}
	
	@Override
	public List queryListByArticeId2(Map<String, Object> filterMap) {
		return evaluateMapper.queryListByArticeId2(filterMap);
	}


	@Override
	public Integer getMyUnRead(Map<String, Object> filterMap) {
		return evaluateMapper.getMyUnRead(filterMap);
	}

	@Override
	public Integer getMyUnReadReply(Map<String, Object> filterMap) {
		return evaluateMapper.getMyUnReadReply(filterMap);
	}
	
}
