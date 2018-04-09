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

/**
 * 评价controller
 */
@Controller
public class EvaluateController extends BaseController {

	@Autowired
	private EvaluateService evaluateService;

	@RequestMapping("/evaluateController/list")
	@ResponseBody
	public List<Evaluate> list(Integer articleid){
		Map<String,Object> filterMap = new HashMap<String,Object>();
		filterMap.put("articleid", articleid);
		 List<Evaluate>  articleList= 	evaluateService.queryListByArticeId(filterMap);
		return articleList;
	}
	
	@RequestMapping("/evaluateController/doInsert")
	@ResponseBody
	public Map<String,String> doInster(Evaluate Evaluate){
		Map<String,String> retMap = new HashMap<String,String>();
		retMap.put("msg", "成功");
		retMap.put("flag", "1");
		
		try{
			Integer createuserid = getLoginUid();
			Evaluate.setCreateuserid(createuserid);
			Evaluate.setCreatedate(new Date());
			evaluateService.insert(Evaluate);
		}catch(Exception e){
			retMap.put("msg", "失败");
			retMap.put("flag", "0");
		}
		
		return retMap;
	}
}
