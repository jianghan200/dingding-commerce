package com.ding.dao;

import java.sql.SQLException;
import java.util.List;

import com.ding.pojo.Address;


public interface AddressDAO {
	/**
	 * Add full information of receive address including name,
	 * phone number by address
	 * @param address receive address.
	 * @throws Exception
	 */
	public void addAll(Address address ) throws Exception;

	public Address findById(int id) throws SQLException;
	//find address by id 
	public List<Address> findAddById(int userId) throws SQLException;
	public Address findAdd(int userId,String fullAddress) throws SQLException;
	public List<String> findByAddress(int userId) throws SQLException ;
}
