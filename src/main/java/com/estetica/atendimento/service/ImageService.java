package com.estetica.atendimento.service;

import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

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

	public List<Image> listarTodos() {
		List<Image> lista = imageRepo.findAll();
		for (Image prod: lista ){
		adicionarImagemUri(prod);
		}
		return lista;
	}
	
	@Transactional
	public List<Image> listarPorIdAttendance(Integer id) {
		List<Image> lista = imageRepo.findByAttendanceId(id);
		for (Image prod: lista ){
		adicionarImagemUri(prod);
		}
		return lista;
	}
	
	
	public Image inserir(Image image, MultipartFile file) throws IOException, ErrorGeneral {
		
		Optional<Attendance> optional = attendanceRepo.findById(image.getAttendance().getId());
		if (optional.isEmpty()) {
			throw new ErrorGeneral("Esse atendimento não existe!");
		}
		image.setName(file.getName());
		image.setTipo(file.getContentType());
		image.setDados(file.getBytes());
		image.setAttendance(optional.get());
		imageRepo.save(image);
		adicionarImagemUri(image);
		return image;
	}
	
	private Image adicionarImagemUri(Image image) {
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/attendance/{id}/imagem")
				.buildAndExpand(image.getId()).toUri();
		image.setUrl(uri.toString());
		return image;
	}

	public Image buscar(Integer id) {
		Optional<Image> image = imageRepo.findById(id);
		if (!image.isPresent()) {
			return null;
		}
		return image.get();
	}
	
	public String deletar(Integer id) throws ErrorGeneral {

        Optional<Image> optional = imageRepo.findById(id);
        if (optional.isEmpty()) {
            throw new ErrorGeneral("Essa imagem não existe!");
        }
        imageRepo.deleteById(id);
        return "Imagem deletada com sucesso";
    }
	

                                              
}
