package com.relation.relation.controller;

import com.relation.relation.model.RoomModel;
import com.relation.relation.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomController {
    @Autowired
    RoomRepository roomRepository;

    @GetMapping("/")
    private List<RoomModel> getAll(){
        return roomRepository.findAll();
    }
    @PostMapping("/insert")
    private String insertRoom(@RequestBody RoomModel room){
        roomRepository.save(room);
        return "Selamat room berhasil di simpan";
    }
}
