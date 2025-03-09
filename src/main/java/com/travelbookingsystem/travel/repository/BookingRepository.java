package com.travelbookingsystem.travel.repository;

import com.travelbookingsystem.travel.model.Booking;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;


/*
 * BookingRepository Methods:
 * 1. save(Booking booking) - Saves a new booking record.
 * 2. findAll() - Retrieves all bookings.
 * 3. findById(long bookingId) - Retrieves a booking by its ID.
 * 4. findByPassengerId(long passengerId) - Retrieves all bookings for a specific passenger.
 * 5. updateBookingStatus(long bookingId, String status) - Updates the booking status.
 * 6. updatePaymentStatus(long bookingId, String status) - Updates the payment status.
 * 7. deleteById(long bookingId) - Deletes a booking by its ID.
 * 8. findByTransportType(String transportType) - Retrieves all bookings for a given transport type.
 */


@Repository
public class BookingRepository {
    private final JdbcTemplate jdbcTemplate;

    public BookingRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // RowMapper to map SQL result to Booking object
    private final RowMapper<Booking> bookingRowMapper = (rs, rowNum) -> new Booking(
            rs.getLong("booking_id"),
            rs.getLong("passenger_id"),
            rs.getString("transport_type"),
            rs.getLong("transport_id"),
            rs.getString("seat_number"),
            rs.getString("booking_status"),
            rs.getString("payment_status"),
            rs.getTimestamp("booking_date").toLocalDateTime()
    );

    // Save a new booking
    public int save(Booking booking) {
        String sql = "INSERT INTO booking (passenger_id, transport_type, transport_id, seat_number, booking_status, payment_status, booking_date) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql,
                booking.getPassengerId(),
                booking.getTransportType(),
                booking.getTransportId(),
                booking.getSeatNumber(),
                booking.getBookingStatus(),
                booking.getPaymentStatus(),
                booking.getBookingDate()
        );
    }

    // Find all bookings
    public List<Booking> findAll() {
        String sql = "SELECT * FROM booking";
        return jdbcTemplate.query(sql, bookingRowMapper);
    }

    // Find booking by booking ID
    public Booking findById(long bookingId) {
        String sql = "SELECT * FROM booking WHERE booking_id = ?";
        return jdbcTemplate.queryForObject(sql, bookingRowMapper, bookingId);
    }

    // Find bookings by passenger ID
    public List<Booking> findByPassengerId(long passengerId) {
        String sql = "SELECT * FROM booking WHERE passenger_id = ?";
        return jdbcTemplate.query(sql, bookingRowMapper, passengerId);
    }
  
    // Update booking status
    public int updateBookingStatus(long bookingId, String status) {
        String sql = "UPDATE booking SET booking_status = ? WHERE booking_id = ?";
        return jdbcTemplate.update(sql, status, bookingId);
    }

    // Update payment status
    public int updatePaymentStatus(long bookingId, String status) {
        String sql = "UPDATE booking SET payment_status = ? WHERE booking_id = ?";
        return jdbcTemplate.update(sql, status, bookingId);
    }
     
    // Delete booking by ID
    public int deleteById(long bookingId) {
        String sql = "DELETE FROM booking WHERE booking_id = ?";
        return jdbcTemplate.update(sql, bookingId);
    }

    // Find bookings by transport type
    public List<Booking> findByTransportType(String transportType) {
        String sql = "SELECT * FROM booking WHERE transport_type = ?";
        return jdbcTemplate.query(sql, bookingRowMapper, transportType);
    }
}
