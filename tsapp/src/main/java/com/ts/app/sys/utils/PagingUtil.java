package com.ts.app.sys.utils;

import javax.servlet.http.HttpServletRequest;
import com.github.pagehelper.PageHelper;

public class PagingUtil extends PageHelper {
	
	/**
	 * 设置分页参数
	 * @author chunyu.xia
	 */
	public static void setPageParam(HttpServletRequest request){
		String pageNum = request.getParameter("pageNum");
		String pageSize = request.getParameter("pageSize");
		pageNum =  pageNum == null?"1":pageNum;
		pageSize =  pageSize == null?"10":pageSize;
		PageHelper.startPage(Integer.parseInt(pageNum),Integer.parseInt(pageSize));
	}
}
