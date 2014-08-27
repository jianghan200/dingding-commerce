package com.ding.action.order;

import java.util.List;

import com.ding.action.BaseAction;
import com.ding.dao.AddressDAO;
import com.ding.pojo.Address;
import com.ding.pojo.User;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;



public class AddressFromAction extends BaseAction {
	
	private static Log log = LogFactory.getLog(AddressFromAction.class);
	// output
	List<Address> address;
	//List<String>  address;
	

	private AddressDAO addressDao;
	
	

	public AddressDAO getAddressDao() {
		return addressDao;
	}

	public void setAddressDao(AddressDAO addressDao) {
		this.addressDao = addressDao;
	}


	public String execute() throws Exception{
		//AddressDAO dao = new JdbcAddressDAO();
		log.info("I am log4j");
		log.debug(address);
		
		System.out.println("AddressFromAction"+addressDao);
		
		User user = (User) session.get("user");

		System.out.println("AddressFromAction"+user);
	    

		address =addressDao.findAddById(user.getUSER_ID());	

	    System.out.println("2address"+address);

		return "success";
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

}
