package com.relation.relation.repository;

import com.relation.relation.model.FilmModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<FilmModel, Long> {
}
