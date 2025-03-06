package com.travelbookingsystem.travel.model;

import java.time.LocalDateTime;

public class Bus {
    private long busId;
    private String busName;
    private String source;
    private String destination;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private int totalSeats;
    private int availableSeats;
    private double price;
    private BusClass busClass;
    
	public Bus() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bus(long busId, String busName, String source, String destination, LocalDateTime departureTime,
			LocalDateTime arrivalTime, int totalSeats, int availableSeats, double price, BusClass busClass) {
		super();
		this.busId = busId;
		this.busName = busName;
		this.source = source;
		this.destination = destination;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.totalSeats = totalSeats;
		this.availableSeats = availableSeats;
		this.price = price;
		this.busClass = busClass;
	}

	public Bus(String busName, String source, String destination, LocalDateTime departureTime,
			LocalDateTime arrivalTime, int totalSeats, int availableSeats, double price, BusClass busClass) {
		super();
		this.busName = busName;
		this.source = source;
		this.destination = destination;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.totalSeats = totalSeats;
		this.availableSeats = availableSeats;
		this.price = price;
		this.busClass = busClass;
	}

	public long getBusId() {
		return busId;
	}

	public void setBusId(long busId) {
		this.busId = busId;
	}

	public String getBusName() {
		return busName;
	}

	public void setBusName(String busName) {
		this.busName = busName;
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

	public LocalDateTime getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(LocalDateTime departureTime) {
		this.departureTime = departureTime;
	}

	public LocalDateTime getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(LocalDateTime arrivalTime) {
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

	public BusClass getBusClass() {
		return busClass;
	}

	public void setBusClass(BusClass busClass) {
		this.busClass = busClass;
	}

	@Override
	public String toString() {
		return "Bus [busId=" + busId + ", busName=" + busName + ", source=" + source + ", destination=" + destination
				+ ", departureTime=" + departureTime + ", arrivalTime=" + arrivalTime + ", totalSeats=" + totalSeats
				+ ", availableSeats=" + availableSeats + ", price=" + price + ", busClass=" + busClass + "]";
	}
    
    
}
