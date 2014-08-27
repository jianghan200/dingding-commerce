package com.ding.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ding.dao.ProductDAO;
import com.ding.pojo.Product;
import com.ding.util.HibernateSessionFactory;
/**
 *  Provide the methods of changing the information
 * of table d_product in database.
 * @author Administrator
 *
 */
public class JdbcProductDAO extends HibernateDaoSupport implements ProductDAO{

	
	private  static final String findNewProduct = "select product_id,product_name,description,add_time,fixed_price,dang_price,keywords,has_deleted,product_pic from ("+
		"select product_id,product_name,description,add_time,fixed_price,dang_price,keywords,has_deleted,product_pic,rownum rn from d_product where rownum <= ?)";

		
	private  static final String findById = "select * from d_product where id = ?"; 
	private SessionFactory sf;

	// setter injection
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	public List<Product> findNewProduct(int size) throws SQLException{
		
		Session session = sf.openSession();
		Transaction t=	session.beginTransaction();
	
			Query  query=session.createQuery("select p.product_id ,p.productName,p.description,p.addTime,p.fixedPrice,p.dangPrice,p.keywords,p.hasDeleted,p.productPic from Product p where p.hasDeleted=0  order by p.addTime desc");
	
		
		
	        query.setFirstResult(0) ;
			query.setMaxResults(size) ;
			List   p=query.list();//
		    List<Product> list = new ArrayList<Product>();
			for(int i=0;i<p.size();i++)
			{
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

		
        return list;
    }
    //Product
    public Product findById(int id) throws SQLException{
    	
		System.out.println("Product seesion open 1");
    	Session session = sf.openSession();
    	System.out.println("Product seesion open 2");
	
    	
    	if( session ==null){
    		System.out.println("Fucking session null");
    	}
		Product pro=(Product) session.get(Product.class, id);
		System.out.println("Product seesion open 5");
	
    	return pro;
    }
    public static void main(String[] args) throws SQLException {
    	JdbcProductDAO dao = new JdbcProductDAO();
    	
    	int id =1;
		
    	Session  session= HibernateSessionFactory.getSession();
		Transaction t=session.beginTransaction();
		
		if( session == null){
    		System.out.println("Fucking session null");
    	}
		
		if( session.load(Product.class, id) == null){
    		System.out.println("Fucking session load null");
    	}
		
		if( (Product) session.load(Product.class, id) == null){
    		System.out.println("Fucking session load null");
    	}
		Product pro = (Product) session.load(Product.class, id);
		
		t.commit();
		session.close();
    	
    	
	}
}
