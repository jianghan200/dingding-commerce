package com.ding.service;

import java.sql.SQLException;
import java.util.List;

import com.ding.pojo.CartItem;
import com.ding.pojo.Product;

public interface CartService {
	//购买
	public boolean add(int pid) throws SQLException;
	//删除
	public void delete(int pid);
	public void update(int pid,int pum);
	
	public void recovery(int pid);
	public double dangCost();
	public double fixedCost();
	public List<CartItem> getBuyPros();
	public List<CartItem> getDelPros();
	
}
