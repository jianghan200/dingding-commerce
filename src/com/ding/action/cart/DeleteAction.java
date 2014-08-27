package com.ding.action.cart;

import java.util.List;

import com.ding.action.BaseAction;
import com.ding.pojo.CartItem;
import com.ding.service.CartService;

public class DeleteAction extends BaseAction {
	// input
	private int pid;
	private CartService cartService;

	public void setCartService(CartService cartService) {
		this.cartService = cartService;
	}

	public String execute() {
		System.out.println("pid" + pid);

		cartService = (CartService) session.get("cart");
		cartService.delete(pid);// delete product from cart

		return "list";// show the list of product
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

}
