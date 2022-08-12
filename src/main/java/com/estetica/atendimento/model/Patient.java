package com.estetica.atendimento.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
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

	@Column(unique=true)
	@NotBlank(message = "Campo nao informado")
	private String name;

	@Column(unique=true)
	@NotBlank(message = "Campo nao informado")
	private String whatsapp;
	
	@Column(unique=true)
	@Email(message = "O email deve ser valido")
	private String email;

	private LocalDate birthday;



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



	public LocalDate getBirthday() {
		return this.birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public List<Attendance> getAttendances() {
		return this.attendances;
	}

	public void setAttendances(List<Attendance> attendances) {
		this.attendances = attendances;
	}




    
}
