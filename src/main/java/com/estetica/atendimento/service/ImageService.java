package com.estetica.atendimento.service;

import java.io.IOException;
import java.net.URI;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.estetica.atendimento.model.Attendance;
import com.estetica.atendimento.model.Image;
import com.estetica.atendimento.repository.ImageRepository;


@Service
public class ImageService {
	
	@Autowired
	ImageRepository imageRepo;
	
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
	public Image inserir(Attendance attendance, MultipartFile file) throws IOException {
		Image foto = new Image(null, file.getBytes(), file.getContentType(), file.getName(), attendance);
		return imageRepo.save(foto);
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
                                              
}
