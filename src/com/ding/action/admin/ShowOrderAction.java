package com.ding.action.admin;

import java.util.ArrayList;
import java.util.List;

import com.ding.dao.impl.JdbcAdminDAO;
import com.ding.pojo.Order;

public class ShowOrderAction {
	private List<Order> orders;
	private int size;//每页显示的数目
	private int page = 1;//当前页面
	private int totalNum = 0 ;// 产品数量总计
	private int maxPage = 1;// 最大页数
	private JdbcAdminDAO jdbcAdminDao;
	
	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
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
		orders = jdbcAdminDao.findAllOrder();
		totalNum = jdbcAdminDao.getOrderTotalNum();
		this.size=5;
		
		if (totalNum % size == 0) {
			maxPage = totalNum / size;
		} else {
			maxPage = (totalNum / size) + 1;
		}
		return "success";
	}
	
	public List<Order> findpage(int page){
		List<Order> currentOrders = new ArrayList<Order>();
		if((page>this.maxPage)||(page<0)){
			return null;
		}
		
		else {
			 for(int i=(page-1)*this.size;(i<page*this.size)
					 &&(i<orders.size());i++){
				 currentOrders.add(orders.get(i));
			 }
		}
		this.page=page;
		return currentOrders;
	}
	
	public static void main(String[] args) throws Exception {
		 System.out.println("1");
		 ShowOrderAction show = new ShowOrderAction();
		 show.execute();
		 List<Order> list1 = show.findpage(1);
		 
		 
		 System.out.println(show.getTotalNum());
		 for(int i=0;(i<show.getSize())&&(list1.get(i)!=null);i++){
			 Order p= list1.get(i);
			 System.out.println("page 1:p.getFull_address()"+p.getFull_address());
		 }
		
		 List<Order> list2 = show.findpage(2);
		 for(int i=0;(i<show.getSize())&&(list2.get(i)!=null);i++){
			 Order p= list2.get(i);
			 System.out.println("page 2:p.getFull_address()"+p.getFull_address());
		 }
		 
		 System.out.println("2");
		 System.out.println("3"); 
		 System.out.println("4");
		 System.out.println("5");
	}
}
