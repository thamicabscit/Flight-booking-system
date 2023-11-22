package ChekIn.pojo;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="flights")
public class Flight {
	@Id
	private int id;
	private String departure_location;
	private String arrival_location;
	private String flightname;
	private String arrival_time;
	private String departure_time;
	private int amount;
	public Flight() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Flight(int id, String departure_location, String arrival_location, String flightname, String arrival_time,
			String departure_time, int amount) {
		super();
		this.id = id;
		this.departure_location = departure_location;
		this.arrival_location = arrival_location;
		this.flightname = flightname;
		this.arrival_time = arrival_time;
		this.departure_time = departure_time;
		this.amount = amount;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDeparture_location() {
		return departure_location;
	}
	public void setDeparture_location(String departure_location) {
		this.departure_location = departure_location;
	}
	public String getArrival_location() {
		return arrival_location;
	}
	public void setArrival_location(String arrival_location) {
		this.arrival_location = arrival_location;
	}
	public String getFlightname() {
		return flightname;
	}
	public void setFlightname(String flightname) {
		this.flightname = flightname;
	}
	public String getArrival_time() {
		return arrival_time;
	}
	public void setArrival_time(String arrival_time) {
		this.arrival_time = arrival_time;
	}
	public String getDeparture_time() {
		return departure_time;
	}
	public void setDeparture_time(String departure_time) {
		this.departure_time = departure_time;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Flight [id=" + id + ", departure_location=" + departure_location + ", arrival_location=" + arrival_location
				+ ", flightname=" + flightname + ", arrival_time=" + arrival_time + ", departure_time=" + departure_time
				+ ", amount=" + amount + "]";
	}
//@Id
//private int id;
//private String departure_location;
//private String arrival_location;
//@DBRef
//private  List<FlightData> flight;
//
//public Flight() {}
//
//
//public Flight(int id, String departure_location, String arrival_location,
//		List<FlightData> flight) {
//	super();
//	this.id = id;
//	this.departure_location = departure_location;
//	this.arrival_location = arrival_location;
//	this.flight = flight;
//}
//public int getId() {
//	return id;
//}
//public void setId(int id) {
//	this.id = id;
//}
//public String getDeparture_location() {
//	return departure_location;
//}
//public void setDeparture_location(String departure_location) {
//	this.departure_location = departure_location;
//}
//public String getArrival_location() {
//	return arrival_location;
//}
//public void setArrival_location(String arrival_location) {
//	this.arrival_location = arrival_location;
//}
//
//public List<FlightData> getFlight() {
//	return flight;
//}
//public void setFlight(List<FlightData> flight) {
//	this.flight = flight;
//}


}
