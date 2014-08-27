package com.ding.action.main;

import java.sql.SQLException;
import java.util.List;

import com.ding.dao.BookDAO;
import com.ding.dao.impl.JdbcBookDAO;
import com.ding.pojo.Product;

public class HotBookAction {
	
	/**
	 * show all information of hot book
	 * 
	 * 
	 * 
	 */
	//input 
	private Integer size;
	//output
	
    private BookDAO bookDao;
	

	public void setBookDao(BookDAO bookDao) {
		this.bookDao = bookDao;
	}


	
	
	private List<Product> hotBooks;
	public String execute() throws SQLException{
		//System.out.println("size"+size);
		//BookDAO dao = new JdbcBookDAO();
		hotBooks = bookDao.findHotBook(size);
		///System.out.println("2"+hotBooks.toString());
		return "success";
	}
	public Integer getSize() {
		return size;
	}
	public List<Product> getHotBooks() {
		return hotBooks;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	public void setHotBooks(List<Product> hotBooks) {
		this.hotBooks = hotBooks;
	}
	
	
}
