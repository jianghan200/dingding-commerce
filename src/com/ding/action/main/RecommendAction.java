package com.ding.action.main;

import java.util.List;

import com.ding.action.BaseAction;
import com.ding.dao.IntroduceDAO;
import com.ding.dao.BookDAO;
import com.ding.dao.impl.JdbcBookDAO;
import com.ding.pojo.Book;

/**
 * 
 * 
 * @author hans
 *
 */

public class RecommendAction extends BaseAction{
	//output
	private List<Book> redBook;
	//private BookDAO dao;
	
    private BookDAO bookDao;
	

	public void setBookDao(BookDAO bookDao) {
		this.bookDao = bookDao;
	}


	public String execute() throws Exception{
		//System.out.println("hol bible");
		redBook = bookDao.findAll();
		//System.out.println("holy shit bible");
		return "success";
	}

	public List<Book> getRedBook() {
		return redBook;
	}

	public void setRedBook(List<Book> redBook) {
		this.redBook = redBook;
	}
	
}
