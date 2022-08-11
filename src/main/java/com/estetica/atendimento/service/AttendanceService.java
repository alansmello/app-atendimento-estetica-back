package com.estetica.atendimento.service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estetica.atendimento.exception.ErrorGeneral;
import com.estetica.atendimento.model.Attendance;
import com.estetica.atendimento.model.Patient;
import com.estetica.atendimento.model.ServiceModel;
import com.estetica.atendimento.repository.AttendanceRepository;
import com.estetica.atendimento.repository.PatientRepository;
import com.estetica.atendimento.repository.ServiceModelRepository;



@Service
@Transactional
public class AttendanceService {
	
	@Autowired
	AttendanceRepository attendanceRepo;
	
	@Autowired
	PatientRepository patientRepo;
	
	@Autowired
	ServiceModelRepository serviceRepo;
	
	@Autowired
	ImageService imageService;

	@Transactional
	public List<Attendance> listarTodos() {
		return attendanceRepo.findAll();
	}
	
	@Transactional
	public String adicionar(Attendance attendance) throws ErrorGeneral, IOException {

		Optional<Patient> optionalPatient = patientRepo.findById(attendance.getPatient().getId());
		if (optionalPatient.isEmpty()) {
			throw new ErrorGeneral("Esse paciente não existe!");
		}
		
		Optional<ServiceModel> optionalService = serviceRepo.findById(attendance.getService().getId());
		if (optionalService.isEmpty()) {
			throw new ErrorGeneral("Esse tipo de serviço não existe!");
		}
		
		attendance.setDateAttendance(LocalDate.now());;
		attendance.setPatient(optionalPatient.get());;
		attendance.setService(optionalService.get());;
		attendanceRepo.save(attendance);
		return "Atendimento criado com sucesso";
	}
	
}
