package com.relation.relation.repository;

import com.relation.relation.model.ScreeningModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface ScreeningRepository extends JpaRepository<ScreeningModel, Long> {
    List<ScreeningModel> findByScreeningDate(Date date);
}
