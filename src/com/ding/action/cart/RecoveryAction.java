package com.ding.action.cart;

import com.ding.action.BaseAction;
import com.ding.service.CartService;

public class RecoveryAction extends BaseAction {
	// input
	private int pid;
	private CartService cartService;

	public void setCartService(CartService cartService) {
		this.cartService = cartService;
	}

	public String execute() {
		cartService = (CartService) session.get("cart");
		cartService.recovery(pid);
		return "list";
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

}
