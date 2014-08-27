package com.ding.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 与d_user对应
 * @author soft1
 *
 */
public class User implements Serializable{
	private Integer USER_ID;
	private String email;
	private String nickname;
	/**
	 * 用户等级
	 */
	private Integer userIntegral;
	private String password;
	private String emailVerify = "N";
	private String emailVerifyCode;
	private long lastLoginTime;
	private String lastLoginIp;
//	1－N关联关系，使用Set来保存关联实体
	private Set<Address> address
		= new HashSet<Address>();
	
	private Set<Order> orders
	= new HashSet<Order>();


	public Integer getUSER_ID() {
		return USER_ID;
	}
	

	/**
	 * 返回用户邮箱
	 * @return
	 */
	public String getEmail() {
		return email;
	}
	public String getNickname() {
		return nickname;
	}
	public Integer getUserIntegral() {
		return userIntegral;
	}
	public String getPassword() {
		return password;
	}
	public String getEmailVerify() {
		return emailVerify;
	}
	public String getEmailVerifyCode() {
		return emailVerifyCode;
	}
	public long getLastLoginTime() {
		return lastLoginTime;
	}
	public String getLastLoginIp() {
		return lastLoginIp;
	}
	public Set<Order> getOrders() {
		return orders;
	}
	public void setUSER_ID(Integer USER_ID) {
		this.USER_ID = USER_ID;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public void setUserIntegral(Integer userIntegral) {
		this.userIntegral = userIntegral;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setEmailVerify(String emailVerify) {
		this.emailVerify = emailVerify;
	}
	public void setEmailVerifyCode(String emailVerifyCode) {
		this.emailVerifyCode = emailVerifyCode;
	}
	public void setLastLoginTime(long lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}
	
//	addresses属性的setter和getter方法
	public void setAddress(Set<Address> address)
	{
		this.address = address;
	}
	public Set<Address> getAddress()
	{
		return this.address;
	}
	
	public void  setOrders(Set<Order> orders) {
		this.orders=orders;
	}

}
