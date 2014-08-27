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
import org.hibernate.Transaction;

import com.ding.dao.IntroduceDAO;
import com.ding.dao.UserDAO;
import com.ding.pojo.Book;
import com.ding.util.DbUtil;
import com.ding.util.HibernateSessionFactory;

public class JdbcBIntroduceDAO implements IntroduceDAO {
	private static final String findBookId = "select dp.*,db.* from d_product dp join d_book db on(dp.Product_id=db.Product_id) where dp.Product_id=?";
	private SessionFactory sf;

	// setter injection
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	public Book findBookId(int id) throws Exception {

		Session session = sf.openSession();
		Transaction t = session.beginTransaction();

		Book pro = (Book) session.get(Book.class, id);

		t.commit();
		session.close();

		return pro;
	}

	public static void main(String[] args) throws Exception {
		IntroduceDAO dao = new JdbcBIntroduceDAO();
		Book book = dao.findBookId(13);
		System.out.print("book.getAuthor()" + book.getAuthor());
	}

}
