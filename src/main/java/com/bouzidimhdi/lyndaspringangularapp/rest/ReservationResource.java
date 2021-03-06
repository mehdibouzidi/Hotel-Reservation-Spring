package com.bouzidimhdi.lyndaspringangularapp.rest;

import com.bouzidimhdi.lyndaspringangularapp.model.request.ReservationRequest;
import com.bouzidimhdi.lyndaspringangularapp.model.response.ReservationResponse;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

import static com.bouzidimhdi.lyndaspringangularapp.rest.ResourceConstants.ROOM_RESERVATION_V1;

@RestController
@RequestMapping(ROOM_RESERVATION_V1)
public class ReservationResource {

    @RequestMapping(path= "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<ReservationResponse> getAvailableRooms(
            @RequestParam( value = "checkin")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                    LocalDate checkin,
            @RequestParam( value = "checkout")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                    LocalDate checkout){

        return new ResponseEntity<>(new ReservationResponse(), HttpStatus.OK);
    }

    @RequestMapping(path = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE )
    public ResponseEntity<ReservationResponse> createReservation(
            @RequestBody
                    ReservationRequest reservationRequest){
        return new ResponseEntity<>(new ReservationResponse(), HttpStatus.CREATED);
    }

    @RequestMapping(path = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE )
    public ResponseEntity<ReservationResponse> updateReservation(
            @RequestBody
                    ReservationRequest reservationRequest){
        return new ResponseEntity<>(new ReservationResponse(), HttpStatus.OK);
    }

    @RequestMapping(path = "/{reservationId}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteReservation(
            @PathVariable
            long reservationId){
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
