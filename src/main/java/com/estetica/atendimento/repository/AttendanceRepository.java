package com.estetica.atendimento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estetica.atendimento.model.Attendance;

public interface AttendanceRepository extends JpaRepository<Attendance, Integer> {

}
