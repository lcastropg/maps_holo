package model;

import java.io.Serializable;

public class PSPreferences implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double psPrice, priceWeight, timeWeight;
	private int psTime;
	
	public PSPreferences(double psPrice, double priceWeight, int psTime, double timeWeight) {
		this.psPrice = psPrice;
		this.priceWeight = priceWeight;
		this.timeWeight = timeWeight;
		this.psTime = psTime;
	}
	public double getPsPrice() {
		return psPrice;
	}
	public void setPsPrice(double psPrice) {
		this.psPrice = psPrice;
	}
	public double getPriceWeight() {
		return priceWeight;
	}
	public void setPriceWeight(double priceWeight) {
		this.priceWeight = priceWeight;
	}
	public double getTimeWeight() {
		return timeWeight;
	}
	public void setTimeWeight(double timeWeight) {
		this.timeWeight = timeWeight;
	}
	public int getPsTime() {
		return psTime;
	}
	public void setPsTime(int psTime) {
		this.psTime = psTime;
	}
	
	
	
	
	

}
