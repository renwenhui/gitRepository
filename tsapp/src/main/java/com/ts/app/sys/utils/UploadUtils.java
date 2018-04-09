package com.ts.app.sys.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

public class UploadUtils {
	/**
	 * 提取上传文件
	 */
	public static List<MultipartFile> getFile(HttpServletRequest request) throws Exception {
		// 解析器解析request的上下文
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());
		// 先判断request中是否包涵multipart类型的数据
		List<MultipartFile> multipartFiles = new ArrayList<MultipartFile>();
		if (multipartResolver.isMultipart(request)) {
			// 再将request中的数据转化成multipart类型的数据
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			Iterator iter = multiRequest.getFileNames();
			while (iter.hasNext()) {
				multipartFiles.add(multiRequest.getFile((String) iter.next()));
			}
		}
		return multipartFiles;
	}
	/**
	 * 得到真实文件名
	 * @param fileName
	 * @return
	 */
    public static String subFileName(String fileName){
        //查找最后一个 \ (文件分隔符)位置
        int index = fileName.lastIndexOf(File.separator);
        if(index == -1){
            //没有分隔符，说明是真实名称
            return fileName;
        }else {
            return fileName.substring(index+1);
        }
    }

    /**
     * 获得随机UUID文件名
     * @param fileName
     * @return
     */
    public static String generateRandonFileName(String fileName){
        //首相获得扩展名，然后生成一个UUID码作为名称，然后加上扩展名
        String ext = fileName.substring(fileName.lastIndexOf("."));
        return UUID.randomUUID().toString().replace("-", "")+ext;
    }

    /**
     * 获得hashcode 生成二级目录
     * @param uuidFileName
     * @return
     */
    public static String generateRandomDir(String uuidFileName){
        int hashCode = uuidFileName.hashCode();//得到它的hashcode编码
        //一级目录
        int d1 = hashCode & 0xf;
        //二级目录
        int d2 = (hashCode >> 4) & 0xf;
        return "/"+d1+"/"+d2;
    }
}
