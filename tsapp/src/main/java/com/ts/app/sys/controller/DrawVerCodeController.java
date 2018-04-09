package com.ts.app.sys.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ts.app.sys.constants.Constants;
import com.ts.app.sys.utils.SCaptcha;

@Controller
public class DrawVerCodeController {
	
	/**
     * @description 生成图片验证码
     */
    @RequestMapping(value = "/drawVerCode")
    @ResponseBody
    public void drawVerCode(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        // 设置响应的类型格式为图片格式
        response.setContentType("image/jpeg");
        // 禁止图像缓存。
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        //实例生成验证码对象
        SCaptcha instance = new SCaptcha();
        //将验证码存入session
        session.setAttribute(Constants.IMG_CODE, instance.getCode());
        //向页面输出验证码图片
        instance.write(response.getOutputStream());
    }
    
    public static void main(String[] args) {  
    	SCaptcha vCode = new SCaptcha();  
        try {  
            String path="D:/t/"+new Date().getTime()+".png";  
            System.out.println(vCode.getCode()+" >"+path);  
            vCode.write(path);  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    } 
}
