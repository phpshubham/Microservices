package com.ms.manageCurrencyConversion;

import java.sql.Clob;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "audit_log")
public class AuditLog {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private Clob userToken;
	
	private String txnToken;
	
	private String serviceToken;
	
	private Integer orderId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Clob getUserToken() {
		return userToken;
	}

	public void setUserToken(Clob userToken) {
		this.userToken = userToken;
	}

	public String getTxnToken() {
		return txnToken;
	}

	public void setTxnToken(String txnToken) {
		this.txnToken = txnToken;
	}

	public String getServiceToken() {
		return serviceToken;
	}

	public void setServiceToken(String serviceToken) {
		this.serviceToken = serviceToken;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	
	
}
