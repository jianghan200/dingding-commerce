package com.ding.action.main;

import java.util.List;

import com.ding.action.BaseAction;
import com.ding.dao.BookDAO;
import com.ding.dao.CategoryDAO;
import com.ding.dao.UserDAO;
import com.ding.dao.impl.JdbcBookDAO;
import com.ding.dao.impl.JdbcCategoryDAO;
import com.ding.pojo.Category;
import com.ding.pojo.Product;
import com.ding.service.UserService;

/**
 * in this class， we want to show the information of different kinds book
 * for example sum of different kinds of books.
 * this information will show left of page 
 * in this class, we want to show all information of left column. 
 * @author Team DingLingLing
 */
public class BookListAction extends BaseAction {
	// input
	private Integer cid;// 当前类别ID
	private Integer pid;// 父类别ID
	private int page = 1;// 要显示第几页
	// 属性注入
	private int size;// 一页显示多少条记录
	// output
	private List<Category> cats;// 左侧类别信息
	private List<Product> pros;// 中间类别所包含的产品信息
	private int totalNum = 0;// 产品数量总计
	private int maxPage = 1;// 最大页数
	
	
    private CategoryDAO categoryDao;
    private BookDAO bookDao;


    public void setBookDao(BookDAO bookDao) {
	    this.bookDao = bookDao;
    }


	public void setCategoryDao(CategoryDAO categoryDao) {
		this.categoryDao = categoryDao;
	}



	// 根据input获取output
	public String execute() throws Exception {
		// 根据pid找cats子类别集合

		

		
		
		//CategoryDAO catDao = new JdbcCategoryDAO();
		cats = categoryDao.findByParentId(pid);
		System.out.println("cats:" + cats);

		for (Category c : cats) {
			totalNum += c.getPnum();

		}
		// 根据cid找中间的产品信息
		//BookDAO bookDao = new JdbcBookDAO();
		pros = bookDao.findByCatId(cid, page, size);
		// TODO 根据类别包含的产品数量统计maxPage值
		int num = 0;
		for (Category c : cats) {
			if (c.getCat_id() == cid) {
				// 统计的产品数量，如当代小说是多少？
				num = c.getPnum();
			}
		}
		System.out.println("num:" + num);
		System.out.println("size:" + size);
		// 偶数页

		if (num % size == 0) {
			maxPage = num / size;
		} else {
			maxPage = (num / size) + 1;
		}

		// 进入book_list.jsp显示
		return "success";
	}

	public int getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}

	public List<Category> getCats() {
		return cats;
	}

	public void setCats(List<Category> cats) {
		this.cats = cats;
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public List<Product> getPros() {
		return pros;
	}

	public void setPros(List<Product> pros) {
		this.pros = pros;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getMaxPage() {
		return maxPage;
	}

	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}

}
