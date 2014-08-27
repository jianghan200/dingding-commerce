package com.ding.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ding.dao.CategoryDAO;
import com.ding.pojo.Category;
import com.ding.pojo.Product;
import com.ding.util.DbUtil;
import com.ding.util.HibernateSessionFactory;

public class JdbcCategoryDAO implements CategoryDAO {
	private static final String findAll="select * from d_category"; 
	private static final String findByParentId = 
		  "select dc.cat_id,dc.name,dc.en_name,dc.turn,dc.description,dc.parent_id,count(dcp.product_id) as cnt from d_category dc left outer join d_category_product dcp on(dc.cat_id=dcp.cat_id) where parent_id=? group by dc.cat_id,dc.name,dc.en_name,dc.turn,dc.description,dc.parent_id ";

	private SessionFactory sf;

	// setter injection
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
		public List<Category> findAll() throws Exception {
	
			Session session = sf.openSession();
			session.beginTransaction().begin();
			Query query=session.createQuery("from Category") ;
			List<Category> list=query.list();
			
			session.beginTransaction().commit();
			session.close();
               return list;
	}
	public List<Category> findByParentId(int parentId) throws Exception{
	
		
		
		Session session = sf.openSession();
		session.beginTransaction().begin();
		Query query=session.createQuery("select dc.cat_id,dc.turn,dc.enName,dc.name,dc.description,dc.parentId,count(dcp.product_id) as cnt from Category dc left join dc.products dcp where dc.parentId='"+parentId+"' group by dc.cat_id,dc.turn,dc.enName,dc.name,dc.description,dc.parentId") ;
	
		List Rerult=query.list();
		
		session.beginTransaction().commit();
		session.close();
		List<Category> list = new ArrayList<Category>();
		for(int i=0;i<Rerult.size();i++)
		{    Object[] obj=(Object[])Rerult.get(i);
	
			Category cat = new Category();
			cat.setCat_id(Integer.parseInt(obj[0].toString()));
			cat.setTurn(Integer.parseInt(obj[1].toString()));
			cat.setEnName(obj[2].toString());
			cat.setName(obj[3].toString());
		if(obj[4]!=null)
				cat.setDescription(obj[4].toString());
		else  	cat.setDescription("");
				cat.setParentId(Integer.parseInt(obj[5].toString()));
			//设置统计的产品数量
				cat.setPnum(Integer.parseInt(obj[6].toString()));
			list.add(cat);
		}
		
		return list;
	}
	public static void main(String[] args) throws Exception {
		JdbcCategoryDAO dao = new JdbcCategoryDAO();
	List<Category>  bookNames=dao.findByParentId(2);
			System.out.println(bookNames.toString());
	 
	}
}
