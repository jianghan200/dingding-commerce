package com.ding.interceptor;

import java.util.Map;

import com.ding.pojo.User;
import com.ding.service.CartService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;


/**
 * 登录检查拦截器
 * @author jianqing
 *
 */
public class CheckLoginInterceptor extends AbstractInterceptor{
	public String intercept(ActionInvocation invocation) throws Exception{
		//获取Session对象
		System.out.println("登录检查拦截器开始");
		ActionContext ac = invocation.getInvocationContext();
		Map<String,Object> session = ac.getSession();
		User user = (User)session.get("user");
		CartService cart = (CartService)session.get("cart");
		//未登录，转到login标识页面
		if(user==null){
			return "mustlogin";
		}else{
			//执行Action和Result
			String resultCode = invocation.invoke();
			System.out.println("拦截器后续处理");
			return resultCode;
		}
	}
	
}
