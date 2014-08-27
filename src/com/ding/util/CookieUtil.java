package com.ding.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * cookie工具类，提供了cookie的创建，查找，删除方法
 * @author jianqing
 *
 */
public class CookieUtil {
	private static String path = "dang";
	private static int deFault_age = 3600;
	/**
	 * 添加cookie，考虑编码问题
	 */
	public static void addCookie(String name,String value,
			HttpServletResponse res,int age)throws UnsupportedEncodingException{
		Cookie c = new Cookie (name,URLEncoder.encode(value,"utf-8"));
		c.setMaxAge(age);
		c.setPath(path);
		res.addCookie(c);
		
	}
	/**
	 * 使用缺省时间来创建cookie
	 */
	public static void addCookie(String name,
			String value,HttpServletResponse res) 
	throws UnsupportedEncodingException{
		addCookie(name,value,res,deFault_age);
	}
	/**
	 * 依据cookie的名字查找对应的cookie值
	 * 如果name对应的cookie不存在，返回null；
	 * 
	 */
	public static String findCookie(String name,HttpServletRequest req)
	  throws UnsupportedEncodingException{
		String value = null;
		Cookie[] cookies = req.getCookies();
		if(cookies !=null){
			for(int i=0;i<cookies.length;i++){
				Cookie curr = cookies[i];
				if(curr.getName().equals(name)){
					value =  URLDecoder.decode(
							curr.getValue(),"utf-8");
				}
			}
		}
		return value;
	}
	
}

	
	
	
	
	
	
	
	