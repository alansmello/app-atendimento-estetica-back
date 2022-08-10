package com.estetica.atendimento.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.estetica.atendimento.model.Users;
import com.estetica.atendimento.repository.UserRepository;
import com.estetica.atendimento.security.DetailsUserData;

@Component
public class ImplUserDetailService implements UserDetailsService {

    private final UserRepository repository;


    public ImplUserDetailService(UserRepository repository) {
        this.repository = repository;
    }

    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> user = repository.findByUsername(username);
        if(user.isEmpty()){
            throw new UsernameNotFoundException("Usuario " + username + " nao encontrado");
        }
        return new DetailsUserData(user);
    }
    
}
