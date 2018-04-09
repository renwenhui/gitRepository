package com.ts.app.sys.service;

import java.util.List;

import com.ts.app.sys.domain.Reply;

/**
 * 
 * 回复
 */
public interface ReplyService {

	int deleteByPrimaryKey(Integer replyid);

    int insert(Reply record);

    int insertSelective(Reply record);

    Reply selectByPrimaryKey(Integer replyid);

    int updateByPrimaryKeySelective(Reply record);

    int updateByPrimaryKey(Reply record);
    
    List<Reply> selectByEvaluateid(Integer evaluateid);
}
