package com.estetica.atendimento.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.estetica.atendimento.exception.ErrorGeneral;
import com.estetica.atendimento.model.ServiceModel;
import com.estetica.atendimento.repository.ServiceModelRepository;

@Service
public class ServiceModelService {

    private ServiceModelRepository repository;


    public ServiceModelService(ServiceModelRepository repository) {
        this.repository = repository;
    }
    

    public List<ServiceModel> getAll() {
		return repository.findAll();
	}

    public ServiceModel getOne( Integer id) throws ErrorGeneral{
        Optional<ServiceModel> service = repository.findById(id);
        if(service.isEmpty()){
            throw new ErrorGeneral("servico nao encontrado");
        }

        return service.get();
    }

    public String add(ServiceModel service) throws ErrorGeneral {

		if (service.getName() == null || service.getName().equals("")) {
			throw new ErrorGeneral("O nome do servico tem que ser informado!");
		}
		
        service.setName(service.getName().toUpperCase());
        
        repository.save(service);

		return "Servico criado com sucesso";
	}

    public String deleteServiceModel(Integer id) throws ErrorGeneral{
        Optional<ServiceModel> service = repository.findById(id);
        if(service.isEmpty()){
            throw new ErrorGeneral("servico nao encontrado");
        }

        repository.deleteById(id);

        return "Servico deletado com sucesso";
    }
    
}
