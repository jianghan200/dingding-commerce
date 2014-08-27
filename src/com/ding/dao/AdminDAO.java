package com.ding.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.SessionFactory;

import com.ding.pojo.Order;
import com.ding.pojo.Item;
import com.ding.pojo.Product;
import com.ding.pojo.User;
import com.ding.pojo.Address;

public interface AdminDAO {
	/**
	 * query products of the category in pages.
	 * @param CatId category Id
	 * @param page number of pages need to be show
	 * @param size number of products in one page
	 * @return
	 * @throws Exception
	 */
	//public List<Product> findByCatId(int CatId,int page, int size)throws Exception;
	//public void addUser(User user) throws SQLException;
	
	public List<User> findAllUser() throws Exception;
	/**hot book
	 * 
	 * @param number
	 * @return
	 * @throws SQLException
	 */
	public int getOrderTotalNum();
	public void setOrderTotalNum(int orderTotalNum);
	public int getUserTotalNum();
	public void setUserTotalNum(int userTotalNum);
	public int getOrderTotalNumByUser();
	public void setOrderTotalNumByUser(int orderTotalNumByUser);
	public void setSf(SessionFactory sf);
	public void addProduct(String product_name,String DESCRIPTION, float fixed_price, float dang_price);
	public void deleteOrder(int number) throws SQLException;
	public List<Product> findAllProduct(int size) throws SQLException;
	public void deleteProduct(int number) throws SQLException;
	public void addUser(User user) throws SQLException;
	public void deleteUser(int number) throws SQLException;
	public List<Order> findAllOrderByUser(int number) throws SQLException;
	public void modifyProduct(int number,String PRODUCT_NAME, String DESCRIPTION,
			double fixed_price, double dang_price) throws SQLException;
    public void modifyOrder(int number, double total_price, String receive_name, 
    		String mobile) throws SQLException;
    public void modifyUser(int user_id, String nickname, String email) 
    		throws SQLException;
    public void modifyNormalUser(int number,String nickname,
    		String  email, String password) throws SQLException;
	public List<Order> findAllOrder() throws SQLException;
	
}
