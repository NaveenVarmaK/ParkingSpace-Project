package com.example.parking;

import com.example.parking.controller.SlotController;
import com.example.parking.models.CarParks;
import com.example.parking.models.Slot;
import com.example.parking.repositories.SlotRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

class SlotControllerTest {

    @Mock
    private SlotRepository slotRepository;

    @InjectMocks
    private SlotController slotController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetSlots() {
        // Mocking data
        List<CarParks> slots = Arrays.asList(new CarParks(), new CarParks());
        when(slotRepository.findAll()).thenReturn(slots);

        // Testing the controller method
        ResponseEntity<List<CarParks>> responseEntity = slotController.getSlots();

        // Assertions
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(slots, responseEntity.getBody());
    }

    @Test
    void testGetSlotById() {
        // Mocking data
        long slotId = 1L;
        CarParks slot = new CarParks();
        when(slotRepository.findById(slotId)).thenReturn(Optional.of(slot));

        // Testing the controller method
        ResponseEntity<CarParks> responseEntity = slotController.getSlot(slotId);

        // Assertions
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(slot, responseEntity.getBody());
    }

    @Test
    void testGetSlotByIdNotFound() {
        // Mocking data
        long slotId = 1L;
        when(slotRepository.findById(slotId)).thenReturn(Optional.empty());

        // Testing the controller method
        ResponseEntity<CarParks> responseEntity = slotController.getSlot(slotId);

        // Assertions
        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
        assertNull(responseEntity.getBody());
    }

    @Test
    void testCreateSlot() {
        // Mocking data
        CarParks slot = new CarParks();
        when(slotRepository.save(any(CarParks.class))).thenReturn(slot);

        // Testing the controller method
        ResponseEntity<CarParks> responseEntity = slotController.createSlot(slot);

        // Assertions
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(slot, responseEntity.getBody());
    }

//    @Test
//    void testUpdateSlot() {
//        // Mocking data
//        long slotId = 1L;
//        CarParks existingSlot = new CarParks();
//        when(slotRepository.findById(slotId)).thenReturn(Optional.of(existingSlot));
//        CarParks updatedSlot = new CarParks();
////        updatedSlot.setArea("New Area");
//
//        // Testing the controller method
////        ResponseEntity<CarParks> responseEntity = slotController.updateSlot(slotId, updatedSlot);
//
//        // Assertions
//        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
//        assertEquals(updatedSlot.getArea(), responseEntity.getBody().getArea());
//    }

//    @Test
//    void testUpdateSlotNotFound() {
//        // Mocking data
//        long slotId = 1L;
//        when(slotRepository.findById(slotId)).thenReturn(Optional.empty());
//        Slot updatedSlot = new Slot();
//        updatedSlot.setArea("New Area");
//
//        // Testing the controller method
//        ResponseEntity<Slot> responseEntity = slotController.updateSlot(slotId, updatedSlot);
//
//        // Assertions
//        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
//        assertNull(responseEntity.getBody());
//    }

    @Test
    void testDeleteSlot() {
        // Mocking data
        long slotId = 1L;
        when(slotRepository.findById(slotId)).thenReturn(Optional.of(new CarParks()));

        // Testing the controller method
        ResponseEntity<HttpStatus> responseEntity = slotController.deleteSlot(slotId);

        // Assertions
        assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
    }

    @Test
    void testDeleteSlotNotFound() {
        // Mocking data
        long slotId = 1L;
        when(slotRepository.findById(slotId)).thenReturn(Optional.empty());

        // Testing the controller method
        ResponseEntity<HttpStatus> responseEntity = slotController.deleteSlot(slotId);

        // Assertions
        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
    }
}
