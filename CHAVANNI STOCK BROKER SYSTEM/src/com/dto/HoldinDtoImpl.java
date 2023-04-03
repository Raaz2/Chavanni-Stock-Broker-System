package com.dto;

public class HoldinDtoImpl implements HoldingDTO {
	private int stId;
	private String compName;
	private int cId;
	private int quan;
	private int wid;
	private int totalstockprice;
	private int isSold;
	public HoldinDtoImpl() {};
	public HoldinDtoImpl(int stId, String compName, int cId, int quan, int wid, int totalstockprice, int isSold) {
		super();
		this.stId = stId;
		this.compName = compName;
		this.cId = cId;
		this.quan = quan;
		this.wid = wid;
		this.totalstockprice = totalstockprice;
		this.isSold = isSold;
	}
	public int getStId() {
		return stId;
	}
	public void setStId(int stId) {
		this.stId = stId;
	}
	public String getCompName() {
		return compName;
	}
	public void setCompName(String compName) {
		this.compName = compName;
	}
	public int getcId() {
		return cId;
	}
	public void setcId(int cId) {
		this.cId = cId;
	}
	public int getQuan() {
		return quan;
	}
	public void setQuan(int quan) {
		this.quan = quan;
	}
	public int getWid() {
		return wid;
	}
	public void setWid(int wid) {
		this.wid = wid;
	}
	public int getTotalstockprice() {
		return totalstockprice;
	}
	public void setTotalstockprice(int totalstockprice) {
		this.totalstockprice = totalstockprice;
	}
	public int getIsSold() {
		return isSold;
	}
	public void setIsSold(int isSold) {
		this.isSold = isSold;
	}
	@Override
	public String toString() {
		return "HoldinDtoImpl [stId=" + stId + ", compName=" + compName + ", cId=" + cId + ", quan=" + quan + ", wid="
				+ wid + ", totalstockprice=" + totalstockprice + ", isSold=" + isSold + "]";
	}
	
}
