package com.travelbookingsystem.travel.repository;

import com.travelbookingsystem.travel.model.Bus;
import com.travelbookingsystem.travel.model.BusClass;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;


/*
 * BusRepository Methods:
 * 1. save(Bus bus) -> int
 * 2. findAll() -> List<Bus>
 * 3. findById(long busId) -> Bus
 * 4. update(Bus bus) -> int
 * 5. updateAvailableSeats(Long busId, int seatChange) -> int
 * 6. deleteById(long busId) -> int
 * 7. findBySourceAndDestination(String source, String destination) -> List<Bus>
 * 8. findByPriceBetween(double minPrice, double maxPrice) -> List<Bus>
 */


@Repository
public class BusRepository {
    private final JdbcTemplate jdbcTemplate;

    public BusRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // RowMapper to map SQL result to Bus object
    private final RowMapper<Bus> busRowMapper = (rs, rowNum) -> new Bus(
            rs.getLong("bus_id"),
            rs.getString("bus_name"),
            rs.getString("source"),
            rs.getString("destination"),
            rs.getTime("departure_time").toLocalTime(),
            rs.getTime("arrival_time").toLocalTime(),
            rs.getInt("total_seats"),
            rs.getInt("available_seats"),
            rs.getDouble("price"),
            BusClass.valueOf(rs.getString("bus_class")) // Convert String to Enum
    );

    // Save a bus
    public int save(Bus bus) {
        String sql = "INSERT INTO bus (bus_name, source, destination, departure_time, arrival_time, total_seats, available_seats, price, bus_class) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql,
                bus.getBusName(),
                bus.getSource(),
                bus.getDestination(),
                bus.getDepartureTime(),
                bus.getArrivalTime(),
                bus.getTotalSeats(),
                bus.getAvailableSeats(),
                bus.getPrice(),
                bus.getBusClass().name() // Convert Enum to String
        );
    }

    // Find all buses
    public List<Bus> findAll() {
        String sql = "SELECT * FROM bus";
        return jdbcTemplate.query(sql, busRowMapper);
    }

    // Find bus by ID
    public Bus findById(long busId) {
        String sql = "SELECT * FROM bus WHERE bus_id = ?";
        return jdbcTemplate.queryForObject(sql, busRowMapper, busId);
    }

    // Update bus details
    public int update(Bus bus) {
        String sql = "UPDATE bus SET bus_name = ?, source = ?, destination = ?, departure_time = ?, " +
                     "arrival_time = ?, total_seats = ?, available_seats = ?, price = ?, bus_class = ? WHERE bus_id = ?";
        return jdbcTemplate.update(sql,
                bus.getBusName(),
                bus.getSource(),
                bus.getDestination(),
                bus.getDepartureTime(),
                bus.getArrivalTime(),
                bus.getTotalSeats(),
                bus.getAvailableSeats(),
                bus.getPrice(),
                bus.getBusClass().name(),
                bus.getBusId()
        );
    }
    
    // Update available seats
    public int updateAvailableSeats(Long busId, int seatChange) {
        String fetchSql = "UPDATE bus SET available_seats = ? WHERE bus_id = ?";
        List<Bus> buss = jdbcTemplate.query(fetchSql, busRowMapper, busId);

        if (buss.isEmpty()) {
            return 0; // Bus not found, return 0 to indicate no update
        }

        Bus bus = buss.get(0); // Retrieve the first (and only) result
        int newSeats = Math.max(0, bus.getAvailableSeats() - seatChange); 

        // Update available seats in the database
        String updateSql = "UPDATE bus SET available_seats = ? WHERE bus_id = ?";
        int rowsUpdated = jdbcTemplate.update(updateSql, newSeats, busId);

        // Update the bus object as well
        bus.setAvailableSeats(newSeats);

        return rowsUpdated;
    }

    // Delete bus by ID
    public int deleteById(long busId) {
        String sql = "DELETE FROM bus WHERE bus_id = ?";
        return jdbcTemplate.update(sql, busId);
    }

    // Find buses by source and destination
    public List<Bus> findBySourceAndDestination(String source, String destination) {
        String sql = "SELECT * FROM bus WHERE source = ? AND destination = ?";
        return jdbcTemplate.query(sql, busRowMapper, source, destination);
    }

    // Find buses within a price range
    public List<Bus> findByPriceBetween(double minPrice, double maxPrice) {
        String sql = "SELECT * FROM bus WHERE price BETWEEN ? AND ?";
        return jdbcTemplate.query(sql, busRowMapper, minPrice, maxPrice);
    }
    
}
