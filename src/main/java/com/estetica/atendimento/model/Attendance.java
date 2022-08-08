package com.estetica.atendimento.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Attendance {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

    private LocalDateTime dateAttendance;

    @ManyToOne
    private Patient patient;

    @Lob
    private String description;

    @OneToMany(mappedBy="attendance")
	private List<Image> photos;


    public Integer getId() {
        return this.id;
    }


    public LocalDateTime getDateAttendance() {
        return this.dateAttendance;
    }

    public void setDateAttendance(LocalDateTime dateAttendance) {
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

    public List<Image> getPhotos() {
        return this.photos;
    }

    public void setPhotos(List<Image> photos) {
        this.photos = photos;
    }



    
}
