package com.ding.dao;

import java.sql.SQLException;
import java.util.List;

import com.ding.pojo.Book;

public interface IntroduceDAO {
	/**get detail information of the book by id.
	 * 
	 * @param id book id
	 * @return
	 * @throws Exception
	 */
	public Book findBookId(int id)throws Exception;
}
