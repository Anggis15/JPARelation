package com.relation.relation.repository;

import com.relation.relation.model.BookingModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<BookingModel, Long> {
}
