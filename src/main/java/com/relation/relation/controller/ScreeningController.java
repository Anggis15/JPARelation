package com.relation.relation.controller;

import com.relation.relation.model.ScreeningCustomQuery;
import com.relation.relation.model.ScreeningModel;
import com.relation.relation.repository.ScreeningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/screening")
public class ScreeningController {
    @Autowired
    ScreeningRepository screeningRepository;

    @GetMapping("/")
    private List<ScreeningModel> getAll(){
        return screeningRepository.findAll();
    }

    @PostMapping("/insert")
    private String insert(@RequestBody ScreeningModel screeningModel){
        screeningRepository.save(screeningModel);
        return "Screening berhasil di tambahkan";
    }
    @GetMapping("/{date}")
    private List<ScreeningModel> getByDate(@PathVariable("date") Date date){
        return screeningRepository.findByScreeningDate(date);
    }

    @GetMapping("/custom")
    private List<ScreeningCustomQuery> getDateName(){
        return screeningRepository.getDateFilm();
    }
}
