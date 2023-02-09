package model;

public class BusReserveLogic {
	public boolean execute (Bus_ReserveBean bus_reservebean) {
		if(bus_reservebean.getReserved_flag() == 1) {
			return true;
		}
		return false;
	}

}
