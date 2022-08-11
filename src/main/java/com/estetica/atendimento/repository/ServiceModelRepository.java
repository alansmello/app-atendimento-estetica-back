package com.estetica.atendimento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estetica.atendimento.model.ServiceModel;

public interface ServiceModelRepository extends JpaRepository<ServiceModel, Integer> {
    
}
