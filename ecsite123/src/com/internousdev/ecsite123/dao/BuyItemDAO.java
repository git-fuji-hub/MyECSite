package com.internousdev.ecsite123.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.internousdev.ecsite123.dto.BuyItemDTO;
import com.internousdev.ecsite123.util.DBConnector;

public class BuyItemDAO {

	public BuyItemDTO getBuyItemInfo(){
		DBConnector dbConnector=new DBConnector();
		Connection connection=dbConnector.getConnection();
		BuyItemDTO buyItemDTO=new BuyItemDTO();

		String sql="SELECT id,item_name,item_price FROM item_info_transaction";

		try{
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();

			if(resultSet.next()){
				buyItemDTO.setId(resultSet.getInt("id"));
				buyItemDTO.setItemName(resultSet.getString("item_name"));
				buyItemDTO.setItemPrice(resultSet.getString("item_price"));
				}
			}catch(Exception e){
				e.printStackTrace();
				}
		return buyItemDTO;
		}
	}