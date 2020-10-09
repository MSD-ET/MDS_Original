package com.bah.msd.customerapi.domain;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Event {

//	id: 100, code: 'CNF001', title: 'All-Java Conference', description: 'Lectures and exhibits
	    @Id
	    @GeneratedValue
	    private long id; // same as Long
	    private String code;
	    private String title;
	    private double description;
	    
	    
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public double getDescription() {
			return description;
		}
		public void setDescription(double description) {
			this.description = description;
		}
		@Override
		public String toString() {
			return "Event [id=" + id + ", code=" + code + ", title=" + title + ", description=" + description + "]";
		}
	  
	    
		



	    


}
