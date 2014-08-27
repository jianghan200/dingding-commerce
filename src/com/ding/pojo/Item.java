package com.ding.pojo;

import java.io.Serializable;

public class Item implements Serializable{
	private Integer id;
	private Integer order_id;
	private Integer product_id;
	private String priduct_name;
	private double dang_price;
	private Integer product_num;
	private double amout;
	private  Product product ;
	
	private  Order order ;
	
	
	
	public Integer getId() {
		return id;
	}
	public Integer getOrder_id() {
		return order_id;
	}
	public Integer getProduct_id() {
		return product_id;
	}
	public String getPriduct_name() {
		return priduct_name;
	}
	public double getDang_price() {
		return dang_price;
	}
	public Integer getProduct_num() {
		return product_num;
	}
	public double getAmout() {
		return amout;
	}
	public Product  getProduct() {
		return product;
	}
	public Order getOrder() {
		return order;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setOrder_id(Integer orderId) {
		order_id = orderId;
	}
	public void setProduct_id(Integer productId) {
		product_id = productId;
	}
	public void setPriduct_name(String priductName) {
		priduct_name = priductName;
	}
	public void setDang_price(double dangPrice) {
		dang_price = dangPrice;
	}
	public void setProduct_num(Integer productNum) {
		product_num = productNum;
	}
	public void setAmout(double amout) {
		this.amout = amout;
	}
	public  void  setProduct(Product product) {
		this.product=product;
	}
	public void setOrder(Order order) {
		this.order= order;
	}
	
}
