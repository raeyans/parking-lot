# Parking-Lot Project

This project can be run with 2 (two) ways:

### Passing a file that contains commands to run the app.

```bash
javac ParkingMain.java
java ParkingMain parking_lot_file_inputs.txt
```

### Passing the commands directly.
```bash
javac ParkingMain.java
java ParkingMain
create_parking_lot 6
park KA-01-HH-1234 White
park KA-01-HH-9999 White
park KA-01-BB-0001 Black
park KA-01-HH-7777 Red
park KA-01-HH-2701 Blue
park KA-01-HH-3141 Black
leave 4
status
park KA-01-P-333 White
park DL-12-AA-9999 White
registration_numbers_for_cars_with_colour White
slot_numbers_for_cars_with_colour White
slot_number_for_registration_number KA-01-HH-3141
slot_number_for_registration_number MH-04-AY-1111
```
