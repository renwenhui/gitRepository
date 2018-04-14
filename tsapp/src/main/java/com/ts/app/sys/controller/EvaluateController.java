package com.ts.app.sys.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ts.app.sys.domain.Evaluate;
import com.ts.app.sys.service.EvaluateService;
import com.ts.app.sys.utils.CacheUtils;

/**
 * 评价controller
 */
@Controller
public class EvaluateController extends BaseController {

	@Autowired
	private EvaluateService evaluateService;
	
	/**
	 * 评价列表
	 */
	@RequestMapping("/evaluateController/list")
	@ResponseBody
	public List list(Integer articleid){
		Map<String,Object> filterMap = new HashMap<String,Object>();
		filterMap.put("articleid", articleid);
		 List  articleList= evaluateService.queryListByArticeId2(filterMap);
		return articleList;
	}
	
	/**
	 * 添加评价
	 */
	@RequestMapping("/evaluateController/doInsert")
	@ResponseBody
	public Map<String,String> doInster(Evaluate Evaluate){
		Map<String,String> retMap = new HashMap<String,String>();
		retMap.put("msg", "评价成功");
		retMap.put("flag", "1");
		
		try{
			Integer createuserid = getLoginUid();
			Evaluate.setCreateuserid(createuserid);
			Evaluate.setCreatedate(new Date());
			evaluateService.insert(Evaluate);
		}catch(Exception e){
			retMap.put("msg", "评价失败");
			retMap.put("flag", "0");
		}
		
		return retMap;
	}
	
	/**
	 * 获得我的未读取的评价消息(我发布的帖子)
	 * @param articleid
	 * @return
	 */
	@RequestMapping("/evaluateController/getMyUnRead")
	@ResponseBody
	public Map<String,Object> getMyUnRead(){
		Integer createuserid = getLoginUid();
		Map<String,Object> filterMap = new HashMap<String,Object>();
		filterMap.put("createUserId", createuserid);
		
		Integer  MyUnReadCount= 	evaluateService.getMyUnRead(filterMap);
		
		Integer  getMyUnReadReply= 	evaluateService.getMyUnReadReply(filterMap);
		
		
		Map<String,Object> retMap = new HashMap<String,Object>();
		retMap.put("MyUnReadCount", MyUnReadCount);
		retMap.put("getMyUnReadReply", getMyUnReadReply);
		retMap.put("flag", "1");
		
		return retMap;
	}
	
}
