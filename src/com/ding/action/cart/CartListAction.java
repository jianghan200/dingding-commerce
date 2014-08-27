package com.ding.action.cart;

import java.util.List;

import org.apache.commons.logging.Log;

import com.ding.action.BaseAction;
import com.ding.pojo.CartItem;
import com.ding.service.CartService;
import com.ding.util.Constant;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class CartListAction extends BaseAction {
	
	private static Log log = LogFactory.getLog(CartListAction.class);
	
	// output List of bought products
	private List<CartItem> item;
	private List<CartItem> delPros;
	// output actual selling price
	private double dangTotal;
	// output bargain you get
	private double cutDown;

	private CartService cartService;

	public void setCartService(CartService cartService) {
		this.cartService = cartService;
	}

	public String execute() {
		log.info("Execute");

		cartService = (CartService) session.get(Constant.CART_KEY);
		log.info("finish cartService");
		if (cartService != null) {
			log.info("cartService is not null");
			item = cartService.getBuyPros();
			delPros = cartService.getDelPros();
			dangTotal = cartService.dangCost();
			Double fixedTotal = cartService.fixedCost();
			cutDown = fixedTotal - dangTotal;

		}

		return "list";
	}

	public List<CartItem> getItem() {
		return item;
	}

	public void setItem(List<CartItem> item) {
		this.item = item;
	}

	public double getDangTotal() {
		return dangTotal;
	}

	public void setDangTotal(double dangTotal) {
		this.dangTotal = dangTotal;
	}

	public double getCutDown() {
		return cutDown;
	}

	public void setCutDown(double cutDown) {
		this.cutDown = cutDown;
	}

	public List<CartItem> getDelPros() {
		return delPros;
	}

	public void setDelPros(List<CartItem> delPros) {
		this.delPros = delPros;
	}

}
