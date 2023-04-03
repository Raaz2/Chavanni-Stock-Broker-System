package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.colors.ConsoleColors;
import com.dto.CustomerDTO;
import com.dto.CustomerDTOImpl;
import com.dto.HoldinDtoImpl;
import com.dto.HoldingDTO;
import com.dto.StockDTO;
import com.dto.StockDTOImpl;
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
			String query = "select CustomerId FROM customer WHERE username = ? AND password = ? And is_deleted = 0";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, userName);
			ps.setString(2, password);
			
//			execute query 
			ResultSet rs  = ps.executeQuery();
			if(DBUtils.isResultSetEmpty(rs)) {
				System.out.println(ConsoleColors.ANSI_CYAN_BACKGROUND+ConsoleColors.BLACK+"NO user found..."+ConsoleColors.RESET+ConsoleColors.ANSI_RESET);
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

	@Override
	public List<CustomerDTO> viewAllCustomers() throws NoRecordsFoundException  {
		Connection conn = null;
		List<CustomerDTO> list = new ArrayList<>();
		try {
			conn = DBUtils.getConnectionToDb(); // connection to database
			
			//prepare the query 
			String query = " select * from customer where is_deleted = 0;";
			
			// getting the prepare statement object
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			if(DBUtils.isResultSetEmpty(rs)) {
				System.out.println("No records found");
			}
			while(rs.next()) {
				int id = rs.getInt(1);
				String first = rs.getString(2);
				String last = rs.getString(3);
				String user = rs.getString(4);
				String pass = rs.getString(5);
				String add = rs.getString(6);
				String mob = rs.getString(7);
				String email = rs.getString(8);
				int isDel = rs.getInt(9);
				list.add(new CustomerDTOImpl(id,first, last, user, pass, add, mob, email, isDel));
			}
			
		} catch (SQLException | ClassNotFoundException e) {
			throw new NoRecordsFoundException("No records found ");
		} finally {
				try {
					DBUtils.closeConnection(conn);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return list;
	}

	@Override
	public void deleteCustomer(int id) {
		Connection conn = null;
		try {
			conn = DBUtils.getConnectionToDb(); // connection to database
			
			//prepare the query 
			String query = "update customer set is_deleted = 1 where CustomerId = ? ";
			
			// getting the prepare statement object
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			
			//executing query
			ps.executeUpdate();
			
		} catch (SQLException | ClassNotFoundException e) {
			
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
	public List<HoldingDTO> viewHolding() throws NoRecordsFoundException {
			Connection conn = null;
			List<HoldingDTO> list = new ArrayList<>();
			try {
				conn = DBUtils.getConnectionToDb(); // connection to database
				
				//prepare the query 
				String query = " select * from holding where is_Sold = 0;";
				
				// getting the prepare statement object
				PreparedStatement ps = conn.prepareStatement(query);
				ResultSet rs = ps.executeQuery();
				
				if(DBUtils.isResultSetEmpty(rs)) {
					System.out.println("No records found");
				}
				while(rs.next()) {
					int stId = rs.getInt(1);
					String compName = rs.getString(2);
					int cId = rs.getInt(3);
					int quan = rs.getInt(4);
					int wid = rs.getInt(5);
					int totalstockprice = rs.getInt(6);
					int isSold = rs.getInt(7);
					list.add(new HoldinDtoImpl(stId,compName,cId,quan,wid,totalstockprice,isSold));
				}
				
			} catch (SQLException | ClassNotFoundException e) {
				throw new NoRecordsFoundException("No records found ");
			} finally {
					try {
						DBUtils.closeConnection(conn);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
			return list;
	}
	

}
