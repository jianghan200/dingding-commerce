package com.ding.action.cart;

import java.sql.SQLException;

import com.ding.action.BaseAction;
import com.ding.service.CartService;

public class BuyAction extends BaseAction {
	/** product id */
	private int pid;
	// output
	private boolean ok = true;

	private CartService cartService;

	public void setCartService(CartService cartService) {
		this.cartService = cartService;
	}

	public String execute() throws SQLException {
		// Get the Cart
		
		System.out.println( " cartService"+cartService);
		if(session.get("cart") == null){
			session.put("cart", this.cartService);
		}
		CartService  cart=(CartService) session.get("cart") ;
		System.out.println( " cart"+cart);
		ok = cart.add(pid);
		System.out.println("buying4");

		return "success";
	}

	public int getPid() {
		return pid;
	}

	public boolean isOk() {
		return ok;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public void setOk(boolean ok) {
		this.ok = ok;
	}

}
