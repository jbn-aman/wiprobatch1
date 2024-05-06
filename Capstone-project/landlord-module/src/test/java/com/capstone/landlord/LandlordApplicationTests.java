package com.capstone.landlord;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

import com.capstone.landlord.entity.Landlord;
import com.capstone.landlord.exceptions.LandlordNotFoundException;
import com.capstone.landlord.repository.LandlordRepository;
import com.capstone.landlord.service.LandlordServiceImpl;

@SpringBootTest
public class LandlordApplicationTests {
	@InjectMocks
	private LandlordServiceImpl landlordService;
	@Mock
	private LandlordRepository landlordRepository;

	@Test
	public void testviewLandlord() {
		Landlord landlord = new Landlord();
		landlord.setLandlordId(1);
		landlord.setLandlordName("Aman");
		landlord.setLandlordAge(22);
		landlord.setMobileNo("9519131321");
		landlord.setEmail("aman@xyz.com");

		when(landlordRepository.findById(1)).thenReturn(Optional.of(landlord));
		Landlord actualObj = landlordService.viewLandlord(1);
		assertEquals(22, actualObj.getLandlordAge());
	}

	@Test
	public void testViewLandlordException() {

		when(landlordRepository.findById(100))
				.thenThrow(new LandlordNotFoundException("Landlord is not existing with id:200"));
		assertThrows(LandlordNotFoundException.class, () -> landlordService.viewLandlord(200));
	}

	@Test
	public void testViewAllLandlords() {

		Landlord landlord1 = new Landlord();
		landlord1.setLandlordId(1);
		landlord1.setLandlordName("Aman");
		landlord1.setLandlordAge(22);
		landlord1.setMobileNo("9519131321");
		landlord1.setEmail("aman@xyz.com");

		Landlord landlord2 = new Landlord();
		landlord2.setLandlordId(2);
		landlord2.setLandlordName("John");
		landlord2.setLandlordAge(24);
		landlord2.setMobileNo("7418529630");
		landlord2.setEmail("john@xyz.com");

		Landlord landlord3 = new Landlord();
		landlord3.setLandlordId(3);
		landlord3.setLandlordName("Jenny");
		landlord3.setLandlordAge(21);
		landlord3.setMobileNo("7412329630");
		landlord3.setEmail("jenny@xyz.com");

		List<Landlord> landlords = new ArrayList<>();
		landlords.add(landlord1);
		landlords.add(landlord2);
		landlords.add(landlord3);

		when(landlordRepository.findAll()).thenReturn(landlords);

		List<Landlord> landlordList = landlordService.viewAllLandlords();
		assertEquals(3, landlordList.size());

	}

	@Test
	void testDeleteLandlord() {
		Landlord landlord = new Landlord();
		landlord.setLandlordId(111);
		landlord.setLandlordName("Venkat");
		landlord.setLandlordAge(22);
		landlord.setMobileNo("9133134411");

		when(landlordRepository.findById(111)).thenReturn(Optional.of(landlord));
		doNothing().when(landlordRepository).delete(landlord);

		landlordService.deleteLandlord(111);
		;
		verify(landlordRepository, times(1)).findById(111);
		verify(landlordRepository, times(1)).delete(landlord);

	}

	@Test
	void testDeleteLandlordException() {

		Landlord landlord = new Landlord();
		landlord.setLandlordId(1);
		landlord.setLandlordName("Aman");
		landlord.setLandlordAge(22);
		landlord.setMobileNo("9519131321");
		landlord.setEmail("aman@xyz.com");

		when(landlordRepository.findById(111))
				.thenThrow(new LandlordNotFoundException("landlord is not existing with id:111"));
		assertThrows(LandlordNotFoundException.class, () -> landlordService.deleteLandlord(111));
		verify(landlordRepository, times(0)).delete(landlord);

	}

	@Test
	public void testAddLandlord() {
		Landlord landlord = new Landlord();
		landlord.setLandlordName("Venkat");
		landlord.setLandlordAge(22);
		landlord.setMobileNo("9133134411");

		when(landlordRepository.save(landlord)).thenReturn(landlord);

		Landlord addedLandlord = landlordService.addLandlord(landlord);

		verify(landlordRepository, times(1)).save(landlord);
		assertEquals(landlord, addedLandlord);
		assertEquals("Venkat", addedLandlord.getLandlordName());
		assertEquals(22, addedLandlord.getLandlordAge());
		assertEquals("9133134411", addedLandlord.getMobileNo());
	}

	@Test
	public void testUpdateLandlord() {
		Landlord landlord = new Landlord();
		landlord.setLandlordId(1);
		landlord.setLandlordName("Venkat");
		landlord.setLandlordAge(22);
		landlord.setMobileNo("9133134411");

		when(landlordRepository.findById(1)).thenReturn(Optional.of(landlord));
		when(landlordRepository.save(landlord)).thenReturn(landlord);

		landlord.setLandlordName("Venkat");
		landlord.setLandlordAge(24);
		landlord.setMobileNo("9705731779");

		Landlord updatedLandlord = landlordService.updateLandlord(landlord);

		verify(landlordRepository, times(1)).findById(1);
		verify(landlordRepository, times(1)).save(landlord);
		assertEquals(landlord, updatedLandlord);
		assertEquals("Venkat", updatedLandlord.getLandlordName());
		assertEquals(24, updatedLandlord.getLandlordAge());
		assertEquals("9705731779", updatedLandlord.getMobileNo());
	}

	@Test
	public void testUpdateLandlordWithException() {
		Landlord landlord = new Landlord();
		landlord.setLandlordId(1);
		landlord.setLandlordName("Kanna");
		landlord.setLandlordAge(21);
		landlord.setMobileNo("6309710881");

		when(landlordRepository.findById(1)).thenReturn(Optional.empty());

		assertThrows(LandlordNotFoundException.class, () -> landlordService.updateLandlord(landlord));
		verify(landlordRepository, times(1)).findById(1);
		verify(landlordRepository, times(0)).save(landlord);
	}

}
