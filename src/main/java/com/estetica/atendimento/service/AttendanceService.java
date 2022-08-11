package com.estetica.atendimento.service;

import java.io.IOException;
import java.net.URI;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.estetica.atendimento.exception.ErrorGeneral;
import com.estetica.atendimento.model.Attendance;
import com.estetica.atendimento.model.Patient;
import com.estetica.atendimento.repository.AttendanceRepository;
import com.estetica.atendimento.repository.PatientRepository;



@Service
@Transactional
public class AttendanceService {
	
	@Autowired
	AttendanceRepository attendanceRepo;
	
	@Autowired
	PatientRepository patientRepo;
	
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
		
		attendance.setDateAttendance(LocalDate.now());;
		attendance.setPatient(optionalPatient.get());;
		attendanceRepo.save(attendance);
		return "Atendimento criado com sucesso";
	}
	
}
