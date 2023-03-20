package com.relation.relation.repository;

import com.relation.relation.model.FilmModel;
import com.relation.relation.model.GetCustomQueryFilm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FilmRepository extends JpaRepository<FilmModel, Long> {
    @Query(value = "SELECT film_name, category FROM film", nativeQuery = true)
    List<GetCustomQueryFilm> getAllFilmNameCategory();
}
