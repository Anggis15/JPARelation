package com.relation.relation.repository;

import com.relation.relation.model.BookingModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<BookingModel, Long> {
    List<BookingModel> findByCustomerIdFristName(String name);
    List<BookingModel> findByScreeningIdRoomIdMaxOfSeat(String maxSeat);
    List<BookingModel> findByScreeningIdFilmIdCategory(String maxSeat);
}
