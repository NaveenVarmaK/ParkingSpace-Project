package com.example.parking.repositories;

import com.example.parking.models.CarParks;
import com.example.parking.models.Slot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SlotRepository extends JpaRepository<CarParks, Long> {
}