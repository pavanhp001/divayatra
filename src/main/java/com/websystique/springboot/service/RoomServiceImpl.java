package com.websystique.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springboot.model.Room;
import com.websystique.springboot.repositories.RoomRepository;

@Service("roomService")
@Transactional
public class RoomServiceImpl implements RoomService {
	
	@Autowired
	private RoomRepository roomRepository;
	
	@Override
	public Room findById(Long id) {
		return roomRepository.findOne(id);
	}

	@Override
	public Room findByName(Long id) {
		return roomRepository.findByName(id);
	}

	@Override
	public void saveRoom(Room room) {
		
		if(room != null && room.getBuilding_id() != null 
				&& room.getBuilding_id().getId() != null){
			
			room.setRoom_no(room.getBuilding_id().getId()+"-"+room.getRoom_no());
			room.setRoom_img_path("/"+room.getBuilding_id().getId()+"/"+room.getRoom_no());
		}
		
		roomRepository.save(room);
	}

	@Override
	public void updateRoom(Room user) {
		saveRoom(user);
	}

	@Override
	public void deleteRoomById(Long id) {
		roomRepository.delete(id);
	}

	@Override
	public void deleteAllRooms() {
		roomRepository.deleteAll();
	}

	@Override
	public List<Room> findAllRooms() {
		return roomRepository.findAll();
	}

	@Override
	public boolean isRoomExist(Room room) {
		return findByName(room.getId()) != null;
	}
	public List<Room> findByBuildingId(Long id){
		return roomRepository.findByBuildingId(id);
	}

}
