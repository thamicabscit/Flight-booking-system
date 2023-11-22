package Admin.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import Admin.pojo.Flight;



@RestController
@RequestMapping("/Admin")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AdminController {
@Autowired
RestTemplate restTemplate;


//For admin to get all the flights	
@GetMapping("/AllFlights")

public  Flight[]  getAllFlights() throws InterruptedException{
	Flight[] objects=restTemplate.getForObject("https://Flight-Search/Search/allFlights", Flight[].class);

	return objects;
	
}

private Flight[] GetAllFlightsFallback() {
	return null;
	
	 
	
	}
//For admin to get all the flights from location to destination

@GetMapping("/find/{departure_location}/{arrival_location}")
//@HystrixCommand(fallbackMethod = "GetFlightFallback")
public Flight[] getFlightByData(@PathVariable("departure_location") String dep_loc,@PathVariable("arrival_location") String arr_loc) throws InterruptedException{
	Flight[] flight=restTemplate.getForObject("https://Flight-Search/Search/find/"+dep_loc+"/"+arr_loc, Flight[].class)	;

	return flight;	
	
}



@GetMapping("/findFlight/{id}")
//@HystrixCommand(fallbackMethod = "GetFlightFallback")
public Flight[] getFlight(@PathVariable("id") int id) throws InterruptedException{
	Flight[] flight=restTemplate.getForObject("https://Flight-Search/Search/findFlight/"+id, Flight[].class)	;

	return flight;	
	
}
private Flight[] GetFlightFallback(String dep_loc,String arr_loc){
	return null;
	 
	
	}

//For admin to add new flight to the list	
//addition of particular  flight 
@PostMapping(value="/addFlights",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
//@HystrixCommand(fallbackMethod = "AddFlightFallback")

public Flight addFlight(@RequestBody Flight flight) throws InterruptedException {
restTemplate.postForObject("https://Flight-Search/Search/addFlights", flight, Flight.class);

return flight;
}

//@PostMapping(value="/addFlightData",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
//public Flight addFlightData(@RequestBody FlightData flight) throws InterruptedException {
//restTemplate.postForObject("https://Flight-Search/Search/addFlightData", flight, Flight.class);
//Thread.sleep(3000);
//return flight;
//
//
//}

private Flight AddFlightFallback(Flight flight){
	return flight ;
	 
	
	}
//For admin to update specific flights	
//updation of particular flight(messaging)
@PutMapping("/updateFlightsData/{id}")
//@HystrixCommand(fallbackMethod = "UpdateFlightFallback")
public Flight update(@RequestBody Flight flight,@PathVariable("id") int id) throws InterruptedException{
	restTemplate.put("https://Flight-Search/Search/updateFlightsData/"+id, flight);

	return flight;
	
}
private String UpdateFlightFallback(Flight flight,int flights_id){
	return "Request fails. It takes long time to response";
	 
	}
@DeleteMapping("/deleteFlight/{id}")
public String deleteFlight(@PathVariable("id")int id) throws InterruptedException
{
	restTemplate.delete("https://Flight-Search/Search/deleteFlight/"+id,Flight[].class);

	return "Deleted successfully"+id;
	
}




}
