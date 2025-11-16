package co.nz.csoft.elasticsearch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.nz.csoft.elasticsearch.dto.ExternalReservationDto;
import co.nz.csoft.elasticsearch.service.BookingService;
/*
@RestController
@RequestMapping("/api/booking")
public class BookingController {
	@Autowired
	private BookingService bookingService;
	
	@PostMapping("/create")
    public ResponseEntity<String> createReservation(@RequestBody ExternalReservationDto externalReservationDto) {
        try {
        	bookingService.createReservationThmToHyp(externalReservationDto);
            return new ResponseEntity<>("Reservation creation initiated successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Failed to initiate reservation creation: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
*/