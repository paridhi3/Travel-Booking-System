package com.travelbookingsystem.travel.repository;

import com.travelbookingsystem.travel.model.Flight;
import com.travelbookingsystem.travel.model.FlightClass;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class FlightRepository {

    private final JdbcTemplate jdbcTemplate;

    public FlightRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

 // RowMapper to map SQL result to Flight object
    private final RowMapper<Flight> flightRowMapper = (rs, rowNum) -> new Flight(
            rs.getLong("flight_id"),
            rs.getString("airline_name"),
            rs.getString("source"),
            rs.getString("destination"),
            rs.getTime("departure_time").toLocalTime(),
            rs.getTime("arrival_time").toLocalTime(),
            rs.getInt("total_seats"),
            rs.getInt("available_seats"),
            rs.getDouble("price"),
            FlightClass.valueOf(rs.getString("flight_class")) // Convert String to Enum
    );

    // Method to fetch all flights
    public List<Flight> getAllFlights() {
        String sql = "SELECT * FROM flights";
        return jdbcTemplate.query(sql, flightRowMapper);
    }

    // Method to fetch flights by source and destination
    public List<Flight> findFlightsByRoute(String source, String destination) {
        String sql = "SELECT * FROM flights WHERE source = ? AND destination = ?";
        return jdbcTemplate.query(sql, flightRowMapper, source, destination);
    }

    // Method to add a new flight
    public int save(Flight flight) {
        String sql = "INSERT INTO flights (airline_name, source, destination, departure_time, arrival_time, total_seats, available_seats, price, flight_class) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql,
                flight.getAirlineName(),
                flight.getSource(),
                flight.getDestination(),
                flight.getDepartureTime(),
                flight.getArrivalTime(),
                flight.getTotalSeats(),
                flight.getAvailableSeats(),
                flight.getPrice(),
                flight.getFlightClass().name() // Convert enum to string
        );
    }

    // Method to update available seats
    public int updateAvailableSeats(long flightId, int newSeats) {
        String sql = "UPDATE flights SET available_seats = ? WHERE flight_id = ?";
        return jdbcTemplate.update(sql, newSeats, flightId);
    }

    // Method to delete a flight by ID
    public int deleteFlight(long flightId) {
        String sql = "DELETE FROM flights WHERE flight_id = ?";
        return jdbcTemplate.update(sql, flightId);
    }
}
