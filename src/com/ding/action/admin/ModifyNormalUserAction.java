package com.ding.action.admin;

import com.ding.action.BaseAction;
import com.ding.dao.UserDAO;
import com.ding.dao.impl.JdbcAdminDAO;
import com.ding.pojo.ApiMsg;
import com.ding.pojo.User;

public class ModifyNormalUserAction extends BaseAction{
    private JdbcAdminDAO jdbcAdminDao;
	private String email="";
	private String nickname="";
    private String password="";
    
  //Spring Dependency Injection
  	private UserDAO userDao;
  	public void setUserDao(UserDAO userDao) {
  		this.userDao = userDao;
  	}
    
	private ApiMsg apiMsg = new ApiMsg();

	public ApiMsg getApiMsg() {
		return apiMsg;
	}

	public void setApiMsg(ApiMsg apiMsg) {
		this.apiMsg = apiMsg;
	}
	
    
    private int user_id;
    
    public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}


    public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public JdbcAdminDAO getJdbcAdminDao() {
		return jdbcAdminDao;
	}
	public void setJdbcAdminDao(JdbcAdminDAO jdbcAdminDao) {
		this.jdbcAdminDao = jdbcAdminDao;
	}
	
	public String execute() throws Exception {
		
		System.out.println("1111");
		System.out.println("user_id is "+ user_id);
		System.out.println( "nickname is "+nickname);
		System.out.println("password"+password);
		
		jdbcAdminDao = new JdbcAdminDAO();
		jdbcAdminDao.modifyNormalUser(user_id, nickname, email, password);
		
		apiMsg.setErrorCode(0);
		User oldUser = (User) session.get("user");
		User newUser = userDao.fiandEmail(oldUser.getEmail());
		session.remove("user");
		if (session.get("user") == null&&newUser!=null) {
			session.put("user", newUser);
			System.out.println("user 已更新");
			System.out.println("user nick name"+newUser.getNickname());
			System.out.println("user email"+newUser.getEmail());
			session.put("user", newUser);
		
		}
		
		return "success";
	}
	
	
	public static void main(String[] args) throws Exception {

	}
}
