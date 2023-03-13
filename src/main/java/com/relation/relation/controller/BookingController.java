package com.relation.relation.controller;

import com.relation.relation.model.BookingModel;
import com.relation.relation.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookingController {
    @Autowired
    BookingRepository bookingRepository;

    @GetMapping("/")
    private List<BookingModel> getAll(){
        return bookingRepository.findAll();
    }
}
