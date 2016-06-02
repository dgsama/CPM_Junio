package logica;

import java.util.Date;

public class Travel {

	private String destination;
	private String info;
	private int duration;
	private float adultPrice;
	private float childPrice;
	private Date departureDate;

	public Travel(String destination, String description, int duration, float adultPrice, float childPrice,
			Date departureDate) {
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

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
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

	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

}
