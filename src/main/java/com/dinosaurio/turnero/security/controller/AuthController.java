package com.dinosaurio.turnero.security.controller;

import com.dinosaurio.turnero.dto.UsuarioDTO;
import com.dinosaurio.turnero.security.dto.AuthenticationRequestDto;
import com.dinosaurio.turnero.security.dto.AuthenticationResponseDto;
import com.dinosaurio.turnero.security.service.UserDetailsCustomService;
import com.dinosaurio.turnero.security.util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping("/API/auth")
public class AuthController {


    private UserDetailsCustomService userDetailsCustomService;
    private AuthenticationManager authenticationManager;
    private JwtUtils jwtUtils;

    @Autowired
    public AuthController(
            UserDetailsCustomService userDetailsCustomService,
            AuthenticationManager authenticationManager,
            JwtUtils jwtUtils) {
        this.userDetailsCustomService = userDetailsCustomService;
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponseDto> singUp(@RequestBody UsuarioDTO user) throws Exception{
        this.userDetailsCustomService.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponseDto> singIn(@RequestBody AuthenticationRequestDto authRequest) throws Exception{
        UserDetails userDetails;
        try{
            Authentication auth = authenticationManager.authenticate(

                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword(), Collections.emptyList())
            );
            userDetails = (UserDetails) auth.getPrincipal();

        }catch (BadCredentialsException e){
            throw new Exception("Incorrect username o password",e);
        }

        final String jwt = jwtUtils.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponseDto(jwt));
    }
}
