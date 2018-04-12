package com.websystique.springboot.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.websystique.springboot.model.Building;
import com.websystique.springboot.model.User;
import com.websystique.springboot.service.BuildingService;
import com.websystique.springboot.util.CustomErrorType;

@RestController
@RequestMapping("/building")
public class BuildingApiController {
	
	public static final Logger logger = LoggerFactory.getLogger(RestApiController.class);

	@Autowired
	BuildingService buildingService; //Service which will do all data retrieval/manipulation work

	// -------------------Retrieve All Buildings---------------------------------------------

	@RequestMapping(value = "/listAllBuildings/", method = RequestMethod.GET)
	public ResponseEntity<List<Building>> listAllBuildings() {
		List<Building> buildings = buildingService.findAllBuildings();
		if (buildings.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<Building>>(buildings, HttpStatus.OK);
	}

	// -------------------Retrieve Single Building------------------------------------------

	@RequestMapping(value = "/getBuilding/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getBuilding(@PathVariable("id") long id) {
		logger.info("Fetching Building with id {}", id);
		Building building = buildingService.findById(id);
		if (building == null) {
			logger.error("Building with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("Building with id " + id 
					+ " not found"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Building>(building, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getBuildingsOnAddress/{add}", method = RequestMethod.GET)
	public ResponseEntity<?> getBuildingsOnAddress(@PathVariable("add") long id) {
		logger.info("getBuildingsOnAddress", id);
		Building building = buildingService.findById(id);
		if (building == null) {
			logger.error("Building with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("Building with id " + id 
					+ " not found"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Building>(building, HttpStatus.OK);
	}

	// -------------------Create a Building-------------------------------------------

	@RequestMapping(value = "/createBuilding/", method = RequestMethod.POST)
	public ResponseEntity<?> createBuilding(@RequestBody Building building, UriComponentsBuilder ucBuilder) {
		logger.info("createBuilding : {}", building);

		try {
			if (buildingService.isBuildingExist(building)) {
				logger.error("Unable to create. A Building with name {} already exist", building.getAddr_city());
				return new ResponseEntity(new CustomErrorType("Unable to create. A Building with name " + 
				building.getAddr_city() + " already exist."),HttpStatus.CONFLICT);
			}
			Building createdBuilding = buildingService.saveBuilding(building);

			/*HttpHeaders headers = new HttpHeaders();
			headers.setLocation(ucBuilder.path("/api/Building/{id}").buildAndExpand(building.getId()).toUri());*/
			return new ResponseEntity<Building>(createdBuilding, HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity(new CustomErrorType("Buildingis not created"), HttpStatus.NOT_FOUND);
	}

	// ------------------- Update a Building ------------------------------------------------

	@RequestMapping(value = "/updateBuilding/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateBuilding(@PathVariable("id") long id, @RequestBody Building building) {
		logger.info("Updating Building with id {}", id);

		Building currentbuilding = buildingService.findById(id);

		if (building == null) {
			logger.error("Unable to update. Building with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("Unable to upate. Building with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}

		currentbuilding.setAddr_city(building.getAddr_city());
		currentbuilding.setAddr_country(building.getAddr_country());
		currentbuilding.setAddr_dist(building.getAddr_dist());
		currentbuilding.setAddr_no(building.getAddr_no());
		currentbuilding.setAddr_state(building.getAddr_state());
		currentbuilding.setBuilding_img_path(building.getBuilding_img_path());
		currentbuilding.setBuilding_name(building.getBuilding_name());
		currentbuilding.setDestence_from_temple(building.getDestence_from_temple());
		currentbuilding.setNear_temple(building.getNear_temple());
		

		buildingService.updateBuilding(currentbuilding);
		return new ResponseEntity<Building>(currentbuilding, HttpStatus.OK);
	}

	// ------------------- Delete a Building-----------------------------------------

	@RequestMapping(value = "/deleteBuilding/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteBuilding(@PathVariable("id") long id) {
		logger.info("Fetching & Deleting Building with id {}", id);

		Building building = buildingService.findById(id);
		if (building == null) {
			logger.error("Unable to delete. Building with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("Unable to delete. Building with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}
		buildingService.deleteBuildingById(id);
		return new ResponseEntity<Building>(HttpStatus.NO_CONTENT);
	}

	// ------------------- Delete All Buildings-----------------------------

	@RequestMapping(value = "/deleteAllBuildings/", method = RequestMethod.DELETE)
	public ResponseEntity<Building> deleteAllBuildings() {
		logger.info("Deleting All Buildings");

		buildingService.deleteAllBuildings();
		return new ResponseEntity<Building>(HttpStatus.NO_CONTENT);
	}

}
