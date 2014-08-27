package com.ding.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ding.dao.ItemDAO;
import com.ding.pojo.Order;
import com.ding.pojo.Item;
import com.ding.pojo.Product;
import com.ding.pojo.User;
import com.ding.util.DbUtil;
import com.ding.util.HibernateSessionFactory;

public class JdbcItemDAO implements ItemDAO {
	/*private static final String addItem = "insert into d_item (order_id,product_id,"+
	"product_name,dang_price,product_num,amount,id) values (?,?,?,?,?,?,?)";
	
	private static final String MAXID = "select max(id) from d_item";*/
	private SessionFactory sf;

	// setter injection
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	public void addItem(Item item) throws SQLException {
		
		Session session = sf.openSession();
		Transaction t=session.beginTransaction();
	//	Order order=(Order)session.load(Order.class,item.getOrder_id()); 
		Product p=(Product)session.get(Product.class,item.getProduct_id()); 
		//item.setOrder(order) ;
		item.setProduct(p) ;
		System.out.print("item.getProduct_id()"+item.getProduct_id());
		session.save(item);
		
		t.commit();
		session.close();
		

	}
	public static void main(String[] args) throws SQLException {
		Item it = new Item();
		it.setId(3);
	  it.setOrder_id(2);
		it.setProduct_id(2);
		it.setPriduct_name("ds");
		it.setAmout(100.0);
		it.setProduct_num(10);
		it.setAmout(100.0);
		ItemDAO dao = new JdbcItemDAO();
		dao.addItem(it);
	}
}
