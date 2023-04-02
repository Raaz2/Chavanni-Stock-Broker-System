package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.exceptions.SomethingWentWrongException;

public class OrdersDAOImpl implements OrdersDAO {

	@Override
	public void buyStock(int stId, int quan) throws ClassNotFoundException, SQLException {
		Connection conn = null;
		try {
			conn = DBUtils.getConnectionToDb();
			String q = "insert into holding (stId , quantity , cid , totalStockPrice , wid)"
					+ "values(? ,? ,?,(select price from stock where stockid = ?) * ? ,"
					+ "(select wid from wallet where cid = ?))";
			PreparedStatement ps = conn.prepareStatement(q);
			ps.setInt(1, stId);		
			ps.setInt(2, quan);		
			ps.setInt(3, LoggedInUser.loggedInUserId);		
			ps.setInt(4, stId);		
			ps.setInt(5, quan);		
			ps.setInt(6, LoggedInUser.loggedInUserId);		
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
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
	public void addFund(int amount) {
		Connection conn = null;
		try {
			conn = DBUtils.getConnectionToDb();
			String query = " insert into wallet (walletBal , cid) values(? , ?)";
			String q2 = " update wallet set acBal = (acbal - ?) where cid = ?;";
			PreparedStatement ps = conn.prepareStatement(query);
			PreparedStatement ps2 = conn.prepareStatement(q2);
			ps.setInt(1, amount);
			ps.setInt(2, LoggedInUser.loggedInUserId);
			ps.executeUpdate();
			
			ps2.setInt(1, amount);
			ps2.setInt(2, LoggedInUser.loggedInUserId);
			ps2.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
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
	public void sellStock(int stId, int quan) {
		Connection conn = null;
		try {
			conn = DBUtils.getConnectionToDb();
			String q = "update holding set is_sold = 1 where stId = ? and cid = ?";
			PreparedStatement ps = conn.prepareStatement(q);
			ps.setInt(1, stId);		
			ps.setInt(2, LoggedInUser.loggedInUserId);		

			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
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
	public void withdraw(int amount) {
		Connection conn = null;
		try {
			conn = DBUtils.getConnectionToDb();
			String q = " update wallet set walletBal = (walletBal - ? ) , acBal = (acBal + ? ) where cid = ?;";
			PreparedStatement ps = conn.prepareStatement(q);
			ps.setInt(1, amount);		
			ps.setInt(2, amount);		
			ps.setInt(3, LoggedInUser.loggedInUserId);		
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				DBUtils.closeConnection(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	}