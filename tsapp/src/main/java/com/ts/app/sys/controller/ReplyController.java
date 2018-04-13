package com.ts.app.sys.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ts.app.sys.domain.Reply;
import com.ts.app.sys.service.ReplyService;

/**
 * 回复controller
 */
@Controller
public class ReplyController extends BaseController {

	@Autowired
	private ReplyService replyService;
	
	@RequestMapping("/replyController/doInsert")
	@ResponseBody
	public Map<String,String> doInster(Reply reply){
		Map<String,String> retMap = new HashMap<String,String>();
		retMap.put("msg", "回复成功");
		retMap.put("flag", "1");
		
		try{
			
			Integer evaluateid = reply.getEvaluateid();
			
			List<Reply> replyList =  replyService.selectByEvaluateid( evaluateid);
			
			if(replyList!=null && replyList.size()>0){
				retMap.put("msg", "回复失败,一条评价只回复一次");
				retMap.put("flag", "0");
				return retMap;
			}
			
			Integer createuserid = getLoginUid();
			reply.setCreateuserid(createuserid);
			reply.setCreatedate(new Date());
			replyService.insert(reply);
		}catch(Exception e){
			retMap.put("msg", "回复失败");
			retMap.put("flag", "0");
		}
		
		return retMap;
	}
}
