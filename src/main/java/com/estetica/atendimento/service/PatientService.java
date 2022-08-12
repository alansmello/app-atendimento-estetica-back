package com.estetica.atendimento.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estetica.atendimento.exception.ErrorGeneral;
import com.estetica.atendimento.model.Patient;
import com.estetica.atendimento.repository.PatientRepository;

@Service
public class PatientService {
	
	@Autowired
	PatientRepository patientRepo;
	
	public List<Patient> listarTodos() {
		return patientRepo.findAll();
	}
	
	public String adicionar(Patient patient) throws ErrorGeneral {

		if (patient.getName() == null || patient.getName().equals("")) {
			throw new ErrorGeneral("O nome do paciente tem que ser informado!");
		}
		
		if (patient.getWhatsapp() == null || patient.getWhatsapp().equals("")) {
			throw new ErrorGeneral("O WhatsApp do paciente tem que ser informado");
		}
		
		if (patient.getEmail() == null || patient.getEmail().equals("")) {
			throw new ErrorGeneral("O Email do paciente tem que ser informado");
		}
		if (patient.getBirthday() == null) {
			throw new ErrorGeneral("A Data de aniversario nao pode ser nulo");
		}
		
		
		patient.setName(patient.getName().toUpperCase());
		patientRepo.save(patient);

		return "Paciente criado com sucesso";
	}
	
	public String editar(Patient patient, Integer id) throws ErrorGeneral {

		Optional<Patient> optional = patientRepo.findById(id);
		if (optional.isEmpty()) {
			throw new ErrorGeneral("Esse Paciente não existe!");
		}
		
		Patient oldPatient = optional.get();
		
		if (patient.getName() != null && !patient.getName().equals("")) {
			oldPatient.setName(patient.getName());
		}
		
		if (patient.getWhatsapp() != null && !patient.getWhatsapp().equals("")) {
			oldPatient.setWhatsapp(patient.getWhatsapp());
		}
		
		if (patient.getEmail() != null && !patient.getEmail().equals("")) {
			oldPatient.setEmail(patient.getEmail());
		}

		patientRepo.save(oldPatient);
		return "Paciente alterado com sucesso";

	}
	
	public String deletar(Integer id) throws ErrorGeneral {

        Optional<Patient> optional = patientRepo.findById(id);
        if (optional.isEmpty()) {
            throw new ErrorGeneral("Esse Paciente não existe!");
        }
        patientRepo.deleteById(id);
        return "Paciente deletado com sucesso";
    }

 
}
