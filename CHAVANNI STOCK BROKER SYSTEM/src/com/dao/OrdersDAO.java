package com.dao;

import java.sql.SQLException;

public interface OrdersDAO  {

	void buyStock(int stId, int quan) throws ClassNotFoundException, SQLException;

	void addFund(int amount);

	void sellStock(int stId, int quan);

	void withdraw(int amount);

}
