package com.ding.action.main;

import java.sql.SQLException;
import java.util.List;



import com.ding.action.BaseAction;
import com.ding.dao.ProductDAO;
import com.ding.dao.impl.JdbcProductDAO;
import com.ding.pojo.Product;
/**
 * get 8 new books
 * 
 * 
 * @author Administrator
 *
 */
public class NewAction extends BaseAction{
	//output 最新上架的前8个
	private List<Product> pros;
	//在struts.xml中注入一个值
	private int size = 5;
	
private ProductDAO productDao;
	

	public void setProductDao(ProductDAO productDao) {
		this.productDao = productDao;
	}


	
	public String execute() throws Exception{
		//ProductDAO proDao = new JdbcProductDAO();
		pros = productDao.findNewProduct(size);
		
		
		return "success";
	}
	public List<Product> getPros() {
		return pros;
	}
	public int getSize() {
		return size;
	}
	public void setPros(List<Product> pros) {
		this.pros = pros;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
}
