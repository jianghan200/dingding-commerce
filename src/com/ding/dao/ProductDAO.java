package com.ding.dao;

import java.sql.SQLException;
import java.util.List;

import com.ding.pojo.Product;
/**
 * list detail info of product order by add time
 * @author Administrator
 *
 */
public interface ProductDAO {
	public List<Product> findNewProduct(int size)throws SQLException;
	 public Product findById(int id) throws SQLException;
}
