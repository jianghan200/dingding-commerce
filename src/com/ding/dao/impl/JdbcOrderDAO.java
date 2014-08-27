package com.ding.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ding.dao.OrderDAO;
import com.ding.pojo.Order;
import com.ding.pojo.User;
import com.ding.util.DbUtil;
import com.ding.util.HibernateSessionFactory;

public  class JdbcOrderDAO implements OrderDAO {
	private static final String addOrder = "insert into d_order (user_id,status,order_time,order_desc,total_price,receive_name,"+
	"full_address,postal_code,mobile,phone,id) values (?,?,?,?,?,?,?,?,?,?,?)";
	private static final String maxid = "select max(id) from d_order";
	private SessionFactory sf;

	// setter injection
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	public void addOrder(Order order) throws SQLException {
	
		
		Session session = sf.openSession();
		Transaction t=session.beginTransaction();
		//session.persist(address);
		User u=(User)session.get(User.class,order.getUser_Id()); 
		order.setUser(u) ;
	
		session.save(order);
		
		t.commit();
		session.close();
		

	}
	public int MaxId() throws SQLException {
		PreparedStatement pst = DbUtil.getConnection().prepareStatement(maxid);
	
		ResultSet rs = pst.executeQuery();
		int maxid=0;
		while(rs.next()){
			maxid=rs.getInt(1) ;
		
		}
		
		return maxid;
	}
	/**
	 * Test the methods in this class
	 * @param args
	 * @throws SQLException
	 */

	public static void main(String[] args) throws SQLException {
		OrderDAO dao = new JdbcOrderDAO();
		Order ord = new Order();
		ord.setUser_Id(1);
		ord.setStatus(2);
		ord.setFull_address("etret");
		ord.setMobile("124435");
		ord.setOrder_desc("sfsdgdg");
		ord.setOrder_time(1234567);
		ord.setPhone("12345678");
		ord.setPostal_code("123456");
		ord.setReceive_name("tc");
		ord.setTotal_price(34);
		dao.addOrder(ord);
	}
}
