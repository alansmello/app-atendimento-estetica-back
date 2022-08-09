package com.estetica.atendimento.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.estetica.atendimento.exception.ErrorGeneral;
import com.estetica.atendimento.model.Attendance;
import com.estetica.atendimento.model.Image;
import com.estetica.atendimento.service.AttendanceService;
import com.estetica.atendimento.service.ImageService;



@RestController
@RequestMapping("/attendance")
public class AttendanceController {
	
	@Autowired
	AttendanceService attendanceService;
	
	@Autowired
	ImageService imageService;
	
	@GetMapping("/getAllAttendance")
	public ResponseEntity<List<Attendance>> listarTodos() throws ErrorGeneral {
		return ResponseEntity.ok(attendanceService.listarTodos());
	}
	
	@GetMapping("/{id}/imagem")
	public ResponseEntity<byte[]> getImagem(@PathVariable Integer id) {
		Image image = imageService.buscar(id);
		HttpHeaders headers = new HttpHeaders();
		headers.add("content-type", image.getTipo());
		headers.add("content-lenght", String.valueOf(image.getDados().length));
		return new ResponseEntity<>(image.getDados(), headers, HttpStatus.OK);
	}
	
//	@GetMapping("/{id}/imagem")
//	public ResponseEntity<byte[]> getImagem(@PathVariable Long id) throws IdNotFoundException {
//		Anexo anexo = anexoService.buscar(id);
//		HttpHeaders headers = new HttpHeaders();
//		headers.add("content-type", anexo.getTipo());
//		headers.add("content-lenght", String.valueOf(anexo.getDados().length));
//		return new ResponseEntity<>(anexo.getDados(), headers, HttpStatus.OK);
//	}
	

	@PostMapping("/addAttendance")
	public ResponseEntity<Attendance> adicionar(@RequestPart Attendance attendance, @RequestParam MultipartFile file) throws ErrorGeneral, IOException {
		return ResponseEntity.ok(attendanceService.adicionar(attendance, file));
	}

}
