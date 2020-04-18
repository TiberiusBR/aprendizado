package er118;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import er118.enums.OrderStatus;

public class Order {
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
	
	private Date moment = new Date();
	private OrderStatus status;
	
	private List<OrderItem> orderItem = new ArrayList<>();
	private Client clients;
	
	public Order() {
		
	}

	public Order(OrderStatus status, Client clients) {
		this.status = status;
		this.clients = clients;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClients() {
		return clients;
	}

	public void setClients(Client clients) {
		this.clients = clients;
	}

	public List<OrderItem> getOrderItems() {
		return orderItem;
	}
	
	public void addItem (OrderItem orderItems) {
		orderItem.add(orderItems);
	}
	
	public void removeItem (OrderItem orderItems) {
		orderItem.remove(orderItems);
	}
	
	public Double total() {
		double total = 0;
		for (OrderItem o: orderItem) {
			total += o.subTotal();
		}
		return total;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ORDER SUMMARY:\n");
		sb.append("Order moment: " + sdf.format(moment) + "\n");
		sb.append("Order status: " + status + "\n");
		sb.append("Client: " + clients.getName() + 
				" (" +sdf.format(clients.getBirthDate()) + 
				") - " + clients.getEmail() + "\n");
		sb.append("Order items:\n");
		for(OrderItem o: orderItem) {
			sb.append(o.getProducts().getName() 
			+ ", $" + String.format("%.2f", o.getPrice()) 
			+ ", Quantity: " + o.getQuantity() 
			+ ", Subtotal: $" + String.format("%.2f" , o.subTotal()) +"\n");
		}
		sb.append("Total price: $" + String.format("%.2f", total() ));
		return sb.toString();		
	}
}
