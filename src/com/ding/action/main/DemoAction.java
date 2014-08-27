package com.ding.action.main;

import java.util.List;

import com.ding.action.BaseAction;
import com.ding.dao.impl.JdbcAdminDAO;
import com.ding.pojo.Category;
import com.ding.pojo.User;
import com.ding.service.MainService;

/**
 * Get all information of different book
 * 
 * @author Team DingLingLing
 */

public class DemoAction extends BaseAction {
	/** Container of all the category */
	private List<User> users;

	
	/** 
	 * get all the category through main service
	 */
	public String execute() throws Exception {
		// Thread.sleep(2000);//simulate the delay of the net work
		
		// get the category set of left side
		JdbcAdminDAO adminDAO = new JdbcAdminDAO();
		users = adminDAO.findAllUser();
		
		
		return "success";
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}
