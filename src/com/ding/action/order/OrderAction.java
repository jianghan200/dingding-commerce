package com.ding.action.order;

import java.util.List;

import com.ding.action.BaseAction;
import com.ding.pojo.CartItem;
import com.ding.service.CartService;

public class OrderAction extends BaseAction{
	//output
	private List<CartItem> buyPros;
	private CartService cartService;
	
	//output dang网总价
	private double dangTotal;
	private String msg;
	public String execute(){
		cartService = (CartService)session.get("cart");
		if(cartService==null){
			msg="您还没购买商品";
			return "empty";
		}else{
		 buyPros = cartService.getBuyPros();
		 dangTotal = cartService.dangCost();
		return "orderlist";
		}
	}
	public List<CartItem> getBuyPros() {
		return buyPros;
	}
	public double getDangTotal() {
		return dangTotal;
	}
	public void setBuyPros(List<CartItem> buyPros) {
		this.buyPros = buyPros;
	}
	public void setDangTotal(double dangTotal) {
		this.dangTotal = dangTotal;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}
