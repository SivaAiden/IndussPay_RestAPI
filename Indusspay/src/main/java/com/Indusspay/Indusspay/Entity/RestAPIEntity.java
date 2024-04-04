package com.Indusspay.Indusspay.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class RestAPIEntity {
	
	@Id
	private Long txnId;
	private String customerName;
    private String service;
    private Float amount;
    private Float gst;
    private Float commission;
    
	public Long getTxnId() {
		return txnId;
	}
	public void setTxnId(Long txnId) {
		this.txnId = txnId;
	}
	
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	
	public Float getAmount() {
		return amount;
	}
	public void setAmount(Float amount) {
		this.amount = amount;
	}
	
	public Float getGst() {
		return gst;
	}
	public void setGst(Float gst) {
		this.gst = gst;
	}
	
	public Float getCommission() {
		return commission;
	}
	public void setCommission(Float commission) {
		this.commission = commission;
	}
    
    
}
