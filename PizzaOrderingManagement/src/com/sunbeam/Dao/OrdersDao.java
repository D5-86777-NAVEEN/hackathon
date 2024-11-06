package com.sunbeam.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.sunbeam.entities.pizza_pricing;
import com.sunbeam.util.DbUtil;

public class OrdersDao {
	List<pizza_pricing> cart=new ArrayList<pizza_pricing>();
	private Connection connection;
	public OrdersDao() throws SQLException {
		connection = DbUtil.getConnection();
	}
	public void Allorders(){
		try(PreparedStatement ps=connection.prepareStatement("select * from PIZZA_ORDERS")){
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				int id=rs.getInt(1);
				int cid=rs.getInt(2);
				String date=rs.getString(3);
				String status=rs.getString(4);
				
				System.out.println(id+" "+cid+" "+date+" "+status);
				
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		}
	public void showOrders(){
		Scanner sc = new Scanner(System.in);
		System.out.println("enter order id you want");
		int a=sc.nextInt();
		try(PreparedStatement ps=connection.prepareStatement("SELECT PIZZA_ITEMS.Name ,PIZZA_CUSTOMERS.Name ,PIZZA_CUSTOMERS.Mobile,PIZZA_CUSTOMERS.Email,PIZZA_CUSTOMERS.Address FROM PIZZA_ITEMS JOIN PIZZA_PRICING ON PIZZA_PRICING.ITEMID = PIZZA_ITEMS.ID JOIN PIZZA_ORDERDETAILS ON PIZZA_PRICING.ID = PIZZA_ORDERDETAILS.PRICEID JOIN PIZZA_ORDERS ON PIZZA_ORDERDETAILS.OrderId = PIZZA_ORDERS.ID JOIN PIZZA_CUSTOMERS ON PIZZA_ORDERS.CustomerId = PIZZA_CUSTOMERS.ID and orderid =?")){
			ps.setInt(1, a);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				String pname=rs.getString(1);
				String cname=rs.getString(2);
				String mob=rs.getString(3);
				String email=rs.getString(4);
				String add=rs.getString(5);

				System.out.println(pname+" "+cname+" "+mob+" "+email+" "+add);
				
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		}
	
	public void addCart()  {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter pizza id you want");
		int a=sc.nextInt();
		try(PreparedStatement ps=connection.prepareStatement("select pizza_pricing.id,sizes,price from pizza_pricing,pizza_items where pizza_items.id=pizza_pricing.itemid and pizza_pricing.id=?")){
			ps.setInt(1, a);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				int id=rs.getInt(1);
				String size=rs.getString(2);
				double price=rs.getDouble(3);
				pizza_pricing p1=new pizza_pricing(id,size,price);
				cart.add(p1);
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void showCart()  {
		for(pizza_pricing p:cart) {
		System.out.println(p);
	}
	}
	public void placeOrder(int id)  {
		int oid=0;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
	    LocalDateTime now = LocalDateTime.now();  
	    System.out.println("Current Date and Time: " + dtf.format(now)); 
	    String s=dtf.format(now);
		String sql="insert into PIZZA_ORDERS(customerId,OrderTime,STATUS)values(?,?,?)";
		try(PreparedStatement ps=connection.prepareStatement(sql)){
			ps.setInt(1, id);
			ps.setString(2,s);
			ps.setString(3,"Pending");	
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try(PreparedStatement ps1=connection.prepareStatement("select id from PIZZA_ORDERS where customerid=? and OrderTime=?")){
			ps1.setInt(1, id);
			ps1.setString(2, s);
			ResultSet rs=ps1.executeQuery();
			while(rs.next()) {
				oid=rs.getInt(1);			
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			for(pizza_pricing ob:cart) {
			String sql1="insert into PIZZA_ORDERDETAILS(Orderid,priceid)values(?,?)";
			try(PreparedStatement ps2=connection.prepareStatement(sql1)){
				ps2.setInt(1, oid);		
				ps2.setInt(2,ob.itemid);
				ps2.execute();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		
		cart.clear();
	}
}
