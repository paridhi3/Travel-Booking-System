package com.travelbookingsystem.travel.model;

import java.time.LocalDateTime;

public class Booking {
    private long bookingId;
    private long userId;
    private String transportType; // train, bus, flight
    private long transportId;
    private String seatNumber;
    private String bookingStatus; // confirmed, cancelled
    private String paymentStatus; // pending, completed, failed
    private LocalDateTime bookingDate;
    
	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Booking(long bookingId, long userId, String transportType, long transportId, String seatNumber,
			String bookingStatus, String paymentStatus, LocalDateTime bookingDate) {
		super();
		this.bookingId = bookingId;
		this.userId = userId;
		this.transportType = transportType;
		this.transportId = transportId;
		this.seatNumber = seatNumber;
		this.bookingStatus = bookingStatus;
		this.paymentStatus = paymentStatus;
		this.bookingDate = bookingDate;
	}

	public Booking(long userId, String transportType, long transportId, String seatNumber,
			String bookingStatus, String paymentStatus, LocalDateTime bookingDate) {
		super();
		this.userId = userId;
		this.transportType = transportType;
		this.transportId = transportId;
		this.seatNumber = seatNumber;
		this.bookingStatus = bookingStatus;
		this.paymentStatus = paymentStatus;
		this.bookingDate = bookingDate;
	}

	public long getBookingId() {
		return bookingId;
	}

	public void setBookingId(long bookingId) {
		this.bookingId = bookingId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getTransportType() {
		return transportType;
	}

	public void setTransportType(String transportType) {
		this.transportType = transportType;
	}

	public long getTransportId() {
		return transportId;
	}

	public void setTransportId(long transportId) {
		this.transportId = transportId;
	}

	public String getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}

	public String getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public LocalDateTime getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDateTime bookingDate) {
		this.bookingDate = bookingDate;
	}

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", userId=" + userId + ", transportType=" + transportType
				+ ", transportId=" + transportId + ", seatNumber=" + seatNumber + ", bookingStatus=" + bookingStatus
				+ ", paymentStatus=" + paymentStatus + ", bookingDate=" + bookingDate + "]";
	}
    
    
   
}
