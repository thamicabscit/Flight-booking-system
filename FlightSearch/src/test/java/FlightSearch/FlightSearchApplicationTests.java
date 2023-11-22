package FlightSearch;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import FlightSearch.controller.FlightSearchController;
import FlightSearch.pojo.Flight;
import FlightSearch.repository.FlightDataRepository;
import FlightSearch.repository.FlightSearchRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
class FlightSearchApplicationTests {

	@InjectMocks
	private FlightSearchController flightSearchController;

	@Mock
	private FlightSearchRepository flightSearchRepository;

	@Mock
	private FlightDataRepository flightDataRepository;

	@Test
	public void testGetAllFlights() {
		List<Flight> expectedFlights = new ArrayList<>();
		expectedFlights.add(new Flight(1, "flight1", "dep1", "arr1","12:00", "12:29", 0));
		expectedFlights.add(new Flight(2, "flight2", "dep2", "arr2","12:00", "12:29", 0));
		when(flightSearchRepository.findAll()).thenReturn(expectedFlights);

		List<Flight> actualFlights = flightSearchController.getAllFlights();

		assertThat(actualFlights).isEqualTo(expectedFlights);
	}

	@Test
	public void testGetFlightByData() {
		List<Flight> expectedFlights = new ArrayList<>();
		expectedFlights.add(new Flight(1, "flight1", "dep1", "arr1","12:00", "12:29", 0));
		expectedFlights.add(new Flight(2, "flight2", "dep1", "arr2","12:00", "12:29", 0));
		when(flightSearchRepository.findByData("dep1", "arr1")).thenReturn(expectedFlights);

		List<Flight> actualFlights = flightSearchController.getFlightByData("dep1", "arr1");

		assertThat(actualFlights).isEqualTo(expectedFlights);
	}



	@Test
	public void testAddFlight() {
		Flight flight = new Flight(1, "flight1", "dep1", "arr1","12:00", "12:29", 0);
		flightSearchController.addFlight(flight);

		
	}

	@Test
	public void testDeleteFlight() {
		int id = 1;
		flightSearchController.deleteFlight(id);

		
	}

	@Test
	public void testUpdateFlightData() {
		int id = 1;
		Flight flight = new Flight(1, "flight1", "dep1", "arr1","12:00", "12:29", 0);
		when(flightDataRepository.save(flight)).thenReturn(flight);
		Flight updatedFlight = flightSearchController.update(flight, id);

		assertThat(updatedFlight).isEqualTo(flight);
	}

}
