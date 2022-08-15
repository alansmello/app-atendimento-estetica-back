package com.estetica.atendimento.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.estetica.atendimento.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
	
    Optional<Patient> findByEmail(String email);

    //SELECT patient FROM   patient WHERE  patient.name LIKE '%MELLO%';
    @Query("SELECT p FROM Patient p WHERE p.name LIKE %:name% ")
    List<Patient> findByName(String name); 

}
