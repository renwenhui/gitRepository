package com.ts.app.sys.shiro;

import org.apache.shiro.authc.UsernamePasswordToken;  

public class CustomUsernamePasswordToken extends UsernamePasswordToken {  
  
    private static final long serialVersionUID = 1L;
  
  
    public CustomUsernamePasswordToken(String username, String password) {  
        //调用父类的构造函数  
        super(username,password);  
    }
  
}
