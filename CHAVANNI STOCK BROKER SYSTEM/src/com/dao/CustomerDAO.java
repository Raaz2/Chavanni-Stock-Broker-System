package com.dao;

import com.dto.CustomerDTO;
import com.exceptions.NoRecordsFoundException;
import com.exceptions.SomethingWentWrongException;

public interface CustomerDAO {

	void addCustomer(CustomerDTO customerDto) throws SomethingWentWrongException;

	 void logIn(String userName, String password) throws SomethingWentWrongException, NoRecordsFoundException;

}
