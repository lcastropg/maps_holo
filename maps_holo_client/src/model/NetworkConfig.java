package model;

public enum NetworkConfig {

	SERVER_PORT("10000"),
	SERVER_IP("localhost");
	
	private final String value;
	
	NetworkConfig(String value){
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	

	
	
	
}
