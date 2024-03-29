package com.example.parking.controller;

import com.example.parking.models.Booking;
import com.example.parking.models.CarParks;
import com.example.parking.models.Slot;
import com.example.parking.repositories.BookingRepository;
import com.example.parking.repositories.CarParksRepository;
import com.example.parking.repositories.SlotRepository;
import com.example.parking.repositories.UserRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.parking.models.User;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

@Tag(name = "Booking", description = "Booking management APIs")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
@EntityScan(basePackageClasses = {Booking.class})
public class BookingController {

    private static final Logger logger = LoggerFactory.getLogger(BookingController.class);

    @Autowired
    public BookingRepository bookingRepository;

    @Autowired
    public UserRepository userRepository;

    @Autowired
    public SlotRepository slotsRepository;

    @Autowired
    public CarParksRepository carParksRepository;

    @GetMapping("/bookings")
    public ResponseEntity<List<Booking>> getBookings() {
        logger.info("Get bookings request has been made");
        List<Booking> bookings = this.bookingRepository.findAll();
        logger.debug("Number of bookings retrieved: " + bookings.size());
        return ResponseEntity.ok(bookings);
    }

    @GetMapping("/bookings/{id}")
    public ResponseEntity<Booking> getBooking(@PathVariable("id") long id) {
        if (this.bookingRepository.findById(id).isEmpty()) {
            logger.debug("Cannot find the booking with id: " + id);
            return ResponseEntity.notFound().build();
        } else {
            Booking booking = this.bookingRepository.findById(id).get();
            logger.info("Booking retrieved successfully. Booking ID: " + booking.getId());
            return ResponseEntity.ok(booking);
        }
    }

    @GetMapping("/bookings/user/{id}")
    public ResponseEntity<List<Booking>> getBookingByUser(@PathVariable("id") long id) {
        User user = this.userRepository.findById(id).orElse(null);
        if (user == null || this.bookingRepository.findByUser(user).isEmpty()) {
            logger.debug("No bookings found for user with id: " + id);
            return ResponseEntity.notFound().build();
        } else {
            List<Booking> userBookings = this.bookingRepository.findByUser(user);
            logger.info("Bookings retrieved for user with id: " + id);
            return ResponseEntity.ok(userBookings);
        }
    }

    @PostMapping("/bookings")
    public ResponseEntity<Booking> createBooking(@RequestParam long userId, @RequestParam long slotId) throws Exception {
        if (this.userRepository.findById(userId).isEmpty()) {
            logger.debug("Cannot find the user with id: " + userId);
            return ResponseEntity.notFound().build();
        }
        if (this.slotsRepository.findById(slotId).isEmpty()) {
            logger.debug("Cannot find the slot with id: " + slotId);
            return ResponseEntity.notFound().build();
        }

        User user = this.userRepository.findById(userId).get();
        CarParks slot = this.slotsRepository.findById(slotId).get();

        if (slot == null){
            throw new Exception("Slot not found");
        }

        Booking booking = new Booking();
        booking.setUser(user);
        booking.setSlot(slot);

        this.bookingRepository.save(booking);

        logger.info("Booking created successfully. Booking ID: " + booking.getId());
        return ResponseEntity.ok(this.bookingRepository.save(booking));
    }

    @DeleteMapping("/bookings/{id}")
    public ResponseEntity<HttpStatus> deleteBooking(@PathVariable("id") long id) {
        if (this.bookingRepository.findById(id).isEmpty()) {
            logger.debug("Cannot find the booking with id: " + id);
            return ResponseEntity.notFound().build();
        } else {
            this.bookingRepository.deleteById(id);
            logger.info("Booking deleted successfully. Booking ID: " + id);
            return ResponseEntity.noContent().build();
        }
    }

    @RequestMapping(path = "/upload/uk", method = RequestMethod.POST, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("File is empty");
        }
        carParksRepository.deleteAll();

        try (Reader reader = new InputStreamReader(file.getInputStream())) {
            Iterable<CSVRecord> records = CSVFormat.DEFAULT.withHeader("Carpark Name", "postcode", "description", "easting", "northing").withFirstRecordAsHeader().parse(reader);

            for (CSVRecord record : records) {
                System.out.println("Record: " + record.toString());
                CarParks carPark = new CarParks();
                carPark.setCarparkName(record.get("\uFEFFCarpark Name"));
                logger.info("Car Park Name: " + record.get("\uFEFFCarpark Name"));
                carPark.setPostcode(record.get("Postcode"));
                logger.info("Postcode: " + record.get("Postcode"));
                carPark.setDescription(record.get("Description"));
                logger.info("Description: " + record.get("Description"));
                carPark.setEasting(record.get("EASTING"));
                logger.info("Easting: " + record.get("EASTING"));
                carPark.setNorthing(record.get("NORTHING"));
                logger.info("Northing: " + record.get("NORTHING"));

                carParksRepository.save(carPark); // carParksRepository is an instance of a Spring Data JPA repository for CarParks
            }

            return ResponseEntity.ok("File uploaded successfully");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload file");
        }
    }


}

