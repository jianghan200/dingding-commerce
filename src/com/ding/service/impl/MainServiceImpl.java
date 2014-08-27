package com.ding.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.ding.dao.CategoryDAO;
import com.ding.pojo.Category;
import com.ding.service.MainService;

public class MainServiceImpl implements MainService {
	/**
	 * 返回主界面左侧类别的数据
	 */
	private CategoryDAO categoryDao;

	public void setCategoryDao(CategoryDAO categoryDao) {
		this.categoryDao = categoryDao;
	}

	public List<Category> findLeftCategory() throws Exception {

		List<Category> all = categoryDao.findAll();
		// List<Category> cats = catDao.findAll();
		// 获取parentId = 1的元素
		List<Category> cats = findByParentId(all, 1);

		// 为cats集合元素的子元素subCats填充
		for (Category c : cats) {
			List<Category> subCats = findByParentId(all, c.getCat_id());
			// 将子项集合给c对象赋值
			c.setSubCats(subCats);

		}

		return cats;
	}

	private List<Category> findByParentId(List<Category> all, int parentId) {
		// 循环从all集合查找parentId=?的元素
		List<Category> list = new ArrayList<Category>();
		for (Category cat : all) {
			if (cat.getParentId().equals(parentId)) {
				list.add(cat);
			}
		}
		return list;
	}

	public static void main(String[] args) throws Exception {
		MainServiceImpl impl = new MainServiceImpl();
		impl.findLeftCategory();
	}
}
