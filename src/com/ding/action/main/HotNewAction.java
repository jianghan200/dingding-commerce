package com.ding.action.main;

import java.sql.SQLException;
import java.util.List;

import com.ding.dao.BookDAO;
import com.ding.dao.impl.JdbcBookDAO;
import com.ding.pojo.Item;

public class HotNewAction {
	private Integer size;
	private List<Item> bookNames;
	
	/**
	 * in this class, we want to get last Time
	 * 
	 * 
	 * @return
	 * @throws Exception
	 */
   private BookDAO bookDao;
	

	public void setBookDao(BookDAO bookDao) {
		this.bookDao = bookDao;
	}


	public String execute() throws Exception{
		long now = System.currentTimeMillis();
		System.out.print("now"+now) ;
		long monthTime = 30*24*60*1000L;
		Long lastTime = now-monthTime;
		//BookDAO dao = new JdbcBookDAO();
		bookNames = bookDao.findHotNewBook(lastTime, size);
		//System.out.println("bookNames"+bookNames.toString());
		Item   o=(Item)bookNames.get(0);
		System.out.println("bookNames"+o.getPriduct_name());
		return "success";
	}

	public Integer getSize() {
		return size;
	}

	public List<Item> getBookNames() {
		return bookNames;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public void setBookNames(List<Item> bookNames) {
		this.bookNames = bookNames;
	}

	
	
}
