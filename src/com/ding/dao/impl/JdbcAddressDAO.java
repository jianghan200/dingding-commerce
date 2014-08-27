package com.ding.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ding.dao.AddressDAO;
import com.ding.pojo.Address;
import com.ding.pojo.Product;
import com.ding.pojo.User;
import com.ding.util.DbUtil;
import com.ding.util.HibernateSessionFactory;

public class JdbcAddressDAO implements AddressDAO {

	private static final String maxid = "select max(id) from d_receive_address";
	private SessionFactory sf;

	// setter injection
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	public List<Address> findAddById(int userId) throws SQLException {



	//	Session  	 session=HibernateSessionFactory.getSession();

	Session  	 session=sf.openSession();
	Transaction t = session.beginTransaction();
	List<Address> list;

	

//		Query query = session.createQuery("from Address a where a.user_id="
//				+ userId + "");
		
//		Query query = session.createQuery("select a.full_address from Address a where  a.user_id='"
//				+ userId + "'");


		Query query = session.createQuery("select a.id,a.full_address,a.receive_name,a.postal_code,a.mobile,a.phone from Address a where  a.user_id='"
				+ userId + "'");

		List result = query.list();
	
		t.commit();

		session.close();
		list=new ArrayList<Address>() ;
		for(int i=0;i<result.size();i++){
		
			Object[] obj=(Object[])result.get(i);
			//将查询的数据封装成Product对象
		
			
			Address add = new Address();
			add.setId(Integer.parseInt(obj[0].toString()));
		
			add.setFull_address(obj[1].toString());
			
			add.setReceive_name(obj[2].toString());
			
			add.setPostal_code(obj[3].toString());
			
			add.setMobile(obj[4].toString());
			
			add.setPhone(obj[5].toString());
			
			add.setUser_id(userId);
			
					
			list.add(add);

			System.out.print("list"+list);

		}
		
		
		return list;
	}

	/**
	 * search by user's Id and full address;
	 */
	public Address findAdd(int userId, String fullAddress) throws SQLException {

		Session session = sf.openSession();
		Transaction t = session.beginTransaction();
		
		System.out.println("sf"+sf);
		
//		Query query = session
//				.createQuery("from Address a where a.full_address='"
//						+ fullAddress + "' and a.user_id='" + userId + "'");
		
		Query query = session
				.createQuery("select a.user_id from Address a where a.full_address='"
						+ fullAddress + "' and a.user_id='" + userId + "'");
		
		
		System.out.println("query"+query);
		
//		Address address = (Address) query.uniqueResult();
		Address add =null;
		System.out.println("findAdd"+"begin list result");
		List result = query.list();
		t.commit();
		session.close();
		
		System.out.println("findAdd"+ "result is "+result);
		
		if(result.size()!=0){
			System.out.println("Size is "+result.size());
			add = new Address();
		}else{
			System.out.println("Size is "+result.size());
		}
//		if(result.get(0)!=null){
//			Object[] obj=(Object[])result.get(0);
//			//将查询的数据封装成Product对象
//		
//			add = new Address();
//			add.setId(Integer.parseInt(obj[0].toString()));
//		
//			add.setFull_address(obj[1].toString());
//			
//			add.setReceive_name(obj[2].toString());
//			
//			add.setPostal_code(obj[3].toString());
//			
//			add.setMobile(obj[4].toString());
//			
//			add.setPhone(obj[5].toString());
//		}
		

		

		return add;
	}

	/**
	 * list the information of d_receive_address from database.
	 * 
	 * @return
	 * @throws SQLException
	 */
	public List<Address> findAll() throws SQLException {
		Session session = sf.openSession();
		Transaction t = session.beginTransaction();
		Query query = session.createQuery("from Address");
		List<Address> addList = query.list();

		t.commit();
		session.close();

		return addList;
	}

	/**
	 * add new information on the table d_receive_address.
	 */
	public void addAll(Address address) throws Exception {

		Session session = sf.openSession();
		Transaction t = session.beginTransaction();
		User u = (User) session.get(User.class, address.getUser_id());
		address.setUser(u);

		session.save(address);

		t.commit();
		session.close();

	}

	/**
	 * search by address.
	 * 
	 * @param userId
	 * @return
	 * @throws SQLException
	 */
	public List<String> findByAddress(int userId) throws SQLException {
		List list =null;

	/*	System.out.println("用户" );
		  
		Session session = sf.openSession();
		Transaction t = session.beginTransaction();
		
		
		System.out.println("用户SF�? + sf);
		
		Query query = session
				.createQuery("select a.id,a.full_address from Address a where a.user_id='"
						+ userId + "'");
		List result = query.list();

		t.commit();
		session.close();
		List	list=new ArrayList<Address>() ;
		for(int i=0;i<=result.size();i++){
			Object[] obj=(Object[])result.get(i);
			//将查询的数据封装成Product对象
			
			Address adr = new Address();
				add.setFull_address(s);
			list.add(add);
		

		System.out.println("用户曾用过的地址�? + list.toString());*/

		return list;
	}

	/**
	 * search by id.
	 */
	public Address findById(int id) throws SQLException {
		System.out.println("sfs "  + sf);
		Address add=null;
		Session session = sf.openSession();
		Transaction t = session.beginTransaction();
		t.begin();
		
			Query query = session.createQuery("select a.id,a.full_address,a.receive_name,a.postal_code,a.mobile,a.phone from Address a where  a.id='"
					+ id + "'");
			List result = query.list();
			
				Object[] obj=(Object[])result.get(0);
				//将查询的数据封装成Product对象
			
				add = new Address();
				add.setId(Integer.parseInt(obj[0].toString()));
			
				add.setFull_address(obj[1].toString());
				
				add.setReceive_name(obj[2].toString());
				
				add.setPostal_code(obj[3].toString());
				
				add.setMobile(obj[4].toString());
				
				add.setPhone(obj[5].toString());
				
		//Query query = session
			//	.createQuery("from Address a  where a.id='"+id+"'") ;
		
		//Object add1=query.uniqueResult();
	//	Address add = (Address) session.get(Address.class,id);
		System.out.println("JdbcAddressDAO:findById "  + "I am ok so far2");
		
		
		
		t.commit();
		System.out.println("address "  + result);
		session.close();
	
		return add;
	}

	public int MaxId() throws SQLException {
		PreparedStatement pst = DbUtil.getConnection().prepareStatement(maxid);

		ResultSet rs = pst.executeQuery();
		int maxid = 0;
		while (rs.next()) {
			maxid = rs.getInt(1);

		}

		return maxid;
	}

	/**
	 * this main method is used to test this class.
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		AddressDAO dao = new JdbcAddressDAO();

		Address add = new Address();
		add.setUser_id(1);
		add.setReceive_name("name");
		add.setFull_address("123");
		add.setPostal_code("123456");
		List<Address>  list=	dao.findAddById(1);
		
		System.out.print("list"+list);

	}

}
