package com.bah.msd.customerapi.domain;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Event {

	    // Handled through 'auto-boxing'
	    @Id
	    @GeneratedValue
	    private long id; // same as Long

	    private String name;
	    private String time;
	    private String location;
	    private double price;
	    
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getTime() {
			return time;
		}
		public void setTime(String time) {
			this.time = time;
		}
		public String getLocation() {
			return location;
		}
		public void setLocation(String location) {
			this.location = location;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		@Override
		public String toString() {
			return "Events [id=" + id + ", name=" + name + ", time=" + time + ", location=" + location + ", price="
					+ price + "]";
		}



	    


}
