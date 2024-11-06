package com.sunbeam.entities;

public class pizza_orders {
int orderid;
int customerid;
String date;
String status;

public pizza_orders() {

}

public pizza_orders(int orderid, int customerid, String date, String status) {
super();
this.orderid = orderid;
this.customerid = customerid;
this.date = date;
this.status = status;
}

public int getOrderid() {
return orderid;
}

public void setOrderid(int orderid) {
this.orderid = orderid;
}

public int getCustomerid() {
return customerid;
}

public void setCustomerid(int customerid) {
this.customerid = customerid;
}

public String getDate() {
return date;
}

public void setDate(String date) {
this.date = date;
}

public String getStatus() {
return status;
}

public void setStatus(String status) {
this.status = status;
}

@Override
public String toString() {
return "pizza_orders [orderid=" + orderid + ", customerid=" + customerid + ", date=" + date + ", status=" + status
+ "]";
}




}
