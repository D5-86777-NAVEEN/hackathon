import java.sql.SQLException;
import java.util.Scanner;
import com.sunbeam.Dao.LoginDao;
import com.sunbeam.Dao.MenuDao;
import com.sunbeam.Dao.OrdersDao;

public class main {
	
	public static int mainMenu() {
		int choice;
		Scanner sc = new Scanner(System.in);
		System.out.println("0. Exit");
		System.out.println("1. Sign In");
		System.out.println("2. Sign Up");
		choice=sc.nextInt();
		return choice;	
	}
	
	public static int adminMenu() {
		int choice;
		Scanner sc = new Scanner(System.in);
		System.out.println("0. Exit");
		System.out.println("1. Show all orders");
		System.out.println("2. Show order details (for given order id show Pizza & Customer details)");
		System.out.println("3. Sign Out");
		choice=sc.nextInt();
		return choice;	
	}
	
	public static int customerMenu() {
		int choice;
		Scanner sc = new Scanner(System.in);
		System.out.println("0. Exit");
		System.out.println("1. Show Veg Menu");
		System.out.println("2. Show Non-Veg Menu");
		System.out.println("3. Show available sizes (for given Item id)");
		System.out.println("4. Add to cart (for given price id) ");
		System.out.println("5. Show Cart (Pizzas with Size & Price Details)");
		System.out.println("6. Place Order (Save Order in Database for current customer)");
		System.out.println("7. Sign Out");
		choice=sc.nextInt();
		return choice;	
	}

	
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LoginDao p = null;
		MenuDao m = null;
		OrdersDao o = null;
		try {
			p = new LoginDao();
			m = new MenuDao();
			o= new OrdersDao();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		int choice;
		while((choice=mainMenu())!=0) {
			if(choice==1) {
				System.out.print("Enter email :");
				String email = sc.next();
				System.out.print("Enter password :");
				String pass = sc.next();
				int cflag=0;
				cflag=p.checkCustomer(email,pass);
				if(p.checkAdmin(email,pass)) {
					System.out.println("Login successfull as Admin");
					int choice1;
					while((choice1=adminMenu())!=3) {
						if(choice1==1)
							o.Allorders();
						else if(choice1==2)
							o.showOrders();
						else if(choice1==0)
							System.exit(0);
						else
							System.out.println("Enter a Valild Choice");
					}
					
				}
				else if (cflag>0) {
					int choice2;
					while((choice2=customerMenu())!=7) {
						if(choice2==1)
							m.VegPizza();
						else if(choice2==2)
							m.NonVegPizza();
						else if(choice2==3)
							m.pizza_sizes();
						else if(choice2==4)
							o.addCart();
						else if(choice2==5)
							o.showCart();
						else if(choice2==6)
							o.placeOrder(cflag);
						
						else if(choice2==0)
							System.exit(0);
						else
							System.out.println("Enter a Valild Choice");
					}
				}
				
				
			}
			else if(choice==2) {
				p.addCustomer(sc);
			}
			else
				System.out.println("Enter a Valild Choice");
		}
		

	}

}