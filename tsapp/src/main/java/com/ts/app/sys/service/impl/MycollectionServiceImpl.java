package com.ts.app.sys.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ts.app.sys.dao.MycollectionMapper;
import com.ts.app.sys.domain.Mycollection;
import com.ts.app.sys.service.MycollectionService;

@Service
public class MycollectionServiceImpl implements MycollectionService{

	@Autowired
	private MycollectionMapper mycollectionMapper;
	
	@Override
	public int deleteByPrimaryKey(Integer collectionid) {
		return mycollectionMapper.deleteByPrimaryKey(collectionid);
	}

	@Override
	public int insert(Mycollection record) {
		return mycollectionMapper.insert(record);
	}

	@Override
	public int insertSelective(Mycollection record) {
		return mycollectionMapper.insertSelective(record);
	}

	@Override
	public Mycollection selectByPrimaryKey(Integer collectionid) {
		return mycollectionMapper.selectByPrimaryKey(collectionid);
	}

	@Override
	public int updateByPrimaryKeySelective(Mycollection record) {
		return mycollectionMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Mycollection record) {
		return mycollectionMapper.updateByPrimaryKey(record);
	}

	public List<Mycollection> selectByArticeIdAndCreateUid(Map<String, Object> filterMap) {
		return mycollectionMapper.selectByArticeIdAndCreateUid(filterMap);
	}
	
	public int update2(Mycollection record){
		return mycollectionMapper.update2(record);
	}
}
