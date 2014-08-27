package com.ding.action;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;
/*
 * 
 * 1、ServletRequestAware这个接口中的方法是setServletRequest(HttpServletRequest request) 可以获得这次请求的request对象
 * 2、RequestAware这个接口中的方法是setRequest(Map request) 它只能够获得这次请求中包含request对象中全部attributes的一个map对象
 */
public class BaseAction implements RequestAware, SessionAware,
			ApplicationAware,ServletRequestAware,ServletContextAware{
	public Map<String, Object> request;
	public Map<String, Object> session;
	public Map<String, Object> application;
	public HttpServletRequest httpRequest;
	public HttpSession httpSession;
	public ServletContext httpApplication;
	
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public void setApplication(Map<String, Object> application) {
		
		this.application = application;
	}

	public void setServletRequest(HttpServletRequest httpRequest) {
		this.httpRequest = httpRequest;
		httpSession = httpRequest.getSession();
	}

	public void setServletContext(ServletContext httpApplication) {
		this.httpApplication = httpApplication;
	}

}

