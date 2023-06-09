package com.relation.relation.controller;

import com.relation.relation.model.BookingModel;
import com.relation.relation.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookingController {
    @Autowired
    BookingRepository bookingRepository;

    @GetMapping("/")
    private List<BookingModel> getAll(){
        return bookingRepository.findAll();
    }
    @GetMapping("/{id}")
    private BookingModel getById(@PathVariable("id") long id){
        return bookingRepository.findById(id).get();
    }
    @PostMapping("/")
    private String saveData(@RequestBody BookingModel model){
        bookingRepository.save(model);
        return "Data BErhasil Di Simpan";
    }

    @GetMapping("/cari/{nama}")
    private List<BookingModel> getByFristName(@PathVariable("nama") String nama){
        return bookingRepository.findByCustomerIdFristName(nama);
    }
    @GetMapping("/maxofseat/{seat}")
    private List<BookingModel> getByMaxOfSeat(@PathVariable("seat") String seat){
        return bookingRepository.findByScreeningIdRoomIdMaxOfSeat(seat);
    }
    @GetMapping("/category/{cat}")
    private List<BookingModel> getByCategory(@PathVariable("cat") String cat){
        return bookingRepository.findByScreeningIdFilmIdCategory(cat);
    }
}
