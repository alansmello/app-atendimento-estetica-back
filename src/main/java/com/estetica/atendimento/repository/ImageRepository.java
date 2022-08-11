package com.estetica.atendimento.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estetica.atendimento.model.Image;


public interface ImageRepository extends JpaRepository<Image, Integer> {
	
	public List<Image> findByAttendanceId(Integer attendance_id);

}
