package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dto.CustomerDTO;
import com.exceptions.NoRecordsFoundException;
import com.exceptions.SomethingWentWrongException;

public class CustomerDAOImpl implements CustomerDAO{

	@Override
	public void addCustomer(CustomerDTO customerDto) throws SomethingWentWrongException {
		Connection conn = null;
		try {
			conn = DBUtils.getConnectionToDb(); // connection to database
			
			//prepare the query 
			String query = "insert into customer (firstname , lastname ,username ,password , address, mobile , email) values(?,?,?,?,?,?,?)";
			
			// getting the prepare statement object
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, customerDto.getFirstName());
			ps.setString(2, customerDto.getLastName());
			ps.setString(3, customerDto.getUserName());
			ps.setString(4, customerDto.getPassword());
			ps.setString(5, customerDto.getAddress());
			ps.setString(6, customerDto.getMobile());
			ps.setString(7, customerDto.getEmail());
			
			//executing query
			ps.executeUpdate();
			
		} catch (SQLException | ClassNotFoundException e) {
			throw new SomethingWentWrongException("Unable to create user");
		} finally {
				try {
					DBUtils.closeConnection(conn);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
	}

	@Override
	public void logIn(String userName, String password) throws SomethingWentWrongException, NoRecordsFoundException{
		Connection conn = null;
		try {
			conn = DBUtils.getConnectionToDb();
			String query = "select CustomerId FROM customer WHERE username = ? AND password = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, userName);
			ps.setString(2, password);
			
//			execute query 
			ResultSet rs  = ps.executeQuery();
			if(DBUtils.isResultSetEmpty(rs)) {
				throw new NoRecordsFoundException("No user found with these combination");
			}
			rs.next();
			LoggedInUser.loggedInUserId = rs.getInt("customerid");
			
		} catch (SQLException | ClassNotFoundException e) {
			throw new NoRecordsFoundException("No records found");
		}finally {
			try {
				DBUtils.closeConnection(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
		
	}

}
