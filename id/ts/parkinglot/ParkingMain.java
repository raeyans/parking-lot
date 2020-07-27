import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import id.ts.parkinglot.model.Car;
import id.ts.parkinglot.model.Command;
import id.ts.parkinglot.service.ParkingLotService;

public class ParkingMain {
	public static void main(String[] args) {
    ParkingLotService parkingLot;
		Scanner scanner;

		try {
			if (args.length > 0) {
				String fileName = args[0];
				File f = new File(fileName);
				scanner = new Scanner(f);
			}
			else
				scanner = new Scanner(System.in);

			String line, command, regNo;
			int parkingResult, charge;

			line = scanner.nextLine();
      if (line.equalsIgnoreCase("exit")) return;
			int count = Integer.parseInt(line.split(" ")[1]);
			parkingLot = new ParkingLotService(count);

			while(scanner.hasNextLine()) {
				line = scanner.nextLine();
				String[] commandLine = line.split(" ");
				command = commandLine[0];

				switch(Command.getCommand(command)) {
  				case LEAVE:
            regNo = commandLine[1];
            charge = Integer.parseInt(commandLine[2]);
  					parkingLot.leaveCar(regNo, charge);
  					break;
  				case PARK:
  					regNo = commandLine[1];
  					parkingLot.parkCar(new Car(regNo));
  					break;
          case STATUS:
  					parkingLot.getStatus();
  					break;
  				default:
  					break;
				}
			}
		} 
    catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
  }
}
