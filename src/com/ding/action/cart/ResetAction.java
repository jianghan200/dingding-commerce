package com.ding.action.cart;

import java.sql.SQLException;

import com.ding.action.BaseAction;
import com.ding.service.CartService;

public class ResetAction extends BaseAction {

	// output
	private boolean ok = true;

	public String execute() throws SQLException {
		session.remove("cart");
		return "success";
	}

	public boolean isOk() {
		return ok;
	}

	public void setOk(boolean ok) {
		this.ok = ok;
	}

}
