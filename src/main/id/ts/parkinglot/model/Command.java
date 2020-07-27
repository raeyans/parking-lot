package id.ts.parkinglot.model;

import id.ts.parkinglot.constant.Constant;

public enum Command {

  	CREATE, PARK, LEAVE, STATUS;

	public static Command getCommand(String input) {
		if(Constant.CREATE_PARKING_LOT.equals(input)) return CREATE;
		else if(Constant.PARK.equals(input)) return PARK;
		else if(Constant.LEAVE.equals(input)) return LEAVE;
		else if(Constant.STATUS.equals(input)) return STATUS;
		else return null;
	}
}
