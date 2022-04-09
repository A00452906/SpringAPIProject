package com.APIProject.SpringBoot;

import java.util.List;

import dao.Response;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import models.Bookingdetails;
import models.Hotel_New;
import service.Hotel_Service;



@RestController
@RequestMapping("/")
public class HotelController {
	 @Autowired
     Hotel_Service hotelService;
	 
	 @GetMapping("/HotelList")
	 public ResponseEntity<List<Hotel_New>> getAllHotels() {
	System.out.println("HotelList");
    List<Hotel_New> hotelList = hotelService.getAllHotels();
    return new ResponseEntity<>(hotelList, HttpStatus.OK);
	 }

	 @PostMapping("/HotelBook")
	 public ResponseEntity<Response> addBooking(@RequestBody Bookingdetails Booking) {
	System.out.println("***********"+Booking);
    String message = hotelService.createBooking(Booking);
    return new ResponseEntity(new Response(message), HttpStatus.CREATED);
	 }
}

