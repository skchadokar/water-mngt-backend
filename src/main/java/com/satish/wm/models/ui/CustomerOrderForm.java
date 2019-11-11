package com.satish.wm.models.ui;

import java.util.ArrayList;

import com.satish.wm.models.Customers;
import com.satish.wm.models.Orders;

public class CustomerOrderForm {

	private Customers iCustomers;
	private ArrayList<Orders> iOrdersList;

	public CustomerOrderForm() {
		// TODO Auto-generated constructor stub
	}

	public CustomerOrderForm(Customers iCustomers, ArrayList<Orders> iOrdersList) {
		super();
		this.iCustomers = iCustomers;
		this.iOrdersList = iOrdersList;
	}

	public Customers getiCustomers() {
		return iCustomers;
	}

	public void setiCustomers(Customers iCustomers) {
		this.iCustomers = iCustomers;
	}

	public ArrayList<Orders> getiOrdersList() {
		return iOrdersList;
	}

	public void setiOrdersList(ArrayList<Orders> iOrdersList) {
		this.iOrdersList = iOrdersList;
	}
}
