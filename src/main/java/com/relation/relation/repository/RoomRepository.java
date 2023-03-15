package com.relation.relation.repository;

import com.relation.relation.model.RoomModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<RoomModel, String> {
}
