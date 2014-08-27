package com.ding.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ding.dao.AdminDAO;
import com.ding.dao.OrderDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;


import org.hibernate.SessionFactory;

import com.ding.dao.BookDAO;
import com.ding.pojo.Book;
import com.ding.pojo.Item;
import com.ding.pojo.Product;
import com.ding.util.DbUtil;
import com.ding.util.HibernateSessionFactory;

import java.sql.SQLException;
import java.util.List;

import com.ding.pojo.Book;
import com.ding.pojo.Order;
import com.ding.pojo.Item;
import com.ding.pojo.Product;
import com.ding.pojo.User;
import com.ding.pojo.Address;
import com.ding.util.DbUtil;
import com.ding.util.EncryptUtil;
import com.ding.util.HibernateSessionFactory;



public class JdbcAdminDAO implements AdminDAO{
	private static final String findAllUser = 
		    "select *"+
		    "from d_user";
	
	private int orderTotalNum = 0 ;// 产品数量总计
	private int userTotalNum = 0 ;// 产品数量总计
	private int productTotalNum = 0 ;// 产品数量总计
	public int getProductTotalNum() {
		return productTotalNum;
	}

	public void setProductTotalNum(int productTotalNum) {
		this.productTotalNum = productTotalNum;
	}



	private int orderTotalNumByUser = 0 ;// 产品数量总计
	
	private static final String findProduct="select * from d_product where d_product.product_id = ?";
	
	private static final String findUser="select * from d_user where d_user.USER_ID = ?";
	
	private static final String findOrder="select * from d_order where d_order.ORDER_ID = ?";
	
	private static final String findAllProduct="select * from  d_product";
	
	private static final String findAllOrder=" select * from  d_order";

	private static final String findAllOrderByUser=" select * from  d_order where d_order.user_id = ?";
	
	private static final String deleteOrder="delete from d_order where d_order.order_id = ?";
	
	private static final String deleteUser="delete from d_user where d_user.user_id = ?";
	
	private static final String deleteProduct="delete from d_product where d_product.product_id = ?";
	
	private static final String addProduct="insert into d_product"
			+ "(product_name,DESCRIPTION,fixed_price,dang_price) values ( ?,?,?,?)";
	
	private static final String addUser="insert into d_user"
			+ "(email,nickname,password) values ( ?,?,?)";
	
	public void addUser(User user) throws SQLException{
		User users = new User();
		user.setNickname(user.getNickname());
		user.setEmail(user.getEmail());
		user.setUSER_ID(user.getUSER_ID());
		user.setPassword(user.getPassword());
		
	}
	
	public int getOrderTotalNum() {
		return orderTotalNum;
	}

	public void setOrderTotalNum(int orderTotalNum) {
		this.orderTotalNum = orderTotalNum;
	}

	public int getUserTotalNum() {
		return userTotalNum;
	}

	public void setUserTotalNum(int userTotalNum) {
		this.userTotalNum = userTotalNum;
	}

	public int getOrderTotalNumByUser() {
		return orderTotalNumByUser;
	}

	public void setOrderTotalNumByUser(int orderTotalNumByUser) {
		this.orderTotalNumByUser = orderTotalNumByUser;
	}

	
	
	private SessionFactory sf;
	
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	
	public List<User> findAllUser() throws Exception{
		/**
		Session session = sf.openSession();
		Transaction t=	session.beginTransaction();
		Query  query=session.createQuery("select u.nickname,u.userIntegral, u.email, u.lastLoginTime "
				+ ",u.USER_ID, u.password ,u.emailVerify ,u.emailVerifyCode, u.lastLoginIp from d_user"
				+ " u where order by u.user_id");
    	query.setFirstResult(0) ;
    	query.setMaxResults(size) ;
		List   p=query.list();//
		List<User> list = new ArrayList<User>();
		for(int i=0;i<p.size();i++){
			Object[] obj=(Object[])p.get(i);
			//pro.setProduct_id(Integer.parseInt(obj[0].toString()));
			//pro.setProductName(obj[1].toString());
			User user = new User();
			user.setNickname(obj[0].toString());
			user.setUserIntegral(Integer.parseInt(obj[1].toString()));
			user.setEmail(obj[2].toString());
			user.setLastLoginTime(Long.valueOf(obj[3].toString()));
			user.setUSER_ID(Integer.parseInt(obj[4].toString()));
			user.setPassword(obj[5].toString());
			user.setEmailVerify(obj[6].toString());
			user.setEmailVerifyCode(obj[7].toString());
			user.setLastLoginIp(obj[8].toString());
			list.add(user);
        	//System.out.println("obj[1].toString()"+obj[1].toString());
		}
		userTotalNum = list.size();
		
		t.commit();
		session.close();

		productTotalNum =list.size(); 
        return list;
    	
		*/
		
		
		PreparedStatement pst = 
				DbUtil.getConnection().prepareStatement(findAllUser);
		ResultSet rs = pst.executeQuery();
		List<User> list = new ArrayList<User>();
		System.out.println("bilibili          ");
		
		while(rs.next()){
			User user = new User();
			user.setNickname(rs.getString("nickname"));
			user.setUserIntegral(rs.getInt("user_integral"));
			user.setEmail(rs.getString("email"));
			user.setLastLoginTime(rs.getLong("last_login_time"));
			user.setUSER_ID(rs.getInt("USER_ID"));
			user.setPassword(rs.getString("password"));
			user.setEmailVerify(rs.getString("is_email_verify"));
			user.setEmailVerifyCode(rs.getString("email_verify_code"));
			user.setLastLoginIp(rs.getString("last_login_ip"));
			list.add(user);
		}
		userTotalNum = list.size();
		
		System.out.println("bilibili          "+userTotalNum);
		return list;
		
	}
	
	public void addUser(String email,String nickname, String password){
		password = EncryptUtil.md5Encrypt(password);
		try {
			PreparedStatement pst = 
					DbUtil.getConnection().prepareStatement(addUser);
			pst.setString(1,email);
			pst.setString(2,nickname);
			pst.setString(3,password);
			pst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		userTotalNum++;
	}
	
	
	public void addProduct(String product_name,String DESCRIPTION, float fixed_price, float dang_price){
		try {
			PreparedStatement pst = 
					DbUtil.getConnection().prepareStatement(addProduct);
			pst.setString(1,product_name);
			pst.setFloat(3,fixed_price);
			pst.setString(2, DESCRIPTION);
			pst.setFloat(4,dang_price);
			pst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		productTotalNum++;
	}
	
	
    public List<Product> findAllProduct(int size) throws SQLException{
    	/**
    	
    	Session session = sf.openSession();
		Transaction t=	session.beginTransaction();
		Query  query=session.createQuery("select p.product_id ,p.productName,p.description,p.addTime"
				+ ",p.fixedPrice,p.dangPrice,p.keywords,p.hasDeleted,p.productPic from d_product p "
				+ "where p.hasDeleted=0  order by p.addTime desc");
    	query.setFirstResult(0) ;
    	query.setMaxResults(size) ;
		List   p=query.list();//
		List<Product> list = new ArrayList<Product>();
		for(int i=0;i<p.size();i++){
			Object[] obj=(Object[])p.get(i);
			Product pro = new Product();
        	pro.setProduct_id(Integer.parseInt(obj[0].toString()));
        	pro.setProductName(obj[1].toString());
        	pro.setDescription(obj[2].toString());
        	pro.setAddTime(Long.valueOf(obj[3].toString()));
        	pro.setFixedPrice(Double.parseDouble(obj[4].toString()));
        	pro.setDangPrice(Double.parseDouble(obj[5].toString()));
        	pro.setKeywords(obj[6].toString());
        	pro.setHasDeleted(Integer.parseInt(obj[7].toString()));
        	pro.setProductPic(obj[8].toString());
        	list.add(pro);
        	System.out.println("obj[1].toString()"+obj[1].toString());
			}
			System.out.println("list"+list);
		
		t.commit();
		session.close();//

		productTotalNum =list.size(); 
        return list;
    	*/
    	
    	
    	PreparedStatement pst = 
				DbUtil.getConnection().prepareStatement(findAllProduct);
		ResultSet rs = pst.executeQuery();
		List<Product> list = new ArrayList<Product>();
		
		
		while(rs.next()){
			Product product = new Product();
			product.setProduct_id(rs.getInt("PRODUCT_ID"));
			//System.out.println("5");
			//System.out.println(" "+rs.getInt("userIntegral"));
     		product.setProductName(rs.getString("PRODUCT_NAME"));
			product.setDescription(rs.getString("DESCRIPTION"));
			product.setAddTime(rs.getLong("add_time"));
			product.setFixedPrice(rs.getDouble("fixed_price"));
			product.setDangPrice(rs.getDouble("dang_price"));
			product.setKeywords(rs.getString("keywords"));
			product.setHasDeleted(rs.getInt("has_deleted"));
			product.setProductPic(rs.getString("product_pic"));
			//product.setItems(rs.get("items"));
			list.add(product);
		}
		productTotalNum =list.size(); 
		return list;
	
	}
	
	
	
	public List<Order> findAllOrder() throws SQLException{
		PreparedStatement pst = 
				DbUtil.getConnection().prepareStatement(findAllOrder);
		ResultSet rs = pst.executeQuery();
		List<Order> list = new ArrayList<Order>();
		while(rs.next()){
			Order order = new Order();
			order.setOrder_id(rs.getInt("order_id"));
			order.setUser_Id(rs.getInt("user_Id"));
			order.setOrder_time(rs.getLong("order_time"));
			order.setOrder_desc(rs.getString("order_desc"));
			order.setTotal_price(rs.getInt("total_price"));
			order.setReceive_name(rs.getString("receive_name"));
			order.setFull_address(rs.getString("full_address"));
			order.setPostal_code(rs.getString("postal_code"));
			order.setMobile(rs.getString("mobile"));
			order.setPhone(rs.getString("phone"));
			list.add(order);
		}
		orderTotalNum =list.size(); 
		return list;
	}
	
	public List<Order> findAllOrderByUser(int number) throws SQLException{
		PreparedStatement pst = 
				DbUtil.getConnection().prepareStatement(findAllOrderByUser);
		pst.setInt(1, number);
		System.out.println("bilibili1 ");
		ResultSet rs = pst.executeQuery();
		System.out.println("bilibili2 ");
		List<Order> list = new ArrayList<Order>();
		System.out.println("bilibili 3");
		while(rs.next()){
			System.out.println("bilibili4 ");
			Order order = new Order();
			order.setOrder_id(rs.getInt("order_id"));
			order.setUser_Id(rs.getInt("user_Id"));
			order.setOrder_time(rs.getLong("order_time"));
			order.setOrder_desc(rs.getString("order_desc"));
			order.setTotal_price(rs.getDouble("total_price"));
			order.setReceive_name(rs.getString("receive_name"));
			order.setFull_address(rs.getString("full_address"));
			order.setPostal_code(rs.getString("postal_code"));
			order.setMobile(rs.getString("mobile"));
			order.setPhone(rs.getString("phone"));
			System.out.println("bilibili5 ");
			list.add(order);
			System.out.println("bilibili 6");
		}
		orderTotalNumByUser=list.size();
		return list;
	}
	
	public void modifyOrder(int number, double total_price, String receive_name, String mobile) throws SQLException{
		PreparedStatement pst = 
				DbUtil.getConnection().prepareStatement(findOrder);
		pst.setInt(1,number);
		System.out.println(number);
		ResultSet rs = pst.executeQuery();
		Order order = new Order();
		while(rs.next()){
			order.setOrder_id(rs.getInt("order_id"));
			order.setUser_Id(rs.getInt("user_Id"));
			order.setOrder_time(rs.getLong("order_time"));
			order.setOrder_desc(rs.getString("order_desc"));
			order.setTotal_price(rs.getDouble("total_price"));
			order.setReceive_name(rs.getString("receive_name"));
			order.setFull_address(rs.getString("full_address"));
			order.setPostal_code(rs.getString("postal_code"));
			order.setMobile(rs.getString("mobile"));
			order.setPhone(rs.getString("phone"));
		}
		if(total_price!=0.){
			order.setTotal_price(total_price);
			//System.out.println(user.getNickname());
		}
		if(!receive_name.equals("")){
			order.setReceive_name(receive_name);
			//System.out.println(user.getEmail());
		}
		if(!mobile.equals("")){
			order.setMobile(mobile);
			//System.out.println(user.getEmail());
		}
		
		pst = DbUtil.getConnection().prepareStatement("update d_order "
				+ "set mobile = ?  where order_id = ?");
		pst.setString(1,order.getMobile());
		pst.setInt(2,number);
		pst.executeUpdate();
		
		
		pst = DbUtil.getConnection().prepareStatement("update d_order "
				+ "set full_address = ?  where order_id = ?");
		pst.setString(1,order.getFull_address());
		pst.setInt(2,number);
		pst.executeUpdate();
		
		pst = DbUtil.getConnection().prepareStatement("update d_order "
				+ "set total_price = ?  where order_id = ?");
		pst.setDouble(1,order.getTotal_price());
		pst.setInt(2,number);
		pst.executeUpdate();
	}
	
    public void modifyUser(int number,String nickname,String  email) throws SQLException{
    	PreparedStatement pst = 
				DbUtil.getConnection().prepareStatement(findUser);
		pst.setInt(1,number);
		System.out.println(number);
		ResultSet rs = pst.executeQuery();
		User user = new User();
		while(rs.next()){
			//user.setNickname(rs.getString("nickname"));
			user.setNickname(rs.getString("nickname"));
			user.setUserIntegral(rs.getInt("user_integral"));
			user.setEmail(rs.getString("email"));
			user.setLastLoginTime(rs.getLong("last_login_time"));
			user.setUSER_ID(rs.getInt("USER_ID"));
			user.setPassword(rs.getString("password"));
			user.setEmailVerify(rs.getString("is_email_verify"));
			user.setEmailVerifyCode(rs.getString("email_verify_code"));
			user.setLastLoginIp(rs.getString("last_login_ip"));
		}
		if(!nickname.equals("")){
			user.setNickname(nickname);
			System.out.println(user.getNickname());
		}
		if(!email.equals("")){
			user.setEmail(email);
			System.out.println(user.getEmail());
		}
		pst = DbUtil.getConnection().prepareStatement("update d_user "
				+ "set d_user.nickname = ?  where user_id = ?");
		pst.setString(1,user.getNickname());
		pst.setInt(2,number);
		pst.executeUpdate();
		
		
		pst = DbUtil.getConnection().prepareStatement("update d_user "
				+ "set d_user.email = ?  where user_id = ?");
		pst.setString(1,user.getEmail());
		pst.setInt(2,number);
		pst.executeUpdate();
	}
	
    public void modifyNormalUser(int number,String nickname,String  email, String password) throws SQLException{
    	PreparedStatement pst = 
				DbUtil.getConnection().prepareStatement(findUser);
		pst.setInt(1,number);
		System.out.println(number);
		ResultSet rs = pst.executeQuery();
		User user = new User();
		while(rs.next()){
			//user.setNickname(rs.getString("nickname"));
			user.setNickname(rs.getString("nickname"));
			user.setUserIntegral(rs.getInt("user_integral"));
			user.setEmail(rs.getString("email"));
			user.setLastLoginTime(rs.getLong("last_login_time"));
			user.setUSER_ID(rs.getInt("USER_ID"));
			user.setPassword(rs.getString("password"));
			user.setEmailVerify(rs.getString("is_email_verify"));
			user.setEmailVerifyCode(rs.getString("email_verify_code"));
			user.setLastLoginIp(rs.getString("last_login_ip"));
		}
		if(!nickname.equals("")){
			user.setNickname(nickname);
			System.out.println(user.getNickname());
		}
		
		if(!password.equals("")){
			password = EncryptUtil.md5Encrypt(password);
			user.setPassword(password);
			//System.out.println(user.getNickname());
		}
		
		
		if(!email.equals("")){
			user.setEmail(email);
			System.out.println(user.getEmail());
		}
		pst = DbUtil.getConnection().prepareStatement("update d_user "
				+ "set d_user.nickname = ?  where user_id = ?");
		pst.setString(1,user.getNickname());
		pst.setInt(2,number);
		pst.executeUpdate();
		
		
		pst = DbUtil.getConnection().prepareStatement("update d_user "
				+ "set d_user.password = ?  where user_id = ?");
		pst.setString(1,user.getPassword());
		pst.setInt(2,number);
		pst.executeUpdate();
		
		pst = DbUtil.getConnection().prepareStatement("update d_user "
				+ "set d_user.email = ?  where user_id = ?");
		pst.setString(1,user.getEmail());
		pst.setInt(2,number);
		pst.executeUpdate();
	}
    
    public void modifyProduct(int number,String PRODUCT_NAME, String DESCRIPTION, double fixed_price, double dang_price) throws SQLException{
    	PreparedStatement pst = 
				DbUtil.getConnection().prepareStatement(findOrder);
		pst.setInt(1,number);
		System.out.println(number);
		ResultSet rs = pst.executeQuery();
		Product product = new Product();
		while(rs.next()){
			product.setProduct_id(rs.getInt("PRODUCT_ID"));
			product.setProductName(rs.getString("PRODUCT_NAME"));
			product.setDescription(rs.getString("DESCRIPTION"));
			product.setAddTime(rs.getLong("add_time"));
			product.setFixedPrice(rs.getDouble("fixed_price"));
			product.setDangPrice(rs.getDouble("dang_price"));
			product.setKeywords(rs.getString("keywords"));
			product.setHasDeleted(rs.getInt("has_deleted"));
			product.setProductPic(rs.getString("product_pic"));
		}
		
		if(PRODUCT_NAME.equals(" ")){
			product.setProductName(PRODUCT_NAME);
			//System.out.println(user.getNickname());
		}
		
		if(!DESCRIPTION.equals(" ")){
			product.setDescription(DESCRIPTION);
			//System.out.println(user.getEmail());
		}
		
		if(fixed_price != 0.){
			product.setFixedPrice(fixed_price);
			//System.out.println(user.getEmail());
		}
		
		if(dang_price!= 0.){
			product.setDangPrice(dang_price);
			//System.out.println(user.getEmail());
		}
		
		pst = DbUtil.getConnection().prepareStatement("update d_product "
				+ "set  PRODUCT_NAME = ?  where order_id = ?");
		pst.setString(1,product.getProductName());
		pst.setInt(2,number);
		pst.executeUpdate();
		
		
		pst = DbUtil.getConnection().prepareStatement("update d_product "
				+ "set DESCRIPTION = ?  where order_id = ?");
		pst.setString(1,product.getDescription());
		pst.setInt(2,number);
		pst.executeUpdate();
		
		pst = DbUtil.getConnection().prepareStatement("update d_product "
				+ "set fix_price = ?  where order_id = ?");
		pst.setDouble(1,product.getFixedPrice());
		pst.setInt(2,number);
		pst.executeUpdate();
		
		pst = DbUtil.getConnection().prepareStatement("update d_product"
				+ "set dang_price = ?  where order_id = ?");
		pst.setDouble(1,product.getDangPrice());
		pst.setInt(2,number);
		pst.executeUpdate();
    }
    
	public void deleteOrder(int number) throws SQLException{
		PreparedStatement pst = 
				DbUtil.getConnection().prepareStatement(deleteOrder);
		pst.setInt(1,number);
		pst.execute();
		pst = DbUtil.getConnection().prepareStatement("update d_order "
				+ "set d_order.order_id = d_order.order_id - 1 where order_id > ?");
		pst.setInt(1,number);
		pst.executeUpdate();
		orderTotalNum--;
	}
	
	public void deleteUser(int number) throws SQLException{
		System.out.println("3");
		PreparedStatement pst = 
				DbUtil.getConnection().prepareStatement(deleteUser);
		pst.setInt(1,number);
		pst.execute();
		System.out.println("4");
		pst = DbUtil.getConnection().prepareStatement("update d_user "
				+ "set d_user.user_id = d_user.user_id - 1 where user_id > ?");
		pst.setInt(1,number);
		pst.executeUpdate();
		userTotalNum--;
	}
	
	public void deleteProduct(int number) throws SQLException{
		PreparedStatement pst = 
				DbUtil.getConnection().prepareStatement(deleteProduct);
		pst.setInt(1,number);
		pst.execute();
		pst = DbUtil.getConnection().prepareStatement("update d_product "
				+ "set d_product.product_id = d_product.product_id - 1 where product_id > ?");
		pst.setInt(1,number);
		pst.executeUpdate();
		productTotalNum--;
	}
	
	public static void main(String[] args) throws Exception {
		 System.out.println("1");
		 JdbcAdminDAO dao = new JdbcAdminDAO();
		 System.out.println("2");
		 List<Order> order = dao.findAllOrder();
		 System.out.println("3");
		 List<User>  user = dao.findAllUser();
		 System.out.println("4");
		 
	
		 dao.modifyUser(1,"789","1wq@qq.com");
		 
		 List<Product>  product = dao.findAllProduct(12);
		 System.out.println("4");
		 
		 for(int i=0;i<product.size();i++){
			 Product p= product.get(i);
			 System.out.println("p.getFixedPrice()"+p.getProductName());
		 }
		 
	
		 
		 System.out.println(order.size());
		 for(int i=0;i<order.size();i++){
			 Order p= order.get(i);
			 System.out.println("p.getMobile"+p.getMobile());
		 }
		 
		 
		 
		 System.out.println(user.size());
		 System.out.println("5");
		 
		 
		 for(int i=0;i<user.size();i++){
			 User p= user.get(i);
			 System.out.println("p.getNickname()"+p.getNickname());
			 
		 }
	}
	
}
