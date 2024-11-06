package com.sunbeam.entities;

public class pizza_pricing {
public int id;
public int itemid;
String sizes;
double price;

public pizza_pricing() {
}



public pizza_pricing(int itemid, String sizes, double price) {


this.itemid = itemid;
this.sizes = sizes;
this.price = price;
}



public int getItemid() {
return itemid;
}

public void setItemid(int itemid) {
this.itemid = itemid;
}

public String getSizes() {
return sizes;
}

public void setSizes(String sizes) {
this.sizes = sizes;
}

public double getPrice() {
return price;
}

public void setPrice(double price) {
this.price = price;
}

@Override
public String toString() {
return "pizza_pricing [itemid=" + itemid + ", sizes=" + sizes + ", price=" + price + "]";
}



}
