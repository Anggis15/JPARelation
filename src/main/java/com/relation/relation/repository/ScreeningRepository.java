package com.relation.relation.repository;

import com.relation.relation.model.ScreeningCustomQuery;
import com.relation.relation.model.ScreeningModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.util.List;

public interface ScreeningRepository extends JpaRepository<ScreeningModel, Long> {
    List<ScreeningModel> findByScreeningDate(Date date);

    @Query(value = "select screening_date, film_name from screening inner join film on screening.film_id = film.film_id", nativeQuery = true)
    List<ScreeningCustomQuery> getDateFilm();


}
