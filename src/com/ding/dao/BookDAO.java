package com.ding.dao;

import java.sql.SQLException;
import java.util.List;

import com.ding.pojo.Book;
import com.ding.pojo.Item;
import com.ding.pojo.Product;

public interface BookDAO {
	/**
	 * query products of the category in pages.
	 * @param CatId category Id
	 * @param page number of pages need to be show
	 * @param size number of products in one page
	 * @return
	 * @throws Exception
	 */
	public List<Product> findByCatId(int CatId,int page, int size)throws Exception;
	public List<Book> findAll() throws Exception;
	/**hot book
	 * 
	 * @param number
	 * @return
	 * @throws SQLException
	 */
	public List<Product> findHotBook(int number) throws SQLException;
	/**hot new book
	 * 
	 * @param monthTime
	 * @param number
	 * @return
	 * @throws Exception
	 */
	public List<Item> findHotNewBook(long monthTime, int number)throws  Exception;
}
