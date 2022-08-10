package com.estetica.atendimento.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Patient {
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotBlank
	private String name;

	@NotBlank
	private String whatsapp;

	@Email
	private String email;

	@JsonIgnore
	@OneToMany(mappedBy="patient")
	private List<Attendance> attendances; 


	public Integer getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWhatsapp() {
		return this.whatsapp;
	}

	public void setWhatsapp(String whatsapp) {
		this.whatsapp = whatsapp;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Attendance> getAttendances() {
		return this.attendances;
	}

	public void setAttendances(List<Attendance> attendances) {
		this.attendances = attendances;
	}




    
}
