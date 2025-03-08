package com.travelbookingsystem.travel.model;

import java.time.LocalTime;

public class Flight {
    private long flightId;
    private String airlineName;
    private String source;
    private String destination;
    private LocalTime departureTime;
    private LocalTime arrivalTime;
    private int totalSeats;
    private int availableSeats;
    private double price;
    private FlightClass flightClass;
    
	public Flight() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Flight(long flightId, String airlineName, String source, String destination, LocalTime departureTime,
			LocalTime arrivalTime, int totalSeats, int availableSeats, double price, FlightClass flightClass) {
		super();
		this.flightId = flightId;
		this.airlineName = airlineName;
		this.source = source;
		this.destination = destination;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.totalSeats = totalSeats;
		this.availableSeats = availableSeats;
		this.price = price;
		this.flightClass = flightClass;
	}

	public Flight(String airlineName, String source, String destination, LocalTime departureTime,
			LocalTime arrivalTime, int totalSeats, int availableSeats, double price, FlightClass flightClass) {
		super();
		this.airlineName = airlineName;
		this.source = source;
		this.destination = destination;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.totalSeats = totalSeats;
		this.availableSeats = availableSeats;
		this.price = price;
		this.flightClass = flightClass;
	}

	public long getFlightId() {
		return flightId;
	}

	public void setFlightId(long flightId) {
		this.flightId = flightId;
	}

	public String getAirlineName() {
		return airlineName;
	}

	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public LocalTime getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(LocalTime departureTime) {
		this.departureTime = departureTime;
	}

	public LocalTime getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(LocalTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public int getTotalSeats() {
		return totalSeats;
	}

	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}

	public int getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public FlightClass getFlightClass() {
		return flightClass;
	}

	public void setFlightClass(FlightClass flightClass) {
		this.flightClass = flightClass;
	}

	@Override
	public String toString() {
		return "Flight [flightId=" + flightId + ", airlineName=" + airlineName + ", source=" + source + ", destination="
				+ destination + ", departureTime=" + departureTime + ", arrivalTime=" + arrivalTime + ", totalSeats="
				+ totalSeats + ", availableSeats=" + availableSeats + ", price=" + price + ", flightClass="
				+ flightClass + "]";
	}
    
    
}
