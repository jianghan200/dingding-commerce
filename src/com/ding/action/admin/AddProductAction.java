package com.ding.action.admin;

import com.ding.dao.impl.JdbcAdminDAO;
import com.ding.pojo.Product;
import com.ding.pojo.User;

public class AddProductAction {
    private JdbcAdminDAO jdbcAdminDao;
    private String productName;
    private String description;
    private float dang_price;
    private float fix_price;
    private Product product;
    


	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}


	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getFix_price() {
		return fix_price;
	}
	public void setFix_price(float fix_price) {
		this.fix_price = fix_price;
	}
	public float getDang_price() {
		return dang_price;
	}
	public void setDang_price(float dang_price) {
		this.dang_price = dang_price;
	}
	public JdbcAdminDAO getJdbcAdminDao() {
		return jdbcAdminDao;
	}
	public void setJdbcAdminDao(JdbcAdminDAO jdbcAdminDao) {
		this.jdbcAdminDao = jdbcAdminDao;
	}
	
	public String execute() throws Exception {
		jdbcAdminDao = new JdbcAdminDAO();
		System.out.println("product.getProductName() is"+product.getProductName());
		jdbcAdminDao.addProduct(product.getProductName(),product.getDescription(),(float)product.getFixedPrice(),(float)product.getDangPrice());
		return "success";
	}
	
	
	public static void main(String[] args) throws Exception {
		System.out.println("1");
		JdbcAdminDAO jdbcAdminDao = new JdbcAdminDAO();
		jdbcAdminDao.addProduct("123","321",123,123);
	}
}
