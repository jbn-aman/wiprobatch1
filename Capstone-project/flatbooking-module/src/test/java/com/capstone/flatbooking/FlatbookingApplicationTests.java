package com.capstone.flatbooking;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.capstone.flatbooking.entity.FlatBooking;
import com.capstone.flatbooking.exception.BookingNotFoundException;
import com.capstone.flatbooking.repository.FlatBookingRepository;
import com.capstone.flatbooking.service.FlatBookingServiceImpl;

@SpringBootTest(properties = "eureka.client.enabled=false")
public class FlatbookingApplicationTests {

	@InjectMocks
	private FlatBookingServiceImpl flatBookingService;
	@Mock
	private FlatBookingRepository flatBookingRepository;

	@Test
	public void saveFlatBooking() {

		FlatBooking flatBooking = new FlatBooking();

		flatBooking.setBookingId(1);
		flatBooking.setBookingDate(LocalDate.now());
		flatBooking.setBookingFromDate(LocalDate.of(2024, 05, 06));
		flatBooking.setBookingToDate(LocalDate.of(2026, 11, 24));

		when(flatBookingRepository.save(flatBooking)).thenReturn(flatBooking);

		FlatBooking addedflatBooking = flatBookingService.saveFlatBooking(flatBooking);

		verify(flatBookingRepository, times(1)).save(flatBooking);
		assertEquals(flatBooking, addedflatBooking);
		assertEquals(1, addedflatBooking.getBookingId());
	}

	@Test
	public void getBookingDetails() {
		FlatBooking flatBooking = new FlatBooking();

		flatBooking.setBookingId(1);
		flatBooking.setBookingDate(LocalDate.of(2024, 05, 05));
		flatBooking.setBookingFromDate(LocalDate.of(2024, 06, 01));
		flatBooking.setBookingToDate(LocalDate.of(2025, 05, 15));

		when(flatBookingRepository.findById(1)).thenReturn(Optional.of(flatBooking));
		FlatBooking actualObj = flatBookingService.getBookingDetails(1);
		assertEquals(LocalDate.of(2024, 05, 05), actualObj.getBookingDate());
	}

	@Test
	public void getBookingDetailsWithException() {

		FlatBooking flatBooking = new FlatBooking();

		flatBooking.setBookingId(1);
		flatBooking.setBookingDate(LocalDate.of(2024, 05, 05));
		flatBooking.setBookingFromDate(LocalDate.of(2024, 06, 01));
		flatBooking.setBookingToDate(LocalDate.of(2025, 05, 31));

		when(flatBookingRepository.findById(2))
				.thenThrow(new BookingNotFoundException("Booking is not existing with id:2"));
		assertThrows(BookingNotFoundException.class, () -> flatBookingService.getBookingDetails(11));
	}

	@Test
	public void testViewAllBooking() {

		FlatBooking flatBooking = new FlatBooking();

		flatBooking.setBookingId(1);
		flatBooking.setBookingDate(LocalDate.of(2024, 05, 05));
		flatBooking.setBookingFromDate(LocalDate.of(2024, 06, 01));
		flatBooking.setBookingToDate(LocalDate.of(2025, 05, 31));

		FlatBooking flatBooking1 = new FlatBooking();

		flatBooking.setBookingId(2);
		flatBooking.setBookingDate(LocalDate.of(2024, 05, 05));
		flatBooking.setBookingFromDate(LocalDate.of(2025, 06, 01));
		flatBooking.setBookingToDate(LocalDate.of(2026, 05, 31));

		List<FlatBooking> flatBookings = new ArrayList<>();
		flatBookings.add(flatBooking);
		flatBookings.add(flatBooking1);
		when(flatBookingRepository.findAll()).thenReturn(flatBookings);
		List<FlatBooking> flatBookingList = flatBookingService.getAllBooking();
		assertEquals(2, flatBookingList.size());

	}
	
	@Test
	public void testAcceptBooking() {
	    FlatBooking flatBooking = new FlatBooking();
	    flatBooking.setBookingId(1);
	    flatBooking.setBookingDate(LocalDate.of(2024, 05, 05));
	    flatBooking.setBookingFromDate(LocalDate.of(2024, 06, 01));
	    flatBooking.setBookingToDate(LocalDate.of(2025, 05, 31));
	    when(flatBookingRepository.findById(1)).thenReturn(Optional.of(flatBooking));

	    flatBookingService.acceptBooking(1);

	    verify(flatBookingRepository, times(1)).findById(1);
	    assertEquals("accepted", flatBooking.getBookingStatus());
	}
	
	@Test
	public void testDenyBooking() {
	    FlatBooking flatBooking = new FlatBooking();
	    flatBooking.setBookingId(1);
	    flatBooking.setBookingDate(LocalDate.of(2024, 05, 05));
	    flatBooking.setBookingFromDate(LocalDate.of(2024, 06, 01));
	    flatBooking.setBookingToDate(LocalDate.of(2025, 05, 31));
	    when(flatBookingRepository.findById(1)).thenReturn(Optional.of(flatBooking));

	    flatBookingService.denyBooking(1);

	    verify(flatBookingRepository, times(1)).findById(1);
	    assertEquals("denied", flatBooking.getBookingStatus());
	}
	
	@Test
	public void testViewBookingStatus() {
	    FlatBooking flatBooking = new FlatBooking();
	    flatBooking.setBookingId(1);
	    flatBooking.setBookingDate(LocalDate.of(2024, 05, 05));
	    flatBooking.setBookingFromDate(LocalDate.of(2024, 06, 01));
	    flatBooking.setBookingToDate(LocalDate.of(2025, 05, 31));
	    flatBooking.setBookingStatus("accepted");
	    when(flatBookingRepository.findById(1)).thenReturn(Optional.of(flatBooking));

	    String status = flatBookingService.viewBookingStatus(1);

	    verify(flatBookingRepository, times(1)).findById(1);
	    assertEquals("accepted", status);
	}


	@Test
	public void testDeleteBooking() {

		FlatBooking flatBooking = new FlatBooking();

		flatBooking.setBookingId(1);
		flatBooking.setBookingDate(LocalDate.of(2024, 05, 05));
		flatBooking.setBookingFromDate(LocalDate.of(2024, 06, 01));
		flatBooking.setBookingToDate(LocalDate.of(2025, 05, 31));
		when(flatBookingRepository.findById(1)).thenReturn(Optional.of(flatBooking));
		doNothing().when(flatBookingRepository).delete(flatBooking);

		flatBookingService.deleteBooking(1);
		verify(flatBookingRepository, times(1)).findById(1);
	}

	@Test
	public void testdeleteBookingWithException() {

		FlatBooking flatBooking = new FlatBooking();

		flatBooking.setBookingId(1);
		flatBooking.setBookingDate(LocalDate.of(2024, 05, 05));
		flatBooking.setBookingFromDate(LocalDate.of(2024, 06, 01));
		flatBooking.setBookingToDate(LocalDate.of(2025, 05, 31));

		when(flatBookingRepository.findById(12))
				.thenThrow(new BookingNotFoundException("Booking is not existing with id:12"));
		assertThrows(BookingNotFoundException.class, () -> flatBookingService.deleteBooking(12));
		verify(flatBookingRepository, times(0)).delete(flatBooking);

	}
}