package com.websystique.springboot.service;

import java.util.List;

import com.websystique.springboot.model.Building;

public interface BuildingService {
	
	Building findById(Long id);

	Building findByName(String name);

	Building saveBuilding(Building user);

	void updateBuilding(Building user);

	void deleteBuildingById(Long id);

	void deleteAllBuildings();

	List<Building> findAllBuildings();

	boolean isBuildingExist(Building user);

}
