package com.ding.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Order implements Serializable{
	private Integer order_id;
	private Integer user_Id;
	private Integer status;
	private long order_time;
	private String order_desc;
	private double total_price;
	private String receive_name;
	private String full_address;
	private String postal_code;
	private String mobile;
	private String phone;
	private Set<Item> items
	= new HashSet<Item>();
	
	
	
	private  User user ;

	public Integer getOrder_id() {
		return order_id;
	}
	public Integer getUser_Id() {
		return user_Id;
	}
	public Integer getStatus() {
		return status;
	}
	public long getOrder_time() {
		return order_time;
	}
	public String getOrder_desc() {
		return order_desc;
	}
	public double getTotal_price() {
		return total_price;
	}
	public String getReceive_name() {
		return receive_name;
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
	public User getUser() {
		return user;
	}
	public Set<Item> getItems() {
		return items;
	}
	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}
	public void setUser_Id(Integer userId) {
		user_Id = userId;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public void setOrder_time(long orderTime) {
		order_time = orderTime;
	}
	public void setOrder_desc(String orderDesc) {
		order_desc = orderDesc;
	}
	public void setTotal_price(double totalPrice) {
		total_price = totalPrice;
	}
	public void setReceive_name(String receiveName) {
		receive_name = receiveName;
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
	
	public void  setUser(User user ) {
		 this.user=user;
	}
	public void setItems(Set<Item> items) {
		this.items=items;
	}
	
	
	
	
}
