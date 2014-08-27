package com.ding.action.main;

import java.util.List;

import com.ding.action.BaseAction;
import com.ding.pojo.Category;
import com.ding.service.MainService;
import com.ding.service.impl.MainServiceImpl;

/**
 * Get all information of different book
 * 
 * @author Team DingLingLing
 */

public class CategoryAction extends BaseAction {
	/** Container of all the category */
	private List<Category> cats;

	/** Spring Dependency Injection */
	private MainService mainService;



	public void setMainService(MainService mainService) {
		this.mainService = mainService;
	}
	
	/** 
	 * get all the category through main service
	 */
	public String execute() throws Exception {
		// Thread.sleep(2000);//simulate the delay of the net work
		
		// get the category set of left side
		cats = mainService.findLeftCategory();
		return "success";
	}

	public List<Category> getCats() {
		return cats;
	}

	public void setCats(List<Category> cats) {
		this.cats = cats;
	}

}
