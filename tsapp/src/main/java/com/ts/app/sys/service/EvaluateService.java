package com.ts.app.sys.service;

import java.util.List;
import java.util.Map;

import com.ts.app.sys.domain.Evaluate;

/**
 * 
 * 评价
 */
public interface EvaluateService {

 	int deleteByPrimaryKey(Integer evaluateid);

    int insert(Evaluate record);

    int insertSelective(Evaluate record);

    Evaluate selectByPrimaryKey(Integer evaluateid);

    int updateByPrimaryKeySelective(Evaluate record);

    int updateByPrimaryKey(Evaluate record);
    
    public List<Evaluate> queryListByArticeId(Map<String, Object> filterMap) ;
    
    public List queryListByArticeId2(Map<String, Object> filterMap) ;
    
    public Integer getMyUnRead(Map<String, Object> filterMap) ;
    
    public Integer getMyUnReadReply(Map<String, Object> filterMap) ;

	void changegetMyUnRead(Map<String, Object> filterMap);

	void changeMyUnReadReply(Map<String, Object> filterMap);
    
    
}
