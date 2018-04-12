package com.websystique.springboot.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="ROOM")
public class Room implements Serializable{

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;

	@NotEmpty
	@Column(name="ROOM_TYPE")
	private String room_type;
	
	@NotEmpty
	@Column(name="ROOM_NO", unique=true)
	private String room_no;

	@Column(name="PRICEPER_DAY")
	private Double priceper_day;

	@Column(name="ROOM_IMG_PATH")
	private String room_img_path;
	
	@Column(name="ISACTIVE")
	private Boolean isActive;
	
	
	//@ManyToOne(fetch=FetchType.LAZY) //, cascade = CascadeType.ALL
	@ManyToOne(optional = false)
    @JoinColumn(name="BUILDING_ID")
	private Building building_id;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Double getPriceper_day() {
		return priceper_day;
	}


	public void setPriceper_day(Double priceper_day) {
		this.priceper_day = priceper_day;
	}


	public String getRoom_img_path() {
		return room_img_path;
	}


	public void setRoom_img_path(String room_img_path) {
		this.room_img_path = room_img_path;
	}


	public Building getBuilding_id() {
		return building_id;
	}


	public void setBuilding_id(Building building_id) {
		this.building_id = building_id;
	}


	public String getRoom_type() {
		return room_type;
	}


	public void setRoom_type(String room_type) {
		this.room_type = room_type;
	}


	public String getRoom_no() {
		return room_no;
	}


	public void setRoom_no(String room_no) {
		this.room_no = room_no;
	}


	public Boolean getIsActive() {
		return isActive;
	}


	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((building_id == null) ? 0 : building_id.hashCode());
		result = prime * result + ((room_type == null) ? 0 : room_type.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((priceper_day == null) ? 0 : priceper_day.hashCode());
		result = prime * result + ((room_img_path == null) ? 0 : room_img_path.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Room other = (Room) obj;
		if (building_id == null) {
			if (other.building_id != null)
				return false;
		} else if (!building_id.equals(other.building_id))
			return false;
		if (room_type == null) {
			if (other.room_type != null)
				return false;
		} else if (!room_type.equals(other.room_type))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (priceper_day == null) {
			if (other.priceper_day != null)
				return false;
		} else if (!priceper_day.equals(other.priceper_day))
			return false;
		if (room_img_path == null) {
			if (other.room_img_path != null)
				return false;
		} else if (!room_img_path.equals(other.room_img_path))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Room [id=" + id + ", room_type=" + room_type + ", priceper_day=" + priceper_day + ""
				+ ", room_img_path=" + room_img_path + ", building_id=" + building_id + "]";
	}
	
	
}
