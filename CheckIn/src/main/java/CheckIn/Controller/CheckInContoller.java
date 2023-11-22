package CheckIn.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import CheckIn.service.EmailService;
import ChekIn.pojo.Booking;
import lombok.Builder;


@RestController
@RequestMapping("/attendee")
@CrossOrigin(origins = "*", maxAge = 3600)
public class CheckInContoller {

	//Rest Template
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	EmailService emailService;
	
	
	
	//Put Booking checkIn=true for  updating the Checked-In status
	
	@PutMapping("/booking/{booking_id}/{mailId}")
	
	/* @HystrixCommand(fallbackMethod = "UpdateBookingFallback") */
	 	public String updateBooking (Booking booking,@PathVariable("booking_id") long pnr,@PathVariable("mailId") String mailId) throws InterruptedException {
		booking.setChecked_in(true);
	restTemplate.put("https://Flight-Booking/FlightBooking/booking/"+pnr+"/"+mailId, booking);
	/* return"Checked In Successfully:"+pnr ; */
	
	return emailService.sendEmail(booking,mailId);
		
	}
	
	
	/*
	 * private String UpdateBookingFallback(Booking booking,long pnr) { return
	 * "Request fails. It takes long time to response"; }
	 */
	 
	
	//Get Booking  for  attendee to fetch data of user from Booking 

	@GetMapping("/BookedFlight/{booking_Id}")
	/*
	 * @HystrixCommand(fallbackMethod = "GetBookingFallback")
	 */	public Booking getBooking(@PathVariable("booking_Id") long booking_id) throws InterruptedException {
	Booking booking=restTemplate.getForObject("https://Flight-Booking/FlightBooking/BookedFlight/"+booking_id, Booking.class);
	
		return booking ;
		
	}
	
	/*
	 * private Booking GetBookingFallback(@PathVariable long booking_id) { return
	 * null;
	 * 
	 * 
	 * }
	 */
}
