package com.estetica.atendimento.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@GetMapping("/getAllImagem")
	public ResponseEntity<List<Image>> listarTodasFotos() throws ErrorGeneral {
		return ResponseEntity.ok(imageService.listarTodos());
	}
	
	@GetMapping("/getImagemPorIdAttendance/{id}")
	public ResponseEntity<List<Image>> listarFotosPorIdAttendance(@PathVariable Integer id) throws ErrorGeneral {
		return ResponseEntity.ok(imageService.listarPorIdAttendance(id));
	}
	
	@GetMapping("/getAllAttendance")
	public ResponseEntity<List<Attendance>> listarTodos() throws ErrorGeneral {
		return ResponseEntity.ok(attendanceService.listarTodos());
	}
	
	@GetMapping("/{id}/imagem")
	public ResponseEntity<byte[]> getImagem(@PathVariable Integer id) {
		Image image = (Image) imageService.buscar(id);
		HttpHeaders headers = new HttpHeaders();
		headers.add("content-type", image.getTipo());
		headers.add("content-lenght", String.valueOf(image.getDados().length));
		return new ResponseEntity<>(image.getDados(), headers, HttpStatus.OK);
	}

	@PostMapping("/addAttendance")
	public ResponseEntity<String> adicionar(@RequestBody Attendance attendance) throws ErrorGeneral, IOException {
		return ResponseEntity.ok(attendanceService.adicionar(attendance));
	}
	
	@PostMapping("/addFoto")
	public ResponseEntity<String> adicionar(@RequestPart Image image, @RequestParam MultipartFile file) throws ErrorGeneral, IOException {
		return ResponseEntity.ok(imageService.inserir(image, file));
	}
	
	@DeleteMapping("/deleteImagem/{id}")
	public ResponseEntity<String> deletar(@PathVariable Integer id) throws ErrorGeneral {
		return ResponseEntity.ok(imageService.deletar(id));
	}

}
