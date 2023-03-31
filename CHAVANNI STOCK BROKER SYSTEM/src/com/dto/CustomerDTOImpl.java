package com.dto;

public class CustomerDTOImpl implements CustomerDTO{
	private int customerId;
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private String address;
	private String mobile;
	private String email;
	private int isDelete;
	
	CustomerDTOImpl(){}

	public CustomerDTOImpl(int customerId, String firstName, String lastName, String userName, String password,
			String address, String mobile, String email, int isDelete) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.address = address;
		this.mobile = mobile;
		this.email = email;
		this.isDelete = isDelete;
	}
	@Override
	public int getCustomerId() {
		return customerId;
	}
	@Override
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	@Override
	public String getFirstName() {
		return firstName;
	}
	@Override
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	@Override
	public String getLastName() {
		return lastName;
	}
	@Override
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@Override
	public String getUserName() {
		return userName;
	}
	@Override
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Override
	public String getPassword() {
		return password;
	}
	@Override
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String getAddress() {
		return address;
	}
	@Override
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String getMobile() {
		return mobile;
	}
	@Override
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	@Override
	public String getEmail() {
		return email;
	}
	@Override
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public int getIsDelete() {
		return isDelete;
	}
	@Override
	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}

	@Override
	public String toString() {
		return "CustomerDTOImpl [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", userName=" + userName + ", password=" + password + ", address=" + address + ", mobile=" + mobile
				+ ", email=" + email + ", isDelete=" + isDelete + "]";
	};
	
	
}
