package com.estetica.atendimento.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.estetica.atendimento.model.Users;

public class DetailsUserData implements UserDetails {

    private final Optional <Users> users;


    public DetailsUserData(Optional<Users> users) {
        this.users = users;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
       
        return new ArrayList<>();
    }

    @Override
    public String getPassword() {
        
        return users.orElse(new Users()).getPassword();
    }

    @Override
    public String getUsername() {
       
        return users.orElse(new Users()).getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        
        return true;
    }

    @Override
    public boolean isEnabled() {
        
        return true;
    }
    
}
