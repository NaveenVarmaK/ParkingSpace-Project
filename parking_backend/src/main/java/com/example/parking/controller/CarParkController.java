package com.example.parking.controller;

import com.example.parking.models.CarParks;
import com.example.parking.repositories.CarParksRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@Tag(name = "CarPark", description = "CarPark management APIs")
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
@EntityScan(basePackageClasses = {CarParks.class})
public class CarParkController {
    private static final Logger logger = LoggerFactory.getLogger(CarParkController.class);

    @Autowired
    public CarParksRepository carParksRepository;

    @GetMapping("/carparks")
    public ResponseEntity<List<CarParks>> getCarParks() {
        logger.info("Get car parks request has been made");
        List<CarParks> carParks = this.carParksRepository.findAll();
        logger.debug("Number of car parks retrieved: " + carParks.size());
        return ResponseEntity.ok(carParks);
    }

    @GetMapping("/carparks/{id}")
    public ResponseEntity<CarParks> getCarPark(@PathVariable("id") long id) {
        if (this.carParksRepository.findById(id).isEmpty()) {
            logger.debug("Cannot find the car park with id: " + id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            CarParks carPark = this.carParksRepository.findById(id).get();
            logger.info("Car park retrieved successfully. Car park ID: " + carPark.getId());
            return new ResponseEntity<>(carPark, HttpStatus.OK);
        }
    }

    @PostMapping("/carparks")
    public ResponseEntity<CarParks> createCarPark(@RequestBody CarParks carPark) {
        try {
            CarParks newCarPark = this.carParksRepository.save(carPark);
            logger.info("Car park created successfully. Car park ID: " + newCarPark.getId());
            return new ResponseEntity<>(newCarPark, HttpStatus.CREATED);
        } catch (Exception e) {
            logger.error("Error occurred while creating car park: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/carparks/{id}")
    public ResponseEntity<CarParks> updateCarPark(@PathVariable("id") long id, @RequestBody CarParks carPark) {
        if (this.carParksRepository.findById(id).isEmpty()) {
            logger.debug("Cannot find the car park with id: " + id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            CarParks existingCarPark = this.carParksRepository.findById(id).get();
            existingCarPark.setCarparkName(carPark.getCarparkName());
            existingCarPark.setPostcode(carPark.getPostcode());
            existingCarPark.setDescription(carPark.getDescription());
            existingCarPark.setEasting(carPark.getEasting());
            existingCarPark.setNorthing(carPark.getNorthing());
            CarParks updatedCarPark = this.carParksRepository.save(existingCarPark);
            logger.info("Car park updated successfully. Car park ID: " + updatedCarPark.getId());
            return new ResponseEntity<>(updatedCarPark, HttpStatus.OK);
        }
    }

    @DeleteMapping("/carparks/{id}")
    public ResponseEntity<HttpStatus> deleteCarPark(@PathVariable("id") long id) {
        try {
            this.carParksRepository.deleteById(id);
            logger.info("Car park deleted successfully. Car park ID: " + id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            logger.error("Error occurred while deleting car park: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //     Example method to update status based on sensor data
    @PostMapping("/carparks/updateStatus")
    public ResponseEntity<HttpStatus> createCarPark(
            @PathVariable("id") long id, @PathVariable("status") String status) {
        if (this.carParksRepository.findById(id).isEmpty()) {
            logger.debug("Cannot find the car park with id: " + id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            com.example.parking.models.CarParks existingCarPark = this.carParksRepository.findById(id).get();
            existingCarPark.setStatus(status);
            com.example.parking.models.CarParks updatedCarPark = this.carParksRepository.save(existingCarPark);
            logger.info("Car park updated successfully. Car park ID: " + updatedCarPark.getId());
            return new ResponseEntity<>(HttpStatus.OK);
        }

    }

}
