package model;

import java.io.Serializable;

public class DriverProfile implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int driverId;
	private String driverName;
	private PSPreferences driverPreferences;

	public DriverProfile(int driverId, String driverName, PSPreferences driverPreferences) {
		this.driverId = driverId;
		this.driverName = driverName;
		this.driverPreferences = driverPreferences;
		this.normalizeWeights();
	}
	
	private void normalizeWeights(){
		
	}

	public int getDriverId() {
		return driverId;
	}

	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public PSPreferences getDriverPreferences() {
		return driverPreferences;
	}

	public void setDriverPreferences(PSPreferences driverPreferences) {
		this.driverPreferences = driverPreferences;
	}

	@Override
	public String toString() {
		String toPrint = "Name: " + this.driverName + "\n$" + this.getDriverPreferences().getPsPrice() + "(W: "
				+ this.getDriverPreferences().getPriceWeight() + "%) - " + this.getDriverPreferences().getPsTime()
				+ "min. + (W: " + this.getDriverPreferences().getTimeWeight() + "%)";
		return toPrint;
	}

}
