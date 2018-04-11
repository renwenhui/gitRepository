package com.ts.app.sys.service;

import java.util.List;
import java.util.Map;

import com.ts.app.sys.domain.Article;

public interface ArticleService {

	int deleteByPrimaryKey(Integer articleid);

    int insert(Article record);

    int insertSelective(Article record);

    Article selectByPrimaryKey(Integer articleid);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKeyWithBLOBs(Article record);

    int updateByPrimaryKey(Article record);
    
    public List<Article> queryListArticle(Map<String,Object> filterMap);
    
    public List<Article> queryListArticle2(Map<String,Object> filterMap);
    
    
    /**
	 * 我的发布的帖子，有未读的评价
	 * @return
	 */
    public List<Article> listPingjia(Map<String,Object> filterMap);
    
    /**
	 * 我回复的评价，评价对应的帖子
	 * @return
	 */
      public List<Article> listReply(Map<String,Object> filterMap);
    
}
