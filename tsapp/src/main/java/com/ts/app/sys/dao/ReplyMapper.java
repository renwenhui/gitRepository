package com.ts.app.sys.dao;

import java.util.List;

import com.ts.app.sys.domain.Reply;

public interface ReplyMapper {
    int deleteByPrimaryKey(Integer replyid);

    int insert(Reply record);

    int insertSelective(Reply record);

    Reply selectByPrimaryKey(Integer replyid);

    int updateByPrimaryKeySelective(Reply record);

    int updateByPrimaryKey(Reply record);
    
    List<Reply> selectByEvaluateid(Integer evaluateid);
}