package com.ts.app.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ts.app.sys.dao.ReplyMapper;
import com.ts.app.sys.domain.Reply;
import com.ts.app.sys.service.ReplyService;

@Service
public class ReplyServiceImpl  implements ReplyService{
	@Autowired
	private ReplyMapper replyMapper;

	@Override
	public int deleteByPrimaryKey(Integer replyid) {
		return replyMapper.deleteByPrimaryKey( replyid);
	}

	@Override
	public int insert(Reply record) {
		return replyMapper.insert(record);
	}

	@Override
	public int insertSelective(Reply record) {
		return replyMapper.insertSelective(record);
	}

	@Override
	public Reply selectByPrimaryKey(Integer replyid) {
		return replyMapper.selectByPrimaryKey(replyid);
	}

	@Override
	public int updateByPrimaryKeySelective(Reply record) {
		return replyMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Reply record) {
		return replyMapper.updateByPrimaryKey(record);
	}
	
	@Override
	public List<Reply> selectByEvaluateid(Integer evaluateid){
		return replyMapper.selectByEvaluateid(evaluateid);
	}

}
