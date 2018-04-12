package com.websystique.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springboot.model.Building;
import com.websystique.springboot.repositories.BuildingRepository;

@Service("buildingService")
@Transactional
public class BuildingServiceImpl implements BuildingService {

	@Autowired
	private BuildingRepository buildingRepository;
	
	@Override
	public Building findById(Long id) {
		return buildingRepository.findOne(id);
	}

	@Override
	public Building findByName(String name) {
		return buildingRepository.findByName(name);
		//return new Building();
	}

	@Override
	public Building saveBuilding(Building building) {
		
		try {
			if(building != null && building.getAddr_city() != null 
					&& building.getAddr_no() != null 
					&& building.getBuilding_name() != null){
				building.setBuilding_img_path(building.getAddr_city()+"_"+building.getAddr_no()+"_"+building.getBuilding_name().replaceAll(" ", "_"));
			}
			
			return buildingRepository.save(building);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

	@Override
	public void updateBuilding(Building user) {
		saveBuilding(user);
		
	}

	@Override
	public void deleteBuildingById(Long id) {
		buildingRepository.delete(id);
		
	}

	@Override
	public void deleteAllBuildings() {
		buildingRepository.deleteAll();
		
	}

	@Override
	public List<Building> findAllBuildings() {
		return buildingRepository.findAll();
	}

	@Override
	public boolean isBuildingExist(Building building) {
		return findByName(building.getBuilding_name()) != null;
	}

}
