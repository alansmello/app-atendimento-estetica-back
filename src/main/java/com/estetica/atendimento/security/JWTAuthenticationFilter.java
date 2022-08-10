package com.estetica.atendimento.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.estetica.atendimento.model.Users;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    public static final int TOKEN_EXPIRATION = 864_000_00;

    public static final String TOKEN_PASSWORD = "f9086d02-ceea-4ca6-ba72-e957dbd249f8";
    
    private final AuthenticationManager authenticationManager;


    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {
       
        try {
            Users user = new ObjectMapper().readValue(request.getInputStream(), Users.class);

            return authenticationManager.authenticate( new UsernamePasswordAuthenticationToken(
                user.getUsername(), 
                user.getPassword(),
                new ArrayList<>()
            ));
        } catch (IOException e) {
            
            throw new RuntimeException("Falha ao autenticar usuario", e);
        } 
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
            Authentication authResult) throws IOException, ServletException {
        
        DetailsUserData userData = (DetailsUserData) authResult.getPrincipal();

        String token = JWT.create().
        withSubject(userData.getUsername())
        .withExpiresAt(new Date(System.currentTimeMillis() + TOKEN_EXPIRATION))
        .sign(Algorithm.HMAC512(TOKEN_PASSWORD));
        
        response.getWriter().write(token);
        response.getWriter().flush();
        
    }
    

}
