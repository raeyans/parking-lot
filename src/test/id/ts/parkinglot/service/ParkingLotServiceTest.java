package id.ts.parkinglot.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import id.ts.parkinglot.model.Car;

public class ParkingLotServiceTest {
	
	ParkingLotService parkingLot;
	
	@Before
	public void property() throws Exception
	{
		
	}
	
	@Test
	public void testParkCar_availableSpace() {
		parkingLot = new ParkingLotService(3);
		parkingLot.parkCar(new Car("KA-01-HH-1234"));
		parkingLot.parkCar(new Car("KA-01-HH-9999"));
		parkingLot.parkCar(new Car("KA-01-BB-0001"));
		int availability = parkingLot.getAvailability();
		assertEquals(0, availability);
	}
	
	@Test
	public void testLeaveCar_foundCar(){
		parkingLot = new ParkingLotService(3);
		parkingLot.parkCar(new Car("KA-01-HH-1234"));
		parkingLot.parkCar(new Car("KA-01-HH-9999"));
		parkingLot.parkCar(new Car("KA-01-BB-0001"));
		int availability = parkingLot.getAvailability();

		parkingLot.leaveCar("KA-01-HH-9999", 5);
		availability = parkingLot.getAvailability();
		assertEquals(1, availability);
	}

	@Test
	public void testLeaveCar_notFoundCar(){
		parkingLot = new ParkingLotService(3);
		parkingLot.parkCar(new Car("KA-01-HH-1234"));
		parkingLot.parkCar(new Car("KA-01-HH-9999"));
		parkingLot.parkCar(new Car("KA-01-BB-0001"));
		int availability = parkingLot.getAvailability();

		parkingLot.leaveCar("RI 1", 5);
		availability = parkingLot.getAvailability();
		assertEquals(0, availability);
	}
}