package com.ding.pojo;

import java.io.Serializable;

public class CartItem implements Serializable {
	private Product pro;//用来包含商品信息
	private int qty=1 ;//数量，默认值是1
	//是否购买 true:购买 false:删除
	//private boolean buy = true;
	public Product getPro() {
		return pro;
	}
	public int getQty() {
		return qty;
	}
	public void setPro(Product pro) {
		this.pro = pro;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	
	
}
