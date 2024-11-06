package com.sunbeam.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.sunbeam.util.DbUtil;

public class MenuDao {
	private Connection connection;
	public MenuDao() throws SQLException {
		connection = DbUtil.getConnection();
	}
	public  void VegPizza()  {
		
		try(PreparedStatement ps=connection.prepareStatement("select * from PIZZA_ITEMS")){
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				int id=rs.getInt(1);
				String pizza_name=rs.getString(2);
				String type=rs.getString(3);
				String category=rs.getString(4);
				String toppings=rs.getString(5);
				if(type.equals("Veg")) {
				System.out.println(id+" "+pizza_name+" "+type+" "+category+" "+toppings);
				}
		}
		} catch (SQLException e) {
				e.printStackTrace();
		}
	}
	public void NonVegPizza(){
		try(PreparedStatement ps=connection.prepareStatement("select * from PIZZA_ITEMS")){
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				int id=rs.getInt(1);
				String pizza_name=rs.getString(2);
				String type=rs.getString(3);
				String category=rs.getString(4);
				String toppings=rs.getString(5);
				if(type.equals("NonVeg")) {
				System.out.println(id+" "+pizza_name+" "+type+" "+category+" "+toppings);
				}
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		}
	
	public void pizza_sizes()  {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter pizza id you want");
		int a=sc.nextInt();
		try(PreparedStatement ps=connection.prepareStatement("select pizza_pricing.id , sizes,price from pizza_pricing , pizza_items where pizza_items.id=itemid and itemid=?")){
			ps.setInt(1, a);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				int id=rs.getInt(1);
				String size=rs.getString(2);
				double price=rs.getDouble(3);
				System.out.println(id+" "+size+" "+price);

		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
