package com.ts.app.sys.dao;

import java.util.List;
import java.util.Map;

import com.ts.app.sys.domain.Mycollection;

public interface MycollectionMapper {
    int deleteByPrimaryKey(Integer collectionid);

    int insert(Mycollection record);

    int insertSelective(Mycollection record);

    Mycollection selectByPrimaryKey(Integer collectionid);

    int updateByPrimaryKeySelective(Mycollection record);

    int updateByPrimaryKey(Mycollection record);
    
    public List<Mycollection> selectByArticeIdAndCreateUid(Map<String, Object> filterMap) ;
    
    int update2(Mycollection record);
}