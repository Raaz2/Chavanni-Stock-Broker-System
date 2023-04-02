package com.dao;

import java.util.List;

import com.dto.StockDTO;
import com.exceptions.NoRecordsFoundException;
import com.exceptions.SomethingWentWrongException;

public interface StockDAO {

	void addStock(StockDTO stDto) throws SomethingWentWrongException;

	List<StockDTO> viewAllStock() throws NoRecordsFoundException;

}
