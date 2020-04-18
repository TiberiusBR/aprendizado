package er118;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import er118.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YY");
		
		System.out.println("Enter client data: ");
		System.out.println("Name: ");
		String name = sc.nextLine();
		System.out.println("Email: ");
		String email = sc.nextLine();
		System.out.println("Birth Date: ");
		Date bd = sdf.parse(sc.nextLine());
		
		Client client = new Client(name, email, bd);
		
		System.out.println("Enter order data: ");
		System.out.println("Status: ");
		String orderstatus = sc.nextLine();
		System.out.println("How many items to this order? ");
		int qtd = sc.nextInt();
		
		Order order = new Order(OrderStatus.valueOf(orderstatus), client);
		
		for (int i = 1; i <= qtd; i++) {
			System.out.println("Enter #" + i + " item data: ");
			System.out.println("Name: ");
			String nameProduct = sc.next();
			System.out.println("Product Price: ");
			double price = sc.nextDouble();
			Product product = new Product(nameProduct, price);
			System.out.println("Quantity: ");
			int qtdOrder = sc.nextInt();
			OrderItem orderitem = new OrderItem(qtdOrder, price, product);
			order.addItem(orderitem);
		}
		
		System.out.println(order.toString());
		sc.close();
		
	}

}
