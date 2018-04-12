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

import com.websystique.springboot.model.Room;
import com.websystique.springboot.service.RoomService;
import com.websystique.springboot.util.CustomErrorType;

@RestController
@RequestMapping("/room")
public class RoomApiController {
	
	public static final Logger logger = LoggerFactory.getLogger(RestApiController.class);

	@Autowired
	RoomService roomService; //Service which will do all data retrieval/manipulation work

	// -------------------Retrieve All Rooms---------------------------------------------

	@RequestMapping(value = "/listall/", method = RequestMethod.GET)
	public ResponseEntity<List<Room>> listAllRooms() {
		List<Room> rooms = roomService.findAllRooms();
		
		return new ResponseEntity<List<Room>>(rooms, HttpStatus.OK);
	}

	// -------------------Retrieve Single Room------------------------------------------

	@RequestMapping(value = "/listbyid/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getRoom(@PathVariable("id") long id) {
		logger.info("Fetching Room with id {}", id);
		Room room = roomService.findById(id);
		if (room == null) {
			logger.error("Room with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("Room with id " + id 
					+ " not found"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Room>(room, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/listRoomsByBuildingId/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getRoomByBuildingId(@PathVariable("id") long id) {
		logger.info("Fetching Room with BuildingId {}", id);
		List<Room> rooms = roomService.findByBuildingId(id);
		if (rooms == null) {
			logger.error("Room with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("Room with id " + id 
					+ " not found"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Room>>(rooms, HttpStatus.OK);
	}

	// -------------------Create a Room-------------------------------------------

	@RequestMapping(value = "/createRoom/", method = RequestMethod.POST)
	public ResponseEntity<?> createRoom(@RequestBody Room room, UriComponentsBuilder ucBuilder) {
		logger.info("Creating Room : {}", room);

		if (roomService.isRoomExist(room)) {
			logger.error("Unable to create. A Room with name {} already exist", room.getRoom_no());
			return new ResponseEntity(new CustomErrorType("Unable to create. A Room with name " + 
			room.getRoom_no() + " already exist."),HttpStatus.CONFLICT);
		}
		roomService.saveRoom(room);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/Room/{id}").buildAndExpand(room.getId()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

	// ------------------- Update a Room ------------------------------------------------

	@RequestMapping(value = "/updateRoom/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateRoom(@PathVariable("id") long id, @RequestBody Room room) {
		logger.info("Updating Room with id {}", id);

		Room currentRoom = roomService.findById(id);

		if (currentRoom == null) {
			logger.error("Unable to update. Room with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("Unable to upate. Room with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}

		currentRoom.setPriceper_day(room.getPriceper_day());
		currentRoom.setRoom_img_path(room.getRoom_img_path());
		currentRoom.setRoom_no(room.getRoom_no());
		currentRoom.setRoom_type(room.getRoom_type());

		roomService.updateRoom(currentRoom);
		return new ResponseEntity<Room>(currentRoom, HttpStatus.OK);
	}

	// ------------------- Delete a Room-----------------------------------------

	@RequestMapping(value = "/deleteRoom/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteRoom(@PathVariable("id") long id) {
		logger.info("Fetching & Deleting Room with id {}", id);

		Room room = roomService.findById(id);
		if (room == null) {
			logger.error("Unable to delete. Room with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("Unable to delete. Room with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}
		roomService.deleteRoomById(id);
		return new ResponseEntity<Room>(HttpStatus.NO_CONTENT);
	}

	// ------------------- Delete All Rooms-----------------------------

	@RequestMapping(value = "/deleteAllRoom/", method = RequestMethod.DELETE)
	public ResponseEntity<Room> deleteAllRooms() {
		logger.info("Deleting All Rooms");

		roomService.deleteAllRooms();
		return new ResponseEntity<Room>(HttpStatus.NO_CONTENT);
	}

}
