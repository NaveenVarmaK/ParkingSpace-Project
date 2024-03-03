package com.example.parking.repositories;

import com.example.parking.models.Booking;
import com.example.parking.models.CarParks;
import com.example.parking.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarParksRepository extends JpaRepository<CarParks, Long> {
    List<CarParks> findByCarparkName(String carparkName);
}