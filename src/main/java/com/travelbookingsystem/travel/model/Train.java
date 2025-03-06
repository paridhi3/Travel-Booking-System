package com.travelbookingsystem.travel.model;

import java.time.LocalTime;

public class Train {
    private long trainId;
    private String trainName;
    private String source;
    private String destination;
    private LocalTime departureTime;
    private LocalTime arrivalTime;
    private int totalSeats;
    private int availableSeats;
    private double price;
    private TrainClass trainClass;
    
	public Train() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Train(long trainId, String trainName, String source, String destination, LocalTime departureTime,
			LocalTime arrivalTime, int totalSeats, int availableSeats, double price, TrainClass trainClass) {
		super();
		this.trainId = trainId;
		this.trainName = trainName;
		this.source = source;
		this.destination = destination;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.totalSeats = totalSeats;
		this.availableSeats = availableSeats;
		this.price = price;
		this.trainClass = trainClass;
	}

	public Train(String trainName, String source, String destination, LocalTime departureTime, LocalTime arrivalTime,
			int totalSeats, int availableSeats, double price, TrainClass trainClass) {
		super();
		this.trainName = trainName;
		this.source = source;
		this.destination = destination;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.totalSeats = totalSeats;
		this.availableSeats = availableSeats;
		this.price = price;
		this.trainClass = trainClass;
	}

	public long getTrainId() {
		return trainId;
	}

	public void setTrainId(long trainId) {
		this.trainId = trainId;
	}

	public String getTrainName() {
		return trainName;
	}

	public void setTrainName(String trainName) {
		this.trainName = trainName;
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

	public TrainClass getTrainClass() {
		return trainClass;
	}

	public void setTrainClass(TrainClass trainClass) {
		this.trainClass = trainClass;
	}

	@Override
	public String toString() {
		return "Train [trainId=" + trainId + ", trainName=" + trainName + ", source=" + source + ", destination="
				+ destination + ", departureTime=" + departureTime + ", arrivalTime=" + arrivalTime + ", totalSeats="
				+ totalSeats + ", availableSeats=" + availableSeats + ", price=" + price + ", trainClass=" + trainClass
				+ "]";
	}
    
    
}
