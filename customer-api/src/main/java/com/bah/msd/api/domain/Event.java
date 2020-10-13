package com.bah.msd.api.domain;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
//@Table(name = "EVENTS")
public class Event {

	//id: 100, code: 'CNF001', title: 'All-Java Conference', description: 'Lectures and exhibits
    	@Id
    	@GeneratedValue(strategy = GenerationType.IDENTITY)
	    private long id; // same as Long
    	
    	 //@Column(name="EVENT_CODE")
	    private String code;
	    private String title;
	    private String description;
	    
	    
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
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		@Override
		public String toString() {
			return "Event [id=" + id + ", code=" + code + ", title=" + title + ", description=" + description + "]";
		}
	  
	    
		



	    


}
