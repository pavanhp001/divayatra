package com.websystique.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.websystique.springboot.model.Room;
import com.websystique.springboot.repositories.RoomRepository;

public interface RoomService {
	
	
	public Room findById(Long id) ;
	public Room findByName(Long name) ;
	public void saveRoom(Room user) ;
	public void updateRoom(Room user) ;
	public void deleteRoomById(Long id);
	public void deleteAllRooms() ;
	public List<Room> findAllRooms() ;
	public boolean isRoomExist(Room room) ;
	public List<Room> findByBuildingId(Long id);


}
