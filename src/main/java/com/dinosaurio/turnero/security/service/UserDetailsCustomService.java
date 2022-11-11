package com.dinosaurio.turnero.security.service;

import com.dinosaurio.turnero.dto.UsuarioDTO;
import com.dinosaurio.turnero.entity.UsuarioEntity;
import com.dinosaurio.turnero.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserDetailsCustomService implements UserDetailsService {
    @Autowired
    private UsuarioRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsuarioEntity userEntity = this.userRepository.findByUsername(username);
        if(userEntity == null){
            throw new UsernameNotFoundException("Username or password not found");
        }

        return new User(userEntity.getUsername(),userEntity.getPassword(), Collections.emptyList());
    }

    public boolean save(UsuarioDTO userDTO){
        UsuarioEntity userEntity = new UsuarioEntity();
        userEntity.setUsername(userDTO.getUsername());
        userEntity.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        //TODO: SET USER ROLES
        userEntity = this.userRepository.save(userEntity);

        return userEntity != null;
    }
}
