package com.bah.msd.customerapi.domain;

public class Registration {
	
	private Event event;
	private Customer customer;
	
	@Override
	public String toString() {
		return "Registration [event=" + event + ", customer=" + customer + "]";
	}
	public Event getEvent() {
		return event;
	}
	public void setEvent(Event event) {
		this.event = event;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	

}
