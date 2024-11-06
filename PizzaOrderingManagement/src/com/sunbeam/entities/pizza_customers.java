package com.sunbeam.entities;

import java.util.Scanner;

public class pizza_customers {
String name;
String password;
String mobile;
String Address;
String email;

public pizza_customers() {

}

public pizza_customers(String name, String password, String mobile, String address, String email) {
super();
this.name = name;
this.password = password;
this.mobile = mobile;
Address = address;
this.email = email;
}



public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public String getPassword() {
return password;
}

public void setPassword(String password) {
this.password = password;
}

public String getMobile() {
return mobile;
}

public void setMobile(String mobile) {
this.mobile = mobile;
}

public String getAddress() {
return Address;
}

public void setAddress(String address) {
Address = address;
}

public String getEmail() {
return email;
}

public void setEmail(String email) {
this.email = email;
}

@Override
public String toString() {
return "pizza_customers [name=" + name + ", password=" + password + ", mobile=" + mobile
+ ", Address=" + Address + ", email=" + email + "]";
}
public void accept(Scanner sc) {
System.out.println("Enter name: ");
name =sc.nextLine();
System.out.println("Enter Email:");
email=sc.nextLine();
System.out.println("Enter password:");
password = sc.nextLine();
System.out.println("Enter mobile number:");
mobile=sc.nextLine();
System.out.println("Enter Address:");
Address=sc.nextLine();
}


}
