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

import com.ding.dao.BookDAO;
import com.ding.pojo.Book;
import com.ding.pojo.Item;
import com.ding.pojo.Product;
import com.ding.util.DbUtil;
import com.ding.util.HibernateSessionFactory;

public class JdbcBookDAO implements BookDAO{
	private static final String findByCatId = 
	    "select dp.*,db.* "+
	    "from d_category_product dcp "+
	    "join d_product dp on(dcp.product_id=dp.product_id) "+
	    "join d_book db on(dp.product_id=db.product_id) "+
	    "where dcp.cat_id=? ";
	   // + "limit ?,?";
	private static final String findAllBook=" select * from  d_product dp join d_book db on(dp.PRODUCT_ID=db.PRODUCT_ID) order by rand() limit 2";
	
	
	private static final String findHotBook = "select * from(select dp.* from d_item di join "
			+ "d_product dp on(di.product_id=dp.id) order by di.product_num desc) where rownum <= ? ";
    
	
	public static String HOT_SALE="select * from(select di.* from d_product dp join d_item di on " +
	" dp.id=di.product_id where dp.add_time < ?  order by di.product_num desc) where rownum <= ?";
	private SessionFactory sf;

	// setter injection
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}


	public List<Product> findByCatId(int catId, int page, int size)
			throws Exception {
		Session session = sf.openSession();
		org.hibernate.Transaction t=	session.beginTransaction() ;
		t.begin();
		Query query=session.createQuery("select b from Product p join   "
				+ "p.categorys pcp  , Book  b   "
				+ "where  b.product_id=p.product_id and   "
				+ "pcp.cat_id='"+catId+"'") ;
		int begin = (page-1)*size;
	    query.setFirstResult(begin);
		query.setMaxResults(size);
		List<Product>   list=query.list() ;
		
		t.commit() ;
		session.close() ;
		
		

		
		return list;
	}
	//提取编辑推荐的书的信息
	public List<Book> findAll() throws Exception{

		PreparedStatement pst = DbUtil.getConnection().prepareStatement(findAllBook);
		//pst.setInt(1, 2);
		ResultSet rs = pst.executeQuery();
		List<Book> list = new ArrayList<Book>();
		while(rs.next()){
			Book book = new Book();
				book.setProduct_id(rs.getInt("product_id"));
					book.setProductName(rs.getString("product_name"));
			book.setAuthor(rs.getString("author"));
			book.setPublishing(rs.getString("publishing"));
			book.setPublishTime(rs.getDate("publish_time"));
			book.setDescription(rs.getString("description"));
			book.setFixedPrice(rs.getDouble("fixed_price"));
			book.setDangPrice(rs.getDouble("dang_price"));
			book.setProductPic(rs.getString("product_pic"));
			list.add(book);
		}
		return list;
	}
	
	//热销
	public List<Product> findHotBook(int number) throws SQLException {
	
	    List<Product>  list=null;
	    List result=null;
	    Session session = sf.openSession();
		
		try{
		session.beginTransaction().begin() ;
		
	org.hibernate.Query query=session.createQuery("select  dp.product_id, dp.productName, dp.description,dp.addTime, dp.fixedPrice, dp.dangPrice,dp.keywords, dp.hasDeleted, dp.productPic from Item di , "
			+ "Product dp where di.product_id=dp.product_id order by di.product_num desc");
	query.setFirstResult(0) ;
	query.setMaxResults(number) ;
	     result=query.list() ;
	    
		session.beginTransaction().commit() ;
		
		}  catch(Exception ex)
		
		{
			ex.printStackTrace();
			session.beginTransaction().rollback();
		}
		finally{
			
			session.close()	;
		}
		list=new ArrayList<Product>() ;
		for(int i=0;i<result.size();i++)
		{
			Object[] obj=(Object[])result.get(i);
			//将查询的数据封装成Product对象
			System.out.print("obj[2]11"+obj[2]) ;
			Product pro = new Product();
			// 设置dp.*的信息-->d_product表字段
			pro.setProduct_id(Integer.parseInt(obj[0].toString()));
			pro.setProductName(obj[1].toString());
			pro.setDescription(obj[2].toString());
			
			pro.setAddTime(Long.parseLong(obj[3].toString()));
			pro.setFixedPrice(Double.parseDouble(obj[4].toString()));
			pro.setDangPrice(Double.parseDouble(obj[5].toString()));
			pro.setKeywords(obj[6].toString());
			pro.setHasDeleted(Integer.parseInt(obj[7].toString()));
			pro.setProductPic(obj[8].toString());
			
			list.add(pro);
			
			
			
			
		}
		
	
		return list;
	}
	//新书热销
	
	public List<Item> findHotNewBook(long monthTime, int number) throws Exception {
	
		 List<Item>  items=null;
		    List result=null;
		    Session session = sf.openSession();
			
			try{
			session.beginTransaction().begin() ;
			
		org.hibernate.Query query=session.createQuery("select di.id,di.order_id,di.product_id,di.priduct_name,di.dang_price,di.product_num,di.amout from Product dp , Item di " +
		"where dp.product_id=di.product_id and dp.addTime < '"+monthTime+"'  order by di.product_num desc");
		
						
			query.setFirstResult(0) ;
		query.setMaxResults(number) ;
		    result=query.list() ;
	     
			session.beginTransaction().commit() ;
			
			}  catch(Exception ex)
			
			{
				ex.printStackTrace();
				session.beginTransaction().rollback();
			}
			finally{
				
				session.close()	;
			}
			items=new ArrayList<Item>() ;
			for(int i=0;i<result.size();i++)
			{
				Object[] obj=(Object[])result.get(i);
				//将查询的数据封装成Item对象
				Item item = new Item();
				item.setId(Integer.parseInt(obj[0].toString()));
				item.setOrder_id(Integer.parseInt(obj[1].toString()));
				item.setProduct_id(Integer.parseInt(obj[2].toString()));
				item.setPriduct_name(obj[3].toString());
				item.setDang_price(Double.parseDouble(obj[4].toString()));
				item.setProduct_num(Integer.parseInt(obj[5].toString()));
				item.setAmout(Double.parseDouble(obj[6].toString()));
				items.add(item);
				
			}
		
	

			return items;
		}

	
	
	
	public static void main(String[] args) throws Exception {
		 JdbcBookDAO dao = new JdbcBookDAO();
		 long now = System.currentTimeMillis();
		 long monthTime = 30*24*60*1000L;
		 Long lastTime = now-monthTime;
		 List<Item> bookNames = dao.findHotNewBook(lastTime, 9);
		 System.out.println(" bookNames"+bookNames.toString());
			
			for(int i=0;i<bookNames.size();i++)
			
			{   Item p= bookNames.get(i) ;
				
				
				System.out.print("p.getProductName()"+p.getPriduct_name());
			}
	 
	}
}
