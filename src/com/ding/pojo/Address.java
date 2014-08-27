package com.ding.pojo;

import java.io.Serializable;

public class Address implements Serializable{
	private Integer id;
	private Integer user_id;
	private String receive_name;
	private String full_address;
	private String postal_code ;
	private String mobile;
	private String phone;
	User user ;
	public User getUser() {
		return this.user;
	}
	public void setUser(User user) {
		this.user=user;
	}
	public Integer getId() {
		return id;
	}
	public Integer getUser_id() {
		return user_id;
	}
	
	public String getFull_address() {
		return full_address;
	}
	public String getPostal_code() {
		return postal_code;
	}
	public String getMobile() {
		return mobile;
	}
	public String getPhone() {
		return phone;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public void setUser_id(int userId) {
		user_id = userId;
	}
	
	public void setFull_address(String fullAddress) {
		full_address = fullAddress;
	}
	public void setPostal_code(String postalCode) {
		postal_code = postalCode;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getReceive_name() {
		return receive_name;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setUser_id(Integer userId) {
		user_id = userId;
	}
	public void setReceive_name(String receiveName) {
		receive_name = receiveName;
	}
	
	
}
