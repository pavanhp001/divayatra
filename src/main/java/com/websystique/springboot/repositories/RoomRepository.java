package com.websystique.springboot.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.websystique.springboot.model.Room;

public interface RoomRepository extends JpaRepository<Room, Long> {

	@Query("SELECT r FROM Room r WHERE LOWER(r.id) = LOWER(:id)")
    public Room findByName(@Param("id") Long id);
	
	@Query("SELECT r FROM Room r WHERE LOWER(r.building_id) = LOWER(:id)")
    public List<Room> findByBuildingId(@Param("id") Long id);
}
