package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dto.StockDTO;
import com.dto.StockDTOImpl;
import com.exceptions.SomethingWentWrongException;

public class StockDAOImpl implements StockDAO{

	@Override
	public void addStock(StockDTO stDto) throws SomethingWentWrongException  {
		Connection conn = null;
		try {
			conn = DBUtils.getConnectionToDb(); // connection to database
			
			//prepare the query 
			String query = "insert into stock (stockcompname , price ) values(?,?)";
			
			// getting the prepare statement object
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, stDto.getCompanyName());
			ps.setInt(2, stDto.getPrice());
			
			//executing query
			ps.executeUpdate();
			
		} catch (SQLException | ClassNotFoundException e) {
			throw new SomethingWentWrongException("Unable to add this stock");
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
	public List<StockDTO> viewAllStock() {
		Connection conn = null;
		List<StockDTO> list = new ArrayList<>();
		try {
			conn = DBUtils.getConnectionToDb(); // connection to database
			
			//prepare the query 
			String query = "select * from stock";
			
			// getting the prepare statement object
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt(1);
				String comp = rs.getString(2);
				int quan = rs.getInt(3);
				int price = rs.getInt(4);
				list.add(new StockDTOImpl(id,comp,price));
			}
			
		} catch (SQLException | ClassNotFoundException e) {
			
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
