package com.estetica.atendimento.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "service")
public class ServiceModel {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

    private String name;

    @JsonIgnore
    @OneToMany(mappedBy="service")
    private List<Attendance> attendance;


    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Attendance> getAttendance() {
        return this.attendance;
    }

    public void setAttendance(List<Attendance> attendance) {
        this.attendance = attendance;
    }

    
}
