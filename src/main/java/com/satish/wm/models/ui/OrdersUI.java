package com.satish.wm.models.ui;

import java.util.Date;

public class OrdersUI {
	private String orderId;
	private String customerId;
	private String customerName;
	private String orderType;
	private Date orderDate;
	private Date deliveryDate;
	private Integer quantity;
	private Double perPrice;
	private Double discount;
	private Double total;
	private Double payment;
	private Double balance;
	private String note;
	private String orderStatus;
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public Date getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Double getPerPrice() {
		return perPrice;
	}
	public void setPerPrice(Double perPrice) {
		this.perPrice = perPrice;
	}
	public Double getDiscount() {
		return discount;
	}
	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public Double getPayment() {
		return payment;
	}
	public void setPayment(Double payment) {
		this.payment = payment;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	
	
}
