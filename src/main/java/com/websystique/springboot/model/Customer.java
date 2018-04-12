package com.websystique.springboot.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="CUSTOMER")
public class Customer implements Serializable{

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="FIRST_NAME", length = 20)
	private String first_name;
	
	@Column(name="LAST_NAME", length = 20)
	private String last_name;

	@Column(name="PHONE_NO", length = 20)
	private String phone_no;

	@Temporal(value=TemporalType.TIMESTAMP)
	@Column(name="ARRIVE_DATE")
	private Date arrive_date;
	
	@Temporal(value=TemporalType.TIMESTAMP)
	@Column(name="DISPATCH_DATE")
	private Date dispatch_date;
	
	@Column(name="DAYS")
	private int days;
	
	@Column(name="HAVE_CAR", length = 1)
	private String have_car;
	
	@Column(name="CAR_NO", length = 10)
	private String car_no;
	
	@Column(name="GENDER", length = 1)
	private String gender;
	
	@Column(name="EMAIL", length = 30)
	private String email;
	
	@Column(name="EMERGENCY_CONTACT_NO", length = 20)
	private String emergency_contact_no;
	
	//@OneToOne(cascade = CascadeType.ALL)
	@ManyToOne(optional = false)
    @JoinColumn(name = "room_id")
	private Room room_id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getPhone_no() {
		return phone_no;
	}

	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}

	public Date getArrive_date() {
		return arrive_date;
	}

	public void setArrive_date(Date arrive_date) {
		this.arrive_date = arrive_date;
	}

	public String getHave_car() {
		return have_car;
	}

	public void setHave_car(String have_car) {
		this.have_car = have_car;
	}

	public String getCar_no() {
		return car_no;
	}

	public void setCar_no(String car_no) {
		this.car_no = car_no;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmergency_contact_no() {
		return emergency_contact_no;
	}

	public void setEmergency_contact_no(String emergency_contact_no) {
		this.emergency_contact_no = emergency_contact_no;
	}

	public Room getRoom_id() {
		return room_id;
	}

	public void setRoom_id(Room room_id) {
		this.room_id = room_id;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public Date getDispatch_date() {
		return dispatch_date;
	}

	public void setDispatch_date(Date dispatch_date) {
		this.dispatch_date = dispatch_date;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((arrive_date == null) ? 0 : arrive_date.hashCode());
		result = prime * result + ((car_no == null) ? 0 : car_no.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((emergency_contact_no == null) ? 0 : emergency_contact_no.hashCode());
		result = prime * result + ((first_name == null) ? 0 : first_name.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((have_car == null) ? 0 : have_car.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((last_name == null) ? 0 : last_name.hashCode());
		result = prime * result + ((phone_no == null) ? 0 : phone_no.hashCode());
		result = prime * result + ((room_id == null) ? 0 : room_id.hashCode());
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
		Customer other = (Customer) obj;
		if (arrive_date == null) {
			if (other.arrive_date != null)
				return false;
		} else if (!arrive_date.equals(other.arrive_date))
			return false;
		if (car_no == null) {
			if (other.car_no != null)
				return false;
		} else if (!car_no.equals(other.car_no))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (emergency_contact_no == null) {
			if (other.emergency_contact_no != null)
				return false;
		} else if (!emergency_contact_no.equals(other.emergency_contact_no))
			return false;
		if (first_name == null) {
			if (other.first_name != null)
				return false;
		} else if (!first_name.equals(other.first_name))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (have_car == null) {
			if (other.have_car != null)
				return false;
		} else if (!have_car.equals(other.have_car))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (last_name == null) {
			if (other.last_name != null)
				return false;
		} else if (!last_name.equals(other.last_name))
			return false;
		if (phone_no == null) {
			if (other.phone_no != null)
				return false;
		} else if (!phone_no.equals(other.phone_no))
			return false;
		if (room_id == null) {
			if (other.room_id != null)
				return false;
		} else if (!room_id.equals(other.room_id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", phone_no="
				+ phone_no + ", arrive_date=" + arrive_date + ", have_car=" + have_car + ", car_no=" + car_no
				+ ", gender=" + gender + ", email=" + email + ", emergency_contact_no=" + emergency_contact_no
				+ ", room_id=" + room_id + "]";
	}
	
	
	
}

