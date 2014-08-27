package com.ding.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ding.dao.ProductDAO;
import com.ding.dao.impl.JdbcProductDAO;
import com.ding.pojo.CartItem;
import com.ding.pojo.Product;
import com.ding.service.CartService;

public class CartServiceImpl implements CartService {
	private List<CartItem> buyPros = new ArrayList();
	private List<CartItem> delPros = new ArrayList();
    private ProductDAO productDao ;
	
	
	public void setProductDao(ProductDAO productDao)
	{this.productDao=productDao;}

	public boolean add(int pid) throws SQLException  {
		// TODO 将产品对象封装成Item,存入buyPros
		//将商品添加到购物车里
		System.out.println("productDao"+productDao);
		Product p =productDao.findById(pid);
		System.out.println("add product2");
		CartItem item = new CartItem();
		System.out.println("add product3");
		item.setPro(p);
		item.setQty(1);
		System.out.println("add product4");
		for(int i=0;i<buyPros.size();i++){
			CartItem cartItem = buyPros.get(i);
			if(cartItem.getPro().getProduct_id() == pid){
				//商品已经购买过了
				return false;
			}
		}
		System.out.println("add product5");
		//没有购买过。则添加该商品
		buyPros.add(item);
		System.out.println("add product6");
		return true;
	}

	public double dangCost() {
	  // TODO 统计dangdang网的产品金额
		double dangTotal = 0;
	  for(int i=0;i<buyPros.size();i++){
		  CartItem item  = buyPros.get(i);
		  dangTotal +=item.getPro().getDangPrice()*item.getQty();
	  }
	  
	
		return dangTotal;
	}
	public double fixedCost() {
		  // TODO 统计市场价列表的产品金额
			double fixedTotal = 0;
		  for(int i=0;i<buyPros.size();i++){
			  CartItem item  = buyPros.get(i);
			  fixedTotal +=item.getPro().getFixedPrice()*item.getQty();
		  }
		  
		
			return  fixedTotal ;
		}

	public void delete(int pid) {
		// TODO   将Item元素，从buyPros删除，添加到delPros
		for(int i = 0;i<buyPros.size();i++){
			CartItem item = buyPros.get(i);
			if(item.getPro().getProduct_id() == pid){
				delPros.add(item);
				buyPros.remove(item);
				return;
			}
			
		}
	}

	public List<CartItem> getBuyPros() {
		// TODO 返回buyPros集合
		
	
		return buyPros;
	}

	public List<CartItem> getDelPros() {
		// TODO返回delPros集合
		return delPros ;
	}

	public void recovery(int pid) {
		// TODO 将Item元素，从buyPros删除，添加到delPros
		for(int i=0;i<delPros.size();i++){
			CartItem item = delPros.get(i);
			if(item.getPro().getProduct_id()== pid){
				delPros.remove(item);
				buyPros.add(item);
				return;
			}
		}

	}

	public void update(int pid, int pum) {
	    // 将buyPros集合中的Item对象的qty修改为pnum
		for(int i=0;i<buyPros.size();i++){
			CartItem item = buyPros.get(i);
			if(item.getPro().getProduct_id() == pid){
				item.setQty(pum);
				return;
			}
		}

	}
	/**
	 * 将购物车中的商品转换成为一个字符串：1,11；3,8
	 * 表示id为1的商品购买了11件，一次类推
	 */
	public String store(){
		//如果购物车中没有商品，约定返回0
		if(buyPros.size() == 0){
			return "0";
		}
		StringBuffer sb  = new StringBuffer();
		for(int i=0;i<buyPros.size();i++){
			CartItem item = buyPros.get(i);
			sb.append(item.getPro().getProduct_id()+","+item.getQty()+";");
		}
		sb.deleteCharAt(sb.length()-1);
		return sb.toString();
	}
	/**
	 *依据一个字符串(1,11;3,8)
	 * 恢复购物车中的商品
	 */
	public void load(String content){
		//如果content内容为空或者为0，没必要恢复
		if(content == null || content.equals("0")){
			return;
		}
		String[] contents = content.split(";");

		for(int i=0;i<contents.length;i++){
			String contentStr = contents[i];
			String[] itemStr = contentStr.split(",");
			int id = Integer.parseInt(itemStr[0]);
			int qty = Integer.parseInt(itemStr[1]);
			//构造商品条目对象
			CartItem item = new CartItem();
			item.setQty(qty);
			try {
			    Product p = productDao.findById(id);
			    item.setPro(p);
			    //将商品条目对象添加到购物车
			    buyPros.add(item);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
}
