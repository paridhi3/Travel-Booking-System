package com.travelbookingsystem.travel.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.travelbookingsystem.travel.model.Passenger;
import java.util.List;

@Repository
public class PassengerRepository {
    private final JdbcTemplate jdbcTemplate;

    public PassengerRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // RowMapper for Passenger
    private final RowMapper<Passenger> passengerRowMapper = (rs, rowNum) -> 
        new Passenger(
            rs.getLong("passenger_id"),
            rs.getString("full_name"),
            rs.getString("email"),
            rs.getString("password"),
            rs.getString("gender"),
            rs.getInt("age"),
            rs.getString("contact")
        );

    // Method to get all passengers
    public List<Passenger> findAll() {
        String sql = "SELECT * FROM passenger";
        return jdbcTemplate.query(sql, passengerRowMapper);
    }

    // Method to find a passenger by ID
    public Passenger findById(long id) {
        String sql = "SELECT * FROM passenger WHERE passenger_id = ?";
        return jdbcTemplate.queryForObject(sql, passengerRowMapper, id);
    }

    // Method to add a new passenger
    public int save(Passenger passenger) {
        String sql = "INSERT INTO passenger (full_name, email, password, gender, age, contact) VALUES (?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(
            sql,
            passenger.getFull_name(),
            passenger.getEmail(),
            passenger.getPassword(),
            passenger.getGender(),
            passenger.getAge(),
            passenger.getContact()
        );
    }

    // Method to delete a passenger by ID
    public int deleteById(long id) {
        String sql = "DELETE FROM passenger WHERE passenger_id = ?";
        return jdbcTemplate.update(sql, id);
    }
}
