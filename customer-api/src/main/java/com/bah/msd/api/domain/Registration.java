package com.bah.msd.api.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//id: 1, event_id: 1, customer_id: 1, registration_date: '2019-01-01', notes: 'looking forward 
@Entity
public class Registration {
	@Id
    @GeneratedValue
	private Long id;
	private Long event_id;
	private Long customer_id;
	private Date registration_date;
	private String notes;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getEvent_id() {
		return event_id;
	}
	public void setEvent_id(Long event_id) {
		this.event_id = event_id;
	}
	public Long getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(Long customer_id) {
		this.customer_id = customer_id;
	}
	public Date getRegistration_date() {
		return registration_date;
	}
	public void setRegistration_date(Date registration_date) {
		this.registration_date = registration_date;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	@Override
	public String toString() {
		return "Registration [id=" + id + ", event_id=" + event_id + ", customer_id=" + customer_id
				+ ", registration_date=" + registration_date + ", notes=" + notes + "]";
	}
	
	
	

}
