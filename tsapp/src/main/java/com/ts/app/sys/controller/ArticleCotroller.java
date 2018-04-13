package com.ts.app.sys.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ts.app.sys.domain.Article;
import com.ts.app.sys.domain.Mycollection;
import com.ts.app.sys.service.ArticleService;
import com.ts.app.sys.service.MycollectionService;
import com.ts.app.sys.utils.CacheUtils;

/**
 * 
 * 文章controller
 *
 */
@Controller
public class ArticleCotroller extends BaseController{
	
	private static Logger logger = Logger.getLogger(ArticleCotroller.class);
	
	@Autowired
    private ArticleService articleService;  
	
	@Autowired
	private MycollectionService mycollectionService;

	/**
	 * 校内 管理员发布,userType=0
	 * @return
	 */
	@RequestMapping("/articleController/list")
	@ResponseBody
	public List<Article> list(){
			Map<String,Object> filterMap = new HashMap<String,Object>();
			filterMap.put("userType", "0");
			List<Article>  articleList= articleService.queryListArticle(filterMap);
		return articleList;
	}
	
	/**
	 * 推荐,userTyp=1
	 * @return
	 */
	@RequestMapping("/articleController/listTuijian")
	@ResponseBody
	public List<Article> listTuijian(){
		Map<String,Object> filterMap = new HashMap<String,Object>();
		filterMap.put("userType", "1");
		List<Article>  articleList= articleService.queryListArticle(filterMap);
		return articleList;
	}
	
	/**
	 * 我的帖子
	 */
	@RequestMapping("/articleController/listMy")
	@ResponseBody
	public List<Article> listMy(){
		Map<String,Object> filterMap = new HashMap<String,Object>();
		filterMap.put("userType", "1");
		List<Article>  articleList= 	articleService.queryListArticle(filterMap);
		return articleList;
	}
	
	/**
	 * 我的发布的帖子，有未读的评价
	 * @return
	 */
	@RequestMapping("/articleController/listPingjia")
	@ResponseBody
	public List<Article> listPingjia(){
			Map<String,Object> filterMap = new HashMap<String,Object>();
			Integer createuserid = getLoginUid();
			filterMap.put("createuserid", createuserid);
			List<Article>  articleList= 	articleService.listPingjia(filterMap);
		return articleList;
	}
	
	/**
	 * 我回复的评价，评价对应的帖子
	 * @return
	 */
	@RequestMapping("/articleController/listReply")
	@ResponseBody
	public List<Article> listReply(){
			Map<String,Object> filterMap = new HashMap<String,Object>();
			Integer createuserid = getLoginUid();
			filterMap.put("createuserid", createuserid);
			List<Article>  articleList= 	articleService.listReply(filterMap);
		return articleList;
	}
	
	
	@RequestMapping("/articleController/doInsert")
	@ResponseBody
	public Map<String,String> doInster(Article article){
		Map<String,String> retMap = new HashMap<String,String>();
		retMap.put("msg", "成功");
		retMap.put("flag", "1");
		
		try{
		Integer createuserid = getLoginUid();
		article.setCreateuserid(createuserid);
		article.setCreatedate(new Date());
		articleService.insert(article);
		}catch(Exception e){
			retMap.put("msg", "发布失败");
			retMap.put("flag", "0");
		}
		
		return retMap;
	}
	
	@RequestMapping("/articleController/get")
	@ResponseBody
	public Article get(Integer articleid){
		Article article = new Article();
		try{
			
			article = articleService.selectByPrimaryKey(articleid);
		}catch(Exception e){
			
		}
		
		return article;
	}
	
	/**
	 * 发帖
	 */
	
	@RequestMapping(value = "/articleController/publishArticle", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,String> upphoto(HttpServletRequest request, @RequestParam(value="file",required = false)MultipartFile file[],String title, String articlecontent){
		Map<String,String> retMap = new HashMap<String,String>();
		retMap.put("msg", "发布成功");
		retMap.put("flag", "1");
		
		try{
		//target=this.articleService.selectByPrimaryKey(id);
		//获取用户id
		Integer userId = CacheUtils.getUser().getUserId();
		//本地测试路径
		String path="F:/work/upload/";
		Article target= new Article();
		target.setCreateuserid(userId);
		target.setTitle(title);
		target.setArticlecontent(articlecontent);
		
		//验证地址是否存在
		File targetFile=new File(path); 
		if(!targetFile.exists()){
			targetFile.mkdirs();
		}
		
		//遍历
			for(int i=0; i<file.length;i++){
				
				if(!file[i].isEmpty()){
					try {		
						//获取照片原始名称
						String photoName=file[i].getOriginalFilename();
						//扩展名
						String extName = photoName.substring(photoName.lastIndexOf("."));
						//防止图片名称冲突，中文乱码等问题重命名
						photoName = System.nanoTime() + extName; 
						target.setImgurl(photoName);
						
						//创建实际路径	
						file[i].transferTo(new File(path+photoName));
						
					} catch (IllegalStateException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				
			}
		
		articleService.insertSelective(target);
		
		return retMap;
			}catch (Exception e) {
				logger.error("上传照片时发生错误：{}"+e.getMessage(), e);

				return retMap;
				
			}

	}
	
	/**
	 * 点赞
	 * @param article
	 * @return
	 */
	@RequestMapping("/articleController/doLikenum")
	@ResponseBody
	public Article doLikenum(Integer articleid){
		
		try{
			
			Integer createUserId = getLoginUid();
			
			Map<String,Object> filterMap = new HashMap<String,Object>();
			filterMap.put("articleid", articleid);
			filterMap.put("createUserId", createUserId);
			
			List<Mycollection> MycollectionList = mycollectionService.selectByArticeIdAndCreateUid(filterMap);
			
			if(MycollectionList==null || MycollectionList.size()==0){
				Mycollection Mycollection = new Mycollection();
				Mycollection.setArticleid(articleid);
				Mycollection.setCreatedate(new Date());
				Mycollection.setCreateuserid(createUserId);
				
				mycollectionService.insert(Mycollection);
				
				Article article = articleService.selectByPrimaryKey(articleid);
				article.setLikenum(1);
				articleService.updateByPrimaryKeySelective(article);
				
				return article;
				
			}else{
			
				Mycollection Mycollection = new Mycollection();
				Mycollection.setArticleid(articleid);
				Mycollection.setCreateuserid(createUserId);
				Mycollection.setDeleteflag("1");//取消状态
				
				mycollectionService.update2(Mycollection);
				
				Article article = articleService.selectByPrimaryKey(articleid);
				article.setLikenum(article.getLikenum()-1);
				articleService.updateByPrimaryKeySelective(article);
				
				return article;
				
			}
		
		}catch(Exception e){
		}
		
		return new Article();
	}
	
}
