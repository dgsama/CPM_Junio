package logica;

import java.util.Date;

public class Travel {

	private String destination;
	private String info;
	private String duration;
	private float adultPrice;
	private float childPrice;
	private String departureDate;

	public Travel(String destination, String description, String duration, float adultPrice, float childPrice,
			String departureDate) {
		this.destination = destination;
		this.info = description;
		this.duration = duration;
		this.adultPrice = adultPrice;
		this.childPrice = childPrice;
		this.departureDate = departureDate;
	}

	// GETTERS && SETTERS

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getDescription() {
		return info;
	}

	public void setDescription(String description) {
		this.info = description;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public float getAdultPrice() {
		return adultPrice;
	}

	public void setAdultPrice(float adultPrice) {
		this.adultPrice = adultPrice;
	}

	public float getChildPrice() {
		return childPrice;
	}

	public void setChildPrice(float childPrice) {
		this.childPrice = childPrice;
	}

	public String getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}

	@Override
	public String toString() {
		return "Travel [destination=" + destination + "]";
	}

}
