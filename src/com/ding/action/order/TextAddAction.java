package com.ding.action.order;

import java.sql.SQLException;

import com.ding.dao.AddressDAO;
import com.ding.dao.impl.JdbcAddressDAO;
import com.ding.pojo.Address;

public class TextAddAction {
	// input
	private int id;
	// output
	private Address textAddress;

	private AddressDAO addressDao;

	public void setAddressDao(AddressDAO addressDao) {
		this.addressDao = addressDao;
	}

	public String execute() throws SQLException {

		// AddressDAO dao = new JdbcAddressDAO();
		System.out.println("TextAddAction:execute "  +"id is "+id );
		Address add = addressDao.findById(id);
		System.out.println("TextAddAction:execute "  + "sth wrong in dao");
		textAddress=new Address() ;
		textAddress.setFull_address(add.getFull_address());
		textAddress.setMobile(add.getMobile());
		textAddress.setPhone(add.getPhone());
		textAddress.setPostal_code(add.getPostal_code());
		textAddress.setReceive_name(add.getReceive_name());
		textAddress.setId(add.getId());
		System.out.println("textAddress" + textAddress);

		return "success";
	}

	public int getId() {
		return id;
	}

	public Address getTextAddress() {
		return textAddress;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTextAddress(Address textAddress) {
		this.textAddress = textAddress;
	}

}
