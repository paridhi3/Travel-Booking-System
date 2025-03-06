package com.travelbookingsystem.travel.repository;

import com.travelbookingsystem.travel.model.Train;
import com.travelbookingsystem.travel.model.TrainClass;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.time.LocalTime;
import java.util.List;

@Repository
public class TrainRepository {
    private final JdbcTemplate jdbcTemplate;

    public TrainRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // RowMapper to map SQL result to Train object
    private final RowMapper<Train> trainRowMapper = (rs, rowNum) -> new Train(
            rs.getLong("train_id"),
            rs.getString("train_name"),
            rs.getString("source"),
            rs.getString("destination"),
            rs.getTime("departure_time").toLocalTime(),
            rs.getTime("arrival_time").toLocalTime(),
            rs.getInt("total_seats"),
            rs.getInt("available_seats"),
            rs.getDouble("price"),
            TrainClass.valueOf(rs.getString("train_class")) // Convert String to Enum
    );

    // Save a train
    public int save(Train train) {
        String sql = "INSERT INTO train (train_name, source, destination, departure_time, arrival_time, total_seats, available_seats, price, train_class) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql,
                train.getTrainName(),
                train.getSource(),
                train.getDestination(),
                train.getDepartureTime(),
                train.getArrivalTime(),
                train.getTotalSeats(),
                train.getAvailableSeats(),
                train.getPrice(),
                train.getTrainClass().name() // Convert Enum to String
        );
    }

    // Find all trains
    public List<Train> findAll() {
        String sql = "SELECT * FROM train";
        return jdbcTemplate.query(sql, trainRowMapper);
    }

    // Find train by ID
    public Train findById(long trainId) {
        String sql = "SELECT * FROM train WHERE train_id = ?";
        return jdbcTemplate.queryForObject(sql, trainRowMapper, trainId);
    }

    // Update train details
    public int update(Train train) {
        String sql = "UPDATE train SET train_name = ?, source = ?, destination = ?, departure_time = ?, " +
                     "arrival_time = ?, total_seats = ?, available_seats = ?, price = ?, train_class = ? WHERE train_id = ?";
        return jdbcTemplate.update(sql,
                train.getTrainName(),
                train.getSource(),
                train.getDestination(),
                train.getDepartureTime(),
                train.getArrivalTime(),
                train.getTotalSeats(),
                train.getAvailableSeats(),
                train.getPrice(),
                train.getTrainClass().name(),
                train.getTrainId()
        );
    }

    // Delete train by ID
    public int deleteById(long trainId) {
        String sql = "DELETE FROM train WHERE train_id = ?";
        return jdbcTemplate.update(sql, trainId);
    }

    // Find trains by source and destination
    public List<Train> findBySourceAndDestination(String source, String destination) {
        String sql = "SELECT * FROM train WHERE source = ? AND destination = ?";
        return jdbcTemplate.query(sql, trainRowMapper, source, destination);
    }

    // Find trains within a price range
    public List<Train> findByPriceBetween(double minPrice, double maxPrice) {
        String sql = "SELECT * FROM train WHERE price BETWEEN ? AND ?";
        return jdbcTemplate.query(sql, trainRowMapper, minPrice, maxPrice);
    }
}
