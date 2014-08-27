package com.ding.action.admin;

import java.util.ArrayList;
import java.util.List;

import com.ding.dao.impl.JdbcAdminDAO;
import com.ding.pojo.Order;
import com.ding.pojo.Product;

public class ShowProductAction {
	private List<Product> products;
	private int size;//每页显示的数目
	private int page = 1;//当前页面
	private int totalNum = 0 ;// 产品数量总计
	private int maxPage = 1;// 最大页数
	private JdbcAdminDAO jdbcAdminDao;
	
	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}

	public int getMaxPage() {
		return maxPage;
	}

	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}

	public JdbcAdminDAO getJdbcAdminDao() {
		return jdbcAdminDao;
	}

	public void setJdbcAdminDao(JdbcAdminDAO jdbcAdminDao) {
		this.jdbcAdminDao = jdbcAdminDao;
	}

	public String execute() throws Exception {

		jdbcAdminDao = new JdbcAdminDAO();
	
		products = jdbcAdminDao.findAllProduct(5);

		totalNum = jdbcAdminDao.getProductTotalNum();
		this.size=5 ;
		if (totalNum % size == 0) {
			maxPage = totalNum / size;
		} else {
			maxPage = (totalNum / size) + 1;
		}
		return "success";
	}
	
	public List<Product> findpage(int page){
		List<Product> currentProducts = new ArrayList<Product>();
		if((page>this.maxPage)||(page<0)){
			return null;
		}
		
		else {
			 for(int i=(page-1)*this.size;(i<page*this.size)
					 &&(i<products.size());i++){
				 currentProducts.add(products.get(i));
			 }
		}
		this.page=page;
		return currentProducts;
	}
	
	public static void main(String[] args) throws Exception {
		 System.out.println("1");
		 ShowProductAction show = new ShowProductAction();
		 show.execute();
		 List<Product> list1 = show.findpage(1);
		 
		 
		 System.out.println(show.getTotalNum());
		 for(int i=0;(i<show.getSize())&&(list1.get(i)!=null);i++){
			 Product p= list1.get(i);
			 System.out.println("page 1:p.getDescription()"+p.getDescription());
		 }
		
		 List<Product> list2 = show.findpage(2);
		 for(int i=0;(i<show.getSize())&&(list2.get(i)!=null);i++){
			 Product p= list2.get(i);
			 System.out.println("page 2:p.getDescription()"+p.getDescription());
		 }
		 
		 System.out.println("2");
		 System.out.println("3"); 
		 System.out.println("4");
		 System.out.println("5");
	}
}
