package com.ding.action.cart;

import com.ding.action.BaseAction;
import com.ding.service.CartService;

public class UpdateAction extends BaseAction {
	// input
	private int num;
	private int id;

	private CartService cartService;

	public void setCartService(CartService cartService) {
		this.cartService = cartService;
	}

	public String execute() {
		cartService = (CartService) session.get("cart");
		cartService.update(id, num);
		return "list";// show the list of product
	}

	public int getNum() {
		return num;
	}

	public int getId() {
		return id;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public void setId(int id) {
		this.id = id;
	}

}
