package com.estetica.atendimento.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Attendance {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

    private LocalDateTime dateAttendance;

    private Patient patient;

    @Lob
    private String description;

    
    
}
