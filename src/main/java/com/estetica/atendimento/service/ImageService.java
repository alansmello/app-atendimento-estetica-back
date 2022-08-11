package com.estetica.atendimento.service;

import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.estetica.atendimento.exception.ErrorGeneral;
import com.estetica.atendimento.model.Attendance;
import com.estetica.atendimento.model.Image;
import com.estetica.atendimento.model.Patient;
import com.estetica.atendimento.repository.AttendanceRepository;
import com.estetica.atendimento.repository.ImageRepository;


@Service
public class ImageService {
	
	@Autowired
	ImageRepository imageRepo;
	
	@Autowired
	AttendanceRepository attendanceRepo;
//	
//	@Autowired
//	AttendanceService attendanceService;
	
//	@Transactional
//	public Image create(Attendance attendance, MultipartFile file) throws IOException {
//		Image image = new Image();
//		image.setName("imagem");
//		image.setTipo(file.getContentType());
//		image.setDados(file.getBytes());
//		image.setAttendance(attendance);
//		return imageRepo.save(image);
//	}
	
//	@Transactional
	public Image inserir(Image image, MultipartFile file) throws IOException, ErrorGeneral {
		
		Optional<Attendance> optional = attendanceRepo.findById(image.getAttendance().getId());
		if (optional.isEmpty()) {
			throw new ErrorGeneral("Esse atendimento não existe!");
		}
		image.setName(file.getName());
		image.setTipo(file.getContentType());
		image.setDados(file.getBytes());
		image.setAttendance(optional.get());
		adicionarImagemUri(image);
		return imageRepo.save(image);
	}
	
	private Image adicionarImagemUri(Image image) {
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/attendance/{id}/imagem")
				.buildAndExpand(image.getId()).toUri();
		image.setUrl(uri.toString());
		return image;
	}

//	public String createUrl(Integer id) {
//		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/attendance/{id}/imagem").buildAndExpand(id)
//				.toUri();
//		return uri.toString(); 
//
//	}
	
//	@Transactional
	public Image buscar(Integer id) {
		Optional<Image> image = imageRepo.findById(id);
		if (!image.isPresent()) {
			return null;
		}
		return image.get();
	}
	
//	public List<Image> listarPorAttendanceId(Integer id) {
//		return imageRepo.findByAttendanceId(id);
//	}
                                              
}
