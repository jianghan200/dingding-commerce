package com.ding.action.order;

import java.util.List;

import com.ding.action.BaseAction;
import com.ding.dao.AddressDAO;
import com.ding.dao.ItemDAO;
import com.ding.dao.OrderDAO;
import com.ding.dao.impl.JdbcAddressDAO;
import com.ding.dao.impl.JdbcItemDAO;
import com.ding.dao.impl.JdbcOrderDAO;
import com.ding.pojo.Address;
import com.ding.pojo.CartItem;
import com.ding.pojo.Item;
import com.ding.pojo.Order;
import com.ding.pojo.User;
import com.ding.service.CartService;
import com.ding.util.Constant;

public class AddressAction extends BaseAction {
	// intput
	private String receiveName;
	private String fullAddress;
	private String postalCode;
	private String phone;
	private String mobile;


	private Integer orderNum;

	private double money;
	
	CartService cartService;

	private Order ord = new Order();

	private AddressDAO addressDao;
	public void setAddressDao(AddressDAO addressDao) {
		this.addressDao = addressDao;
	}
	private ItemDAO itemdao ;
	public ItemDAO getItemdao() {
		return itemdao;
	}
	public void setItemdao(ItemDAO itemdao) {
		this.itemdao = itemdao;
	}

	private  OrderDAO orderdao ;
	public OrderDAO getOrderdao() {
		return orderdao;
	}
	public void setOrderdao(OrderDAO orderdao) {
		this.orderdao = orderdao;
	}

	public String execute() throws Exception {
		System.out.println(receiveName);
		System.out.println("地址=" + fullAddress);
		CartService	cartService = (CartService) session.get(Constant.CART_KEY);
		// 插入送货地址
		Address address = new Address();
		User user = (User) session.get("user");
		address.setUser_id(user.getUSER_ID());

		System.out.println("我的1");
		address.setReceive_name(receiveName);
		address.setFull_address(fullAddress);
		address.setPostal_code(postalCode);
		address.setMobile(phone);
		address.setPhone(mobile);
		System.out.println(address.getMobile() + "我的");
		// AddressDAO dao = new JdbcAddressDAO();
		
		System.out.println(address.getMobile() + "我的");
		
		System.out.println("user id is "+user.getUSER_ID());
		System.out.println("fullAddress is "+fullAddress);
		Address add = addressDao.findAdd(user.getUSER_ID(), fullAddress);
		// System.out.print("add"+add) ;
		if (add == null) {
			addressDao.addAll(address);

			System.out.println("地址插入了");

		}
		System.out.println("准备 order");
		// Insert order item into database

		ord.setUser_Id(user.getUSER_ID());
		ord.setStatus(0);
		ord.setOrder_time(System.currentTimeMillis());
		ord.setOrder_desc(user.getEmail());

		System.out.print("dangCost" + cartService.dangCost());
		ord.setTotal_price(cartService.dangCost());
		ord.setReceive_name(receiveName);
		ord.setFull_address(fullAddress);
		ord.setPostal_code(postalCode);
		ord.setMobile(mobile);
		ord.setPhone(phone);
		//OrderDAO orderdao = new JdbcOrderDAO();
		orderdao.addOrder(ord);

		System.out.println("ord.getId()" + ord.getOrder_id());
		// 订单明细信息表d_item
		Item item = null;
		List<CartItem> cartBuy = cartService.getBuyPros();
		//ItemDAO itemdao = new JdbcItemDAO();
		try {
			for (CartItem c : cartBuy) {
				item = new Item();
				item.setOrder_id(ord.getOrder_id());
				item.setProduct_id(c.getPro().getProduct_id());
				item.setPriduct_name(c.getPro().getProductName());
				item.setDang_price(c.getPro().getDangPrice());
				item.setProduct_num(c.getQty());
				item.setAmout(c.getQty() * c.getPro().getDangPrice());
				itemdao.addItem(item);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		orderNum = ord.getOrder_id();

		money = cartService.dangCost();
		// System.out.println(orderNum);
		// System.out.println(money);
		session.remove(Constant.CART_KEY);
		if (session.get(Constant.CART_KEY) == null) {

			System.out.println("Product Info has been removed!");


		}
		return "success";
	}

	public String getReceiveName() {
		return receiveName;
	}

	public String getFullAddress() {
		return fullAddress;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public String getPhone() {
		return phone;
	}

	public String getMobile() {
		return mobile;
	}

	public Integer getOrderNum() {
		return orderNum;
	}

	public double getMoney() {
		return money;
	}

	public void setReceiveName(String receiveName) {
		this.receiveName = receiveName;
	}

	public void setFullAddress(String fullAddress) {
		this.fullAddress = fullAddress;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}

	public void setMoney(double money) {
		this.money = money;
	}

}
