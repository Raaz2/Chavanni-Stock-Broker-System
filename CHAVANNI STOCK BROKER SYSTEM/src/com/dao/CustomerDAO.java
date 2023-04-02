package com.dao;

import java.util.List;

import com.dto.CustomerDTO;
import com.exceptions.NoRecordsFoundException;
import com.exceptions.SomethingWentWrongException;

public interface CustomerDAO {

	void addCustomer(CustomerDTO customerDto) throws SomethingWentWrongException;

	 void logIn(String userName, String password) throws SomethingWentWrongException, NoRecordsFoundException;

	List<CustomerDTO> viewAllCustomers() throws NoRecordsFoundException;

	 void deleteCustomer(int id);

}
