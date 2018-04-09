package com.ts.app.sys.utils;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class BaseUtil {
	/**
	 * 清除指定的session信息
	 */
	public static String getLoginIp(){
		String loginIp = null;
		Enumeration allNetInterfaces = null;
		try {
			allNetInterfaces = NetworkInterface.getNetworkInterfaces();
		} catch (SocketException e) {
			e.printStackTrace();
		}
		InetAddress ip = null;
		while (allNetInterfaces.hasMoreElements()) {
			NetworkInterface netInterface = (NetworkInterface) allNetInterfaces
					.nextElement();
			Enumeration addresses = netInterface.getInetAddresses();
			while (addresses.hasMoreElements()) {
				ip = (InetAddress) addresses.nextElement();
				if (ip != null && ip instanceof Inet4Address) {
					if (!ip.getHostAddress().equals("127.0.0.1")) {
						//System.out.println("本机的IP = " + ip.getHostAddress());
						loginIp = ip.getHostAddress();
					} 
				}
			}
		}
		return loginIp;
	}
	
	/**
	 * 获取6位随机数
	 */
	public static String getRandomNumber(){
		return (int)((Math.random()*9+1)*100000) + ""; //获取6位随机数
	}
	
}
