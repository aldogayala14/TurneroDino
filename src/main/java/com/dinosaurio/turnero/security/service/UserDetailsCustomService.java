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

        return new User(userEntity.getUsername(),userEntity.getPassword(), userEntity.getAuthorities());
    }

    public boolean save(UsuarioDTO userDTO) throws Exception{
        if (accountExist(userDTO.getUsername())) {
            throw new Exception("There is an account with that email address:" + userDTO.getUsername());
        }
        UsuarioEntity userEntity = new UsuarioEntity();
        userEntity.setUsername(userDTO.getUsername());
        userEntity.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        userEntity.setSucursalId(userDTO.getSucursalId());
        userEntity.setRoleId(userDTO.getRoleId());
        userEntity = this.userRepository.save(userEntity);
        return userEntity != null;
    }

    private boolean accountExist(String username){
        UsuarioEntity user = this.userRepository.findByUsername(username);
        return user!=null;
    }

}

