package com.ms.manageCurrencyConversion;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
public class OrderController {
	
	@Autowired
	OrderRepository orderRepo;
	
	@Autowired
	AuditLogRepository audiRepo;
	
	@Autowired
	JwtUtil jwtUtil;

	@GetMapping(path="/orderms/add/{itemName}/{quantity}", produces = "application/json")
	public Integer addConversionFactor(@PathVariable String itemName, @PathVariable Double quantity) {
		Order order = new Order();
		order.setItem(itemName);
		order.setQuantity(quantity);
		order = orderRepo.save(order);
		return order.getId();
	}
	
	@GetMapping(path="/orderms/add/{itemName}/{quantity}/{userToken}", produces = "application/json")
	public String addConversionFactor(@PathVariable String itemName, @PathVariable Double quantity, 
			@PathVariable String userToken) {
		if(userToken != null) {
			System.out.println("userToken"+userToken);
			String[] strArr = userToken.split(":TTL:");
			String dateTokenCreated = strArr[1];
			if(dateTokenCreated != null) {
				SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
				Date date1;
				try {
					date1 = format.parse(dateTokenCreated);
					Date date2 = format.parse(LocalTime.now().toString());
					long difference = date2.getTime() - date1.getTime();
					if(difference > 60000) {
						return "Please authenticate yourself.<button onClick=\"logout()\">Navigate to Login Page</button>";
					}
					System.out.println("difference="+difference);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		Order order = new Order();
		order.setItem(itemName);
		order.setQuantity(quantity);
		order = orderRepo.save(order);
		return "Your order has been placed successfully with Order Id :" + order.getId();
	}
	
	@GetMapping(path="/orderms/add/{itemName}/{quantity}/{userToken}/{txnToken}", produces = "application/json")
	public String placeOrder(@PathVariable String itemName, @PathVariable Double quantity, 
			@PathVariable String userToken, @PathVariable String txnToken) {
		System.out.println("placeOrder");
		System.out.println("txnToken"+txnToken);
		if(userToken != null) {
			System.out.println("userToken"+userToken);
			String[] strArr = userToken.split(":TTL:");
			String dateTokenCreated = strArr[1];
			if(dateTokenCreated != null) {
				SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
				Date date1;
				try {
					date1 = format.parse(dateTokenCreated);
					Date date2 = format.parse(LocalTime.now().toString());
					long difference = date2.getTime() - date1.getTime();
					if(difference > 60000) {
						return "Please authenticate yourself.<button onClick=\"logout()\">Navigate to Login Page</button>";
					}
					System.out.println("difference="+difference);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		Order order = new Order();
		order.setItem(itemName);
		order.setQuantity(quantity);
		order = orderRepo.save(order);
		
		String svcToken = jwtUtil.generateToken("");
		AuditLog auditLog = new AuditLog();
		try {
			auditLog.setUserToken(new javax.sql.rowset.serial.SerialClob(userToken.toCharArray()));
		} catch (SerialException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		auditLog.setTxnToken(txnToken);
		auditLog.setServiceToken(svcToken);
		auditLog.setOrderId(order.getId());
		auditLog = audiRepo.save(auditLog);
		System.out.println("auditLog Id="+auditLog.getId());
		
		return "Your order has been placed successfully with Order Id :" + order.getId();
	}
	
	@GetMapping(path="/orderms/orders", produces = "application/json")
	public List<Order> getAllOrders() {
		return orderRepo.findAll();
	}
	
	@PostMapping(path="/orderms/add")
	public HttpStatus addConversionFactorPost(@RequestBody Order order) {
		Order orderNew = orderRepo.save(order);
		return HttpStatus.CREATED;
	}
}
