package com.relation.relation.controller;

import com.relation.relation.model.SeatModel;
import com.relation.relation.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seat")
public class SeatController {
    @Autowired
    SeatRepository seatRepository;

    @GetMapping("/")
    private List<SeatModel> getAll(){
        return seatRepository.findAll();
    }
    @PostMapping("/insert")
    private String insert(@RequestBody SeatModel seat){
        seatRepository.save(seat);
        return "Pelanggan berhasil di tambahkan";
    }
}
