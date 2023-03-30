package com.dto;

public class StockDTOImpl implements StockDTO{
	private String companyName;
	private int quantity;
	private int price;
	private int stockId;
	public StockDTOImpl() {}
	public StockDTOImpl(int stockId,String companyName,int price) {
		super();
		this.stockId = stockId;
		this.companyName = companyName;
		this.quantity = 500;
		this.price = price;
	}
	@Override
	public int getStockId() {
		return stockId;
	}
	@Override
	public void setStockId(int stockId) {
		this.stockId = stockId;
	}
	@Override
	public String getCompanyName() {
		return companyName;
	}
	@Override
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	@Override
	public int getQuantity() {
		return quantity;
	}
	@Override
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public int getPrice() {
		return price;
	}
	@Override
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "StockDTOImpl [companyName=" + companyName + ", quantity=" + quantity + ", price=" + price + "]";
	}
	
}
