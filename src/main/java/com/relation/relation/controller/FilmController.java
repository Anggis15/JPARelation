package com.relation.relation.controller;

import com.relation.relation.model.FilmModel;
import com.relation.relation.model.GetCustomQueryFilm;
import com.relation.relation.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/film")
public class FilmController {
    @Autowired
    FilmRepository filmRepository;
    @GetMapping("/")
    private List<FilmModel> getAllFilm(){
        return filmRepository.findAll();
    }
    @PostMapping("/insert")
    private String insertFilm(@RequestBody FilmModel film){
        filmRepository.save(film);
        return "Film sudah berhasil di tambahkan";
    }

    @GetMapping("/custom")
    private List<GetCustomQueryFilm> getAllData(){
        return filmRepository.getAllFilmNameCategory();
    }
}
