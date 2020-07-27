package id.ts.parkinglot.service;

import java.util.HashMap;
import java.util.TreeSet;
import id.ts.parkinglot.model.Car;

public class ParkingLotService {
 	private int capacity;
	private int availability;
	private HashMap<Integer, Car> slotMap;
	private TreeSet<Integer> freeSlots;

	public ParkingLotService(int totalSlot) {
		capacity = totalSlot;
		availability = totalSlot;
		slotMap = new HashMap<Integer, Car>();
		freeSlots = new TreeSet<Integer>();

		for (int counter = 0; counter < capacity; counter++) {
			slotMap.put(counter, null);
			freeSlots.add(counter);
		}

		System.out.println("Created parking lot with " + totalSlot + " slots");
	}

	public int getAvailability() {
		return availability;
	}

	public void parkCar(Car car) {
		int availableSlot;

		if (capacity == 0)
      		System.out.println("Sorry, parking lot is not created");
    	else if (availability == 0)
      		System.out.println("Sorry, parking lot is full");
		else {
			availableSlot = freeSlots.first();
			slotMap.put(availableSlot, car);
			availability--;
			freeSlots.remove(availableSlot);

			System.out.println("Allocated slot number: " + (availableSlot+1));
		}				
	}

	public void leaveCar(String regNum, int hours) {
		if (capacity == 0) {
			System.out.println("Sorry, parking lot is not created");
			return;
		}

		int result = -1, charge = 0;

		for (int counter = 0; counter < capacity; counter++) {
			Car car = slotMap.get(counter);

      		if (car != null && regNum.equals(car.getRegNo()))
        		result = counter;
		}

		if (result == -1)
			System.out.println("Registration number " + regNum + " not found");
		else {
			availability++;
			freeSlots.add(result);
			slotMap.put(result, null);

			if (hours > 2) {
				charge += 10;
				charge += (hours-2)*10;
			}
			else
				charge = 10;

			System.out.println("Registration number " + regNum + " with Slot Number " + (result+1) + " is free with Charge " + charge);
		}
	}

	public void getStatus() {
		System.out.println("Slot No\tRegistration No");

		if (capacity == 0) {
			System.out.println("Sorry, parking lot is not created");
			return;
		}

		for (int counter = 0; counter < capacity; counter++) {
			Car car = slotMap.get(counter);

			if (car != null)
        		System.out.println((counter+1) + "\t" + car.getRegNo());
		}
	}
}
