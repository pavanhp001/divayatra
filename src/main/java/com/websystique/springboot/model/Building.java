package com.websystique.springboot.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="BUILDING")
public class Building implements Serializable{

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;

	@NotEmpty
	@Column(name="BUILDING_NAME", length = 50)
	private String building_name;

	@Column(name="NEAR_TEMPLE", length = 50)
	private String near_temple;

	@Column(name="DESTENCE_FROM_TEMPLE")
	private float destence_from_temple;
	
	@Column(name="ADDR_NO", length = 10)
	private String addr_no;
	
	@Column(name="ADDR_CITY", length = 20)
	private String addr_city;
	
	@Column(name="ADDR_DIST", length = 20)
	private String addr_dist;
	
	@Column(name="ADDR_STATE", length = 20)
	private String addr_state;
	
	@Column(name="ADDR_COUNTRY", length = 20)
	private String addr_country;
	
	@Column(name="PARKING_LOT", length = 1)
	private String parking_lot;
	
	@Column(name="BUILDING_IMG_PATH")
	private String building_img_path;
	
	@Column(name="COMMENT")
	private String comment;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBuilding_name() {
		return building_name;
	}

	public void setBuilding_name(String building_name) {
		this.building_name = building_name;
	}

	public String getNear_temple() {
		return near_temple;
	}

	public void setNear_temple(String near_temple) {
		this.near_temple = near_temple;
	}

	public float getDestence_from_temple() {
		return destence_from_temple;
	}

	public void setDestence_from_temple(float destence_from_temple) {
		this.destence_from_temple = destence_from_temple;
	}

	public String getAddr_no() {
		return addr_no;
	}

	public void setAddr_no(String addr_no) {
		this.addr_no = addr_no;
	}

	public String getAddr_city() {
		return addr_city;
	}

	public void setAddr_city(String addr_city) {
		this.addr_city = addr_city;
	}

	public String getAddr_dist() {
		return addr_dist;
	}

	public void setAddr_dist(String addr_dist) {
		this.addr_dist = addr_dist;
	}

	public String getAddr_state() {
		return addr_state;
	}

	public void setAddr_state(String addr_state) {
		this.addr_state = addr_state;
	}

	public String getAddr_country() {
		return addr_country;
	}

	public void setAddr_country(String addr_country) {
		this.addr_country = addr_country;
	}

	public String getParking_lot() {
		return parking_lot;
	}

	public void setParking_lot(String parking_lot) {
		this.parking_lot = parking_lot;
	}

	public String getBuilding_img_path() {
		return building_img_path;
	}

	public void setBuilding_img_path(String building_img_path) {
		this.building_img_path = building_img_path;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addr_city == null) ? 0 : addr_city.hashCode());
		result = prime * result + ((addr_country == null) ? 0 : addr_country.hashCode());
		result = prime * result + ((addr_dist == null) ? 0 : addr_dist.hashCode());
		result = prime * result + ((addr_no == null) ? 0 : addr_no.hashCode());
		result = prime * result + ((addr_state == null) ? 0 : addr_state.hashCode());
		result = prime * result + ((building_img_path == null) ? 0 : building_img_path.hashCode());
		result = prime * result + ((building_name == null) ? 0 : building_name.hashCode());
		result = prime * result + Float.floatToIntBits(destence_from_temple);
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((near_temple == null) ? 0 : near_temple.hashCode());
		result = prime * result + ((parking_lot == null) ? 0 : parking_lot.hashCode());
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
		Building other = (Building) obj;
		if (addr_city == null) {
			if (other.addr_city != null)
				return false;
		} else if (!addr_city.equals(other.addr_city))
			return false;
		if (addr_country == null) {
			if (other.addr_country != null)
				return false;
		} else if (!addr_country.equals(other.addr_country))
			return false;
		if (addr_dist == null) {
			if (other.addr_dist != null)
				return false;
		} else if (!addr_dist.equals(other.addr_dist))
			return false;
		if (addr_no == null) {
			if (other.addr_no != null)
				return false;
		} else if (!addr_no.equals(other.addr_no))
			return false;
		if (addr_state == null) {
			if (other.addr_state != null)
				return false;
		} else if (!addr_state.equals(other.addr_state))
			return false;
		if (building_img_path == null) {
			if (other.building_img_path != null)
				return false;
		} else if (!building_img_path.equals(other.building_img_path))
			return false;
		if (building_name == null) {
			if (other.building_name != null)
				return false;
		} else if (!building_name.equals(other.building_name))
			return false;
		if (Float.floatToIntBits(destence_from_temple) != Float.floatToIntBits(other.destence_from_temple))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (near_temple == null) {
			if (other.near_temple != null)
				return false;
		} else if (!near_temple.equals(other.near_temple))
			return false;
		if (parking_lot == null) {
			if (other.parking_lot != null)
				return false;
		} else if (!parking_lot.equals(other.parking_lot))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Building [id=" + id + ", building_name=" + building_name + ", near_temple=" + near_temple
				+ ", destence_from_temple=" + destence_from_temple + ", addr_no=" + addr_no + ", addr_city=" + addr_city
				+ ", addr_dist=" + addr_dist + ", addr_state=" + addr_state + ", addr_country=" + addr_country
				+ ", parking_lot=" + parking_lot + ", building_img_path=" + building_img_path + "]";
	}

	
}
