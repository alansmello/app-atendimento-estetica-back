package com.estetica.atendimento.controller;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estetica.atendimento.exception.ErrorGeneral;
import com.estetica.atendimento.model.ServiceModel;
import com.estetica.atendimento.service.ServiceModelService;

@RestController
@RequestMapping("/service")
public class ServiceModelController {

    private final ServiceModelService service;

    public ServiceModelController(ServiceModelService service) {
        this.service = service;
    }

    @GetMapping
	public ResponseEntity<List<ServiceModel>> getAll() throws ErrorGeneral {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Lista Servicos", "Lista Retornada com sucesso");

        return new ResponseEntity<>(service.getAll(), headers, HttpStatus.valueOf(202));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceModel> getOne(@PathVariable Integer id) throws ErrorGeneral{
        HttpHeaders headers = new HttpHeaders();
        headers.add("Servico", "Servico retornado com sucesso");

        return new ResponseEntity<>(service.getOne(id), headers, HttpStatus.ACCEPTED);
    }

    @PostMapping
    public ResponseEntity<String> addService(@RequestBody ServiceModel serviceModel) throws ErrorGeneral{
        HttpHeaders headers = new HttpHeaders();
        headers.add("Servico", "Servico adicionado com sucesso");

        return new ResponseEntity<>(service.add(serviceModel), headers, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteService(@PathVariable Integer id) throws ErrorGeneral {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Servico", "Deletado com sucesso");
        return new ResponseEntity<>(service.deleteServiceModel(id), headers, HttpStatus.OK);
    }


}
    
    

