package com.estetica.atendimento.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estetica.atendimento.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
	
    Optional<Patient> findByEmail(String email);

}
