package com.ding.action.admin;

import java.util.ArrayList;
import java.util.List;

import com.ding.dao.impl.JdbcAdminDAO;
import com.ding.pojo.User;

public class ShowUserAction {
	private List<User> users;
	private int size=1;//每页显示的数目
	private int page = 1;//当前页面
	private int totalNum = 0 ;// 产品数量总计
	private int maxPage = 1;// 最大页数
	private JdbcAdminDAO jdbcAdminDao;
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
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
		System.out.println("Size is "+size);
		
		jdbcAdminDao = new JdbcAdminDAO();
		users = jdbcAdminDao.findAllUser();
		totalNum = jdbcAdminDao.getUserTotalNum(); 
		this.size=size;
		
		if (totalNum % size == 0) {
			maxPage = totalNum / size;
		} else {
			maxPage = (totalNum / size) + 1;
		}
		System.out.println("bilibili78 ");
		return "success";
	}
	
	public List<User> findpage(int page){
		List<User> currentUsers = new ArrayList<User>();
		if((page>this.maxPage)||(page<0)){
			return null;
		}
		
		else {
			 for(int i=(page-1)*this.size;(i<page*this.size)
					 &&(i<users.size());i++){
				 currentUsers.add(users.get(i));
			 }
		}
		this.page=page;
		return currentUsers;
	}
	
	public static void main(String[] args) throws Exception {
		 System.out.println("1");
		 ShowUserAction show = new ShowUserAction();
		 show.execute();
		 List<User> list1 = show.findpage(1);
		 
		 System.out.println(show.getTotalNum());
		 for(int i=0;(i<show.getSize())&&(list1.get(i)!=null);i++){
			 User p= list1.get(i);
			 System.out.println("page 1:p.getNickname"+p.getNickname());
		 }
		
		 List<User> list2 = show.findpage(2);
		 for(int i=0;(i<show.getSize())&&(list2.get(i)!=null);i++){
			 User p= list2.get(i);
			 System.out.println("page 2:p.getNickname"+p.getNickname());
		 }
		 
		 System.out.println("2");
		 System.out.println("3"); 
		 System.out.println("4");
		 System.out.println("5");
	}
}
