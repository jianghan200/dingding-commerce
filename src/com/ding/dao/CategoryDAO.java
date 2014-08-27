package com.ding.dao;

import java.util.List;

import com.ding.pojo.Category;

public interface CategoryDAO {
	/**
	 * list all the info of category
	 * @return
	 * @throws Exception
	 */
	public List<Category> findAll() throws Exception;
	/**
	 * show all child category info by given id
	 * @param parentId this category's children will be list
	 * @return
	 * @throws Exception
	 */
	public List<Category> findByParentId(int parentId) throws Exception;
}
