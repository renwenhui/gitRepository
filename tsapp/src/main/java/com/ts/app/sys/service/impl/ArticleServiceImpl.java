package com.ts.app.sys.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ts.app.sys.dao.ArticleMapper;
import com.ts.app.sys.domain.Article;
import com.ts.app.sys.service.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService{

	@Autowired
	private ArticleMapper articleMapper;
	
	@Override
	public int deleteByPrimaryKey(Integer articleid) {
		return articleMapper.deleteByPrimaryKey(articleid);
	}

	@Override
	public int insert(Article record) {
		return articleMapper.insert(record);
	}

	@Override
	public int insertSelective(Article record) {
		return articleMapper.insertSelective(record);
	}

	@Override
	public Article selectByPrimaryKey(Integer articleid) {
		return articleMapper.selectByPrimaryKey(articleid);
	}

	@Override
	public int updateByPrimaryKeySelective(Article record) {
		return articleMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKeyWithBLOBs(Article record) {
		return articleMapper.updateByPrimaryKeyWithBLOBs(record);
	}

	@Override
	public int updateByPrimaryKey(Article record) {
		return articleMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<Article> queryListArticle(Map<String, Object> filterMap) {
		return articleMapper.queryListArticle(filterMap);
	}
	
	@Override
	public List<Article> queryListArticle2(Map<String,Object> filterMap){
		return articleMapper.queryListArticle2(filterMap);
	}
	
}
