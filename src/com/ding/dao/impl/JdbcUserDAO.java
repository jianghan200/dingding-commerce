package com.ding.dao.impl;

import java.sql.SQLException;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ding.dao.UserDAO;
import com.ding.pojo.User;

public class JdbcUserDAO extends HibernateDaoSupport implements UserDAO {

	private static final String TAG = "UserDAO ";

	private SessionFactory sf;

	// setter injection
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	public void save(User user) throws SQLException {
		System.out.println(TAG + " save beach");
		
		Session session = sf.openSession();
		Transaction t = session.beginTransaction();
		session.save(user);
		t.commit();
		sf.close();

	}

	/**
	 * Use hibernate to get user by email
	 */
	public User fiandEmail(String email) throws SQLException {
		System.out.println(TAG + "CS sexy beach");

		Session session = sf.openSession();
		System.out.println(TAG + "CS sexy beach2");
		Transaction t = session.beginTransaction(); // 这里出问题！！
		System.out.println(TAG + "CS sexy beach3");

		Query query = session.createQuery("from User u where u.email='" + email
				+ "'");
		User user = (User) query.uniqueResult();
		t.commit();

		session.close();

		System.out.println("fuck you ");

		return user;

	}

	public User findVerifyCode(int id) throws SQLException {

		Session session = sf.openSession();
		Transaction t = session.beginTransaction();

		User user = (User) session.get(User.class, id);

		t.commit();
		session.close();

		return user;
	}

	// 插入是否通过验证Y/N
	public void addEmailVerify(String is_email_verify, int id)
			throws SQLException {

		Session session = sf.openSession();
		Transaction t = session.beginTransaction();

		User u = (User) session.get(User.class, id);
		u.setEmailVerify(is_email_verify);

		session.update(u);

		t.commit();
		session.close();

	}
	
	
	// 插入是否通过验证Y/N
	public User getUser(int id)
			throws SQLException {

		Session session = sf.openSession();
		Transaction t = session.beginTransaction();

		User u = (User) session.get(User.class, id);
		t.commit();
		session.close();
		
		return u;

	}

	// 更新最后一次登录时间和IP字段信息
	public void updateTimeAndIp(long lastLogiantime, String lastLoginIp,
			String email) throws SQLException {
		User u = fiandEmail(email);

		Session session = sf.openSession();
		Transaction t = session.beginTransaction();

		u.setLastLoginTime(lastLogiantime);
		u.setLastLoginIp(lastLoginIp);
		session.update(u);

		t.commit();

		session.close();

	}

	public static void main(String[] args) throws SQLException {

		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"../applicationContext.xml");
		JdbcUserDAO dao = (JdbcUserDAO) ctx.getBean("JdbcUserDAO");
		User user = new User();
		user.setEmail("123@qq.com");
		user.setPassword("123456");
		user.setUserIntegral(0);
		user.setEmailVerify("Y");
		user.setNickname("zhangsan123");
		user.setLastLoginIp("192.168.0.11");
		dao.save(user);


	}

}