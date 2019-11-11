package com.satish.wm.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.satish.wm.models.Customers;
import com.satish.wm.models.Orders;
import com.satish.wm.models.ui.CustomerOrderForm;
import com.satish.wm.models.ui.LoginForm;
import com.satish.wm.repo.ICustomerRepo;
import com.satish.wm.repo.IOrderRepo;

@RestController
@RequestMapping("/wm")
public class HomeController {
	
	@Autowired
	ICustomerRepo iCustomerRepo;
	
	@Autowired
	IOrderRepo iOrderRepo;
	
//	@Value("${spring.user.name}")
//	private String user;
	
	
//	@Value("${spring.user.password}")
//	private String pass;
	
	
	@PostMapping(path = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
	public String checkLogin(@Valid @RequestBody LoginForm loginForm) {
		String isValid = "fail";
		
		if(loginForm.getUser().equalsIgnoreCase("admin") && loginForm.getPass().equals("admin")) {
			return loginForm.getUser();
		}
		return isValid;

	}
	
	@GetMapping(path = "/customers", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Customers>> getAllCustomers() {
		List<Customers> mList = iCustomerRepo.findAll();
		return new ResponseEntity<List<Customers>>(mList, HttpStatus.OK);

	}
	
	@GetMapping(path = "/orders", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Orders>> getAllOrders() {
		List<Orders> mList = iOrderRepo.findAll();
		
		return new ResponseEntity<List<Orders>>(mList, HttpStatus.OK);

	}
	
	@GetMapping(path = "/customers/{customerId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CustomerOrderForm> getAllCustomerById(@PathVariable String customerId) {
		//List<Customers> mList = iCustomerRepo.findAll();
		CustomerOrderForm cof = new CustomerOrderForm();
		Optional<Customers> c = iCustomerRepo.findById(customerId);
		cof.setiCustomers(c.get());
		cof.setiOrdersList(iOrderRepo.findAllByCustomerId(customerId));
		return new ResponseEntity<CustomerOrderForm>(cof, HttpStatus.OK);

	}
	
	
	@DeleteMapping(path = "/customers", produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomerOrderForm deleteCustomers(@Valid @RequestBody CustomerOrderForm customerOrderForm) {
		//List<Customers> mList = iCustomerRepo.findAll();
		Customers  savedCustomers= iCustomerRepo.save(customerOrderForm.getiCustomers());
		customerOrderForm.getiOrdersList().forEach(o -> {
			o.setCustomerId(savedCustomers.getCustomerId());
		});
		iOrderRepo.deleteAll(iOrderRepo.findAllByCustomerId(savedCustomers.getCustomerId()));
		ArrayList<Orders>  ordersList = (ArrayList<Orders>) iOrderRepo.saveAll(customerOrderForm.getiOrdersList());
		return new CustomerOrderForm(savedCustomers,ordersList);
	}
	
	@PostMapping(path = "/customers", produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomerOrderForm saveCustomers(@Valid @RequestBody CustomerOrderForm customerOrderForm) {
		Customers  savedCustomers= iCustomerRepo.save(customerOrderForm.getiCustomers());
		customerOrderForm.getiOrdersList().forEach(o -> {
			o.setCustomerId(savedCustomers.getCustomerId());
			o.setCustomerName(savedCustomers.getFname()+" "+savedCustomers.getLname());
		});
		iOrderRepo.deleteAll(iOrderRepo.findAllByCustomerId(savedCustomers.getCustomerId()));
		ArrayList<Orders>  ordersList = (ArrayList<Orders>) iOrderRepo.saveAll(customerOrderForm.getiOrdersList());
		return new CustomerOrderForm(savedCustomers,ordersList);

	}

}
