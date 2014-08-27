package com.ding.action.user;
import com.ding.dao.impl.JdbcUserDAO;
import com.ding.pojo.User;




public class UserInfoAction{	
private User user;
private int id=0;//每页显示的数目
private JdbcUserDAO jdbcUserDao;
public void setJdbcUserDao(JdbcUserDAO jdbcUserDao) {
	this.jdbcUserDao = jdbcUserDao;
	}
public String execute() throws Exception {

	jdbcUserDao = new JdbcUserDAO();
	System.out.print( id);
	if(id==0){return "fail"; }
	else{
	user = jdbcUserDao.getUser(id);
	return "success";}
}
public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}
	

}
