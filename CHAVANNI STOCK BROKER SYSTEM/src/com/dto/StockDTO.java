package com.dto;

public interface StockDTO {
	public String getCompanyName();
	public void setCompanyName(String companyName);
	
	public int getQuantity();
	public void setQuantity(int quantity);
	
	public int getPrice();
	public void setPrice(int price);
	
	int getStockId();
	void setStockId(int stockId);
}
