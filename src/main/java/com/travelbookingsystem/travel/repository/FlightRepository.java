package com.travelbookingsystem.travel.repository;

import com.travelbookingsystem.travel.model.Flight;
import com.travelbookingsystem.travel.model.FlightClass;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;


/*
 * FlightRepository Methods:
 * 1. save(Flight flight) -> int
 * 2. findAll() -> List<Flight>
 * 3. findById(long flightId) -> Flight
 * 4. update(Flight flight) -> int
 * 5. updateAvailableSeats(Long flightId, int seatChange) -> int
 * 6. deleteById(long flightId) -> int
 * 7. findBySourceAndDestination(String source, String destination) -> List<Flight>
 * 8. findByPriceBetween(double minPrice, double maxPrice) -> List<Flight>
 */


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
    
    // Method to add a new flight
    public int save(Flight flight) {
        String sql = "INSERT INTO flight (airline_name, source, destination, departure_time, arrival_time, total_seats, available_seats, price, flight_class) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
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

    // Method to fetch all flights
    public List<Flight> findAll() {
        String sql = "SELECT * FROM flight";
        return jdbcTemplate.query(sql, flightRowMapper);
    }
    
    // Find flight by ID
    public Flight findById(long flightId) {
        String sql = "SELECT * FROM flight WHERE flight_id = ?";
        return jdbcTemplate.queryForObject(sql, flightRowMapper, flightId);
    }
    
    // Update flight details
    public int update(Flight flight) {
        String sql = "UPDATE flight SET airline_name = ?, source = ?, destination = ?, departure_time = ?, " +
                     "arrival_time = ?, total_seats = ?, available_seats = ?, price = ?, flight_class = ? WHERE flight_id = ?";
        return jdbcTemplate.update(sql,
                flight.getAirlineName(),
                flight.getSource(),
                flight.getDestination(),
                flight.getDepartureTime(),
                flight.getArrivalTime(),
                flight.getTotalSeats(),
                flight.getAvailableSeats(),
                flight.getPrice(),
                flight.getFlightClass().name(),
                flight.getFlightId()
        );
    }

//    // Method to update available seats
//    public int updateAvailableSeats(long flightId, int seatChange) {
//        // Fetch the flight object
//        String fetchSql = "SELECT * FROM flight WHERE flight_id = ?";
//        List<Flight> flights = jdbcTemplate.query(fetchSql, flightRowMapper, flightId);
//
//        if (flights.isEmpty()) {
//            return 0; // Flight not found, return 0 to indicate no update
//        }
//
//        Flight flight = flights.get(0); // Retrieve the first (and only) result
//        int newSeats = Math.max(0, flight.getAvailableSeats() - seatChange); 
//
//        // Update available seats in the database
//        String updateSql = "UPDATE flight SET available_seats = ? WHERE flight_id = ?";
//        int rowsUpdated = jdbcTemplate.update(updateSql, newSeats, flightId);
//
//        // Update the flight object as well
//        flight.setAvailableSeats(newSeats);
//
//        return rowsUpdated;
//    }
    
    // Method to update available seats
    public int updateAvailableSeats(long flightId, int seatChange) {
        // Reduce available seats but ensure it doesn’t go below zero
        String sql = "UPDATE flights SET available_seats = GREATEST(available_seats - ?, 0) WHERE flight_id = ?";
        return jdbcTemplate.update(sql, seatChange, flightId);
    }

    
    // Method to delete a flight by ID
    public int deleteById(long flightId) {
        String sql = "DELETE FROM flight WHERE flight_id = ?";
        return jdbcTemplate.update(sql, flightId);
    }

    // Method to fetch flights by source and destination
    public List<Flight> findBySourceAndDestination(String source, String destination) {
        String sql = "SELECT * FROM flight WHERE source = ? AND destination = ?";
        return jdbcTemplate.query(sql, flightRowMapper, source, destination);
    }

    // Find flights within a price range
    public List<Flight> findByPriceBetween(double minPrice, double maxPrice) {
        String sql = "SELECT * FROM flight WHERE price BETWEEN ? AND ?";
        return jdbcTemplate.query(sql, flightRowMapper, minPrice, maxPrice);
    }

    
}
