package er118;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import er118.enums.OrderStatus;

public class Order {
	
	private Date moment = new Date();
	private OrderStatus status;
	
	private List<OrderItem> orderItem = new ArrayList<>();
	private Client clients;
	
	public Order() {
		
	}

	public Order(Date moment, OrderStatus status, Client clients) {
		this.moment = moment;
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
		return null;
	}
}
