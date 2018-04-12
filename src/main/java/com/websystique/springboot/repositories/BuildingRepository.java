package com.websystique.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.websystique.springboot.model.Building;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface BuildingRepository extends JpaRepository<Building, Long> {

	//Building findByName(String name);
	@Query("SELECT b FROM Building b WHERE LOWER(b.building_name) = LOWER(:building_name)")
    public Building findByName(@Param("building_name") String building_name);
}
