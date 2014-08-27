package com.ding.action.main;

import com.ding.action.BaseAction;
import com.ding.dao.IntroduceDAO;
import com.ding.dao.impl.JdbcBIntroduceDAO;
import com.ding.pojo.Book;

/**
 * use get book inforamtion
 * 
 * 
 * @author Administrator
 * 
 */

public class ProductAction extends BaseAction {
	// input
	private int id;
	// output
	private Book book;

	private IntroduceDAO introduceDao;

	public void setIntroduceDao(IntroduceDAO introduceDao) {
		this.introduceDao = introduceDao;
	}


	public String execute() throws Exception {
		// BIntroduceDAO dao = new JdbcBIntroduceDAO();
		book = introduceDao.findBookId(id);

		return "success";
	}

	public int getId() {
		return id;
	}

	public Book getBook() {
		return book;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setBook(Book book) {
		this.book = book;
	}

}
