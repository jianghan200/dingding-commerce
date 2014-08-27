package com.ding.util;

import org.apache.commons.mail.SimpleEmail;

/**
 * 利用sina.cn邮件服务器发送邮件（注意事项）
 * a 注册一个邮箱，setAuthentication利用帐号和密码
 * b setFrom必须和setAuthentication使用同一个身份
 * c 登录邮箱，开启SMTP发邮件服务
 * @author soft1
 *
 */
public class EmailUtil {
	public static void sendEmail(String emailAddr,String verifyCode){
		System.out.println("给"+emailAddr+"发送验证码"+verifyCode);
		
	    //邮件发送
//	    SimpleEmail email = new SimpleEmail();
//	    email.setHostName("smtp.sina.cn");
//	    email.setAuthentication("ljq_2000", "11111111");
//	    email.setCharset("UTF-8");
//	    try {
//	      email.addTo(emailAddr);
//	      email.setFrom("ljq_2000@sina.cn");//必须和Authentication使用的用户相同，否则失败
//	      email.setSubject("邮箱验证码");
//	      email.setMsg("恭喜您注册成功,邮箱验证码为"+verifyCode);
//	      email.send();
//	    } catch (EmailException e) {
//	      e.printStackTrace();
//	    }
		
	}
}
