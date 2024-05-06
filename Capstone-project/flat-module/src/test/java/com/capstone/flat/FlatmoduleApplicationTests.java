package com.capstone.flat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.capstone.flat.entity.Flat;
import com.capstone.flat.entity.FlatAddress;
import com.capstone.flat.exception.FlatNotFoundException;
import com.capstone.flat.repository.FlatRepository;
import com.capstone.flat.service.FlatServiceImpl;

@SpringBootTest(properties = "eureka.client.enabled=false")
public class FlatmoduleApplicationTests {

	@InjectMocks
	private FlatServiceImpl flatService;

	@Mock
	private FlatRepository flatRepository;
	
	@Test
	public void testAddFlat() {

		Flat flat = new Flat();
		FlatAddress flatAddress = new FlatAddress();
		flat.setFlatId(1);
		flat.setCost(12000);
		flat.setAvailability("yes");
		flatAddress.setAddressId(1);
		flatAddress.setHouseNo("b-10");
		flatAddress.setCity("Ranchi");
		flatAddress.setCountry("India");
		flatAddress.setPin(987665);
		flatAddress.setState("Jharkhand");
		flatAddress.setStreet("HEC");

		when(flatRepository.save(flat)).thenReturn(flat);

		Flat savedFlat = flatService.addFlat(flat);

		verify(flatRepository, times(1)).save(flat);

		assertNotNull(savedFlat);

		assertEquals(flat.getAvailability(), savedFlat.getAvailability());
		assertEquals(flat.getCost(), savedFlat.getCost());
		assertEquals(flat.getFlatId(), savedFlat.getFlatId());

	}

	@Test
	public void testViewFlatById() {
		Flat flat = new Flat();
		FlatAddress flatAddress = new FlatAddress();
		flat.setFlatId(1);
		flat.setCost(12000);
		flat.setAvailability("yes");
		flatAddress.setAddressId(1);
		flatAddress.setHouseNo("b-10");
		flatAddress.setCity("Ranchi");
		flatAddress.setCountry("India");
		flatAddress.setPin(987665);
		flatAddress.setState("Jharkhand");
		flatAddress.setStreet("HEC");

		when(flatRepository.findById(1)).thenReturn(Optional.of(flat));
		Flat actualObj = flatService.viewFlatById(1);
		assertEquals("yes", actualObj.getAvailability());
	}

	@Test
	public void testViewAllFlats() {
		Flat flat = new Flat();
		FlatAddress flatAddress = new FlatAddress();
		flat.setFlatId(1);
		flat.setCost(12000);
		flat.setAvailability("yes");
		flatAddress.setAddressId(1);
		flatAddress.setHouseNo("b-10");
		flatAddress.setCity("Ranchi");
		flatAddress.setCountry("India");
		flatAddress.setPin(987665);
		flatAddress.setState("Jharkhand");
		flatAddress.setStreet("HEC");

		Flat flat1 = new Flat();
		FlatAddress flatAddress1 = new FlatAddress();
		flat1.setFlatId(2);
		flat1.setCost(13000);
		flat1.setAvailability("yes");
		flatAddress1.setAddressId(2);
		flatAddress1.setHouseNo("b-20");
		flatAddress1.setCity("Ranchi");
		flatAddress1.setCountry("India");
		flatAddress1.setPin(987665);
		flatAddress1.setState("Jharkhand");
		flatAddress1.setStreet("HEC");		

		List<Flat> flats = new ArrayList<>();
		flats.add(flat);
		flats.add(flat1);

		when(flatRepository.findAll()).thenReturn(flats);

		List<Flat> flatList = flatService.viewAllFlats();
		assertEquals(2, flatList.size());
	}

	@Test
	public void testUpdateFlat() {
		Flat flat = new Flat();
		FlatAddress flatAddress = new FlatAddress();
		flat.setFlatId(1);
		flat.setCost(12000);
		flat.setAvailability("yes");
		flatAddress.setAddressId(1);
		flatAddress.setHouseNo("b-10");
		flatAddress.setCity("Ranchi");
		flatAddress.setCountry("India");
		flatAddress.setPin(987665);
		flatAddress.setState("Jharkhand");
		flatAddress.setStreet("HEC");

		when(flatRepository.findById(1)).thenReturn(Optional.of(flat));
		when(flatRepository.save(flat)).thenReturn(flat);

		flat.setFlatId(1);
		flat.setCost(14000);
		flat.setAvailability("No");
		flatAddress.setAddressId(1);
		flatAddress.setHouseNo("b-10");
		flatAddress.setCity("Ranchi");
		flatAddress.setCountry("India");
		flatAddress.setPin(987665);
		flatAddress.setState("Jharkhand");
		flatAddress.setStreet("HEC");

		Flat updatedFlat = flatService.updateFlat(flat);

		verify(flatRepository, times(1)).findById(1);
		verify(flatRepository, times(1)).save(flat);

		assertEquals(flat, updatedFlat);
		assertEquals("No", updatedFlat.getAvailability());
		assertEquals(14000, updatedFlat.getCost());

	}

	@Test
	public void testUpdateFlatWihException() {
		Flat flat = new Flat();
		FlatAddress flatAddress = new FlatAddress();
		flat.setFlatId(1);
		flat.setCost(12000);
		flat.setAvailability("yes");
		flatAddress.setAddressId(1);
		flatAddress.setHouseNo("b-10");
		flatAddress.setCity("Ranchi");
		flatAddress.setCountry("India");
		flatAddress.setPin(987665);
		flatAddress.setState("Jharkhand");
		flatAddress.setStreet("HEC");

		when(flatRepository.findById(1)).thenReturn(Optional.empty());

		assertThrows(FlatNotFoundException.class, () -> flatService.updateFlat(flat));
		verify(flatRepository, times(1)).findById(1);
		verify(flatRepository, times(0)).save(flat);
	}

	@Test
	public void testDeleteFlat() {
		Flat flat = new Flat();
		FlatAddress flatAddress = new FlatAddress();
		flat.setFlatId(1);
		flat.setCost(12000);
		flat.setAvailability("yes");
		flatAddress.setAddressId(1);
		flatAddress.setHouseNo("b-10");
		flatAddress.setCity("Ranchi");
		flatAddress.setCountry("India");
		flatAddress.setPin(987665);
		flatAddress.setState("Jharkhand");
		flatAddress.setStreet("HEC");

		when(flatRepository.findById(1)).thenReturn(Optional.of(flat));

		doNothing().when(flatRepository).delete(flat);

		flatService.deleteFlat(1);

		verify(flatRepository, times(1)).findById(1);
		verify(flatRepository, times(1)).delete(flat);
	}
	
	@Test
	public void testDeleteFlatWihException() {
		Flat flat = new Flat();
		FlatAddress flatAddress = new FlatAddress();
		flat.setFlatId(1);
		flat.setCost(12000);
		flat.setAvailability("yes");
		flatAddress.setAddressId(1);
		flatAddress.setHouseNo("b-10");
		flatAddress.setCity("Ranchi");
		flatAddress.setCountry("India");
		flatAddress.setPin(987665);
		flatAddress.setState("Jharkhand");
		flatAddress.setStreet("HEC");

		when(flatRepository.findById(1)).thenThrow(new FlatNotFoundException("Flat is not existing with id:100"));

		assertThrows(FlatNotFoundException.class, () -> flatService.deleteFlat(1));

		verify(flatRepository, times(0)).delete(flat);
	}
	
	@Test
	public void testViewAllFlatsByCost() {
	    
	    float cost = 10000; 
	    String availability = "yes";
	    Flat flat1 = new Flat();
	    flat1.setFlatId(1);
	    flat1.setCost(12000);
	    flat1.setAvailability("yes");

	    Flat flat2 = new Flat();
	    flat2.setFlatId(2);
	    flat2.setCost(11000);
	    flat2.setAvailability("yes");

	    List<Flat> flats = new ArrayList<>();
	    flats.add(flat1);
	    flats.add(flat2);

	    when(flatRepository.findByCostAndAvailability(cost, availability)).thenReturn(flats);
	    
	    List<Flat> filteredFlats = flatService.viewAllFlatsByCost(cost, availability);

	    assertEquals(2, filteredFlats.size());
	    assertEquals(flat1, filteredFlats.get(0));
	    assertEquals(flat2, filteredFlats.get(1));
	}

}
