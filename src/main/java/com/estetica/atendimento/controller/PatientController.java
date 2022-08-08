package com.estetica.atendimento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estetica.atendimento.exception.ErrorGeneral;
import com.estetica.atendimento.model.Patient;
import com.estetica.atendimento.service.PatientService;


@RestController
@RequestMapping("/patient")
public class PatientController {
	
	@Autowired
	PatientService patientService;
	
	@GetMapping("/getAllPatient")
	public ResponseEntity<List<Patient>> listarTodos() throws ErrorGeneral {
		return ResponseEntity.ok(patientService.listarTodos());
	}
	
	@PostMapping("/addPatient")
	public ResponseEntity<String> adicionar(@RequestBody Patient patient) throws ErrorGeneral {
		return ResponseEntity.ok(patientService.adicionar(patient));
	}
	
	@PutMapping("/editPatient/{id}")
	public ResponseEntity<String> editar(@RequestBody Patient patient, @PathVariable Integer id) throws ErrorGeneral {
		return ResponseEntity.ok(patientService.editar(patient, id));
	}
	
	@DeleteMapping("/deletePatient/{id}")
	public ResponseEntity<String> deletar(@PathVariable Integer id) throws ErrorGeneral {
		return ResponseEntity.ok(patientService.deletar(id));
	}

}
