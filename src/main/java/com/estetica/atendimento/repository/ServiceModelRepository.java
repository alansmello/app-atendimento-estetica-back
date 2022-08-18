package com.estetica.atendimento.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.estetica.atendimento.model.Patient;
import com.estetica.atendimento.model.ServiceModel;

public interface ServiceModelRepository extends JpaRepository<ServiceModel, Integer> {
	
    @Query("SELECT s FROM ServiceModel s WHERE s.name LIKE %:name% ")
    List<ServiceModel> findByName(String name); 
    
//    //SELECT patient FROM   patient WHERE  patient.name LIKE '%MELLO%';
//    @Query("SELECT p FROM Patient p WHERE p.name LIKE %:name% ")
//    List<Patient> findByName(String name); 
    
}
