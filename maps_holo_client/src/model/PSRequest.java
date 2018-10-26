package model;

import java.io.Serializable;

public class PSRequest implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int requestID;
	private DriverProfile dProfile;
	private PSPreferences dPreferences;
	
	public PSRequest(int requestID, DriverProfile dProfile, PSPreferences dPreferences) {	
		this.requestID = requestID;
		this.dProfile = dProfile;
		this.dPreferences = dPreferences;
	}
	
	public PSRequest(int requestID, DriverProfile dProfile) {	
		this.requestID = requestID;
		this.dProfile = dProfile;
		this.dPreferences = dProfile.getDriverPreferences();
	}

	public PSRequest(DriverProfile dProfile, PSPreferences dPreferences) {		
		this.dProfile = dProfile;
		this.dPreferences = dPreferences;
	}

	public int getRequestID() {
		return requestID;
	}

	public void setRequestID(int requestID) {
		this.requestID = requestID;
	}

	public DriverProfile getdProfile() {
		return dProfile;
	}

	public void setdProfile(DriverProfile dProfile) {
		this.dProfile = dProfile;
	}

	public PSPreferences getdPreferences() {
		return dPreferences;
	}

	public void setdPreferences(PSPreferences dPreferences) {
		this.dPreferences = dPreferences;
	}
	
	
	
	
	
	
	

}
