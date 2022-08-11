package com.estetica.atendimento.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Attendance {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

    private LocalDate dateAttendance;

    @ManyToOne()
    private Patient patient;

    @Lob
    private String description;
    
    private String url;

    @ManyToOne
    private ServiceModel service;
    
    @OneToMany(mappedBy="attendance")
	 private List<Image> photos;

    public Integer getId() {
        return this.id;
    }


    public LocalDate getDateAttendance() {
        return this.dateAttendance;
    }

    public void setDateAttendance(LocalDate dateAttendance) {
        this.dateAttendance = dateAttendance;
    }

    public Patient getPatient() {
        return this.patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    
}
