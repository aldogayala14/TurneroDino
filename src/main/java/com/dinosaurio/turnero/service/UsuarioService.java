package com.dinosaurio.turnero.service;

import com.dinosaurio.turnero.dto.UsuarioDTO;

import java.util.Set;

public interface UsuarioService {
    Set<UsuarioDTO> getAll();

    UsuarioDTO save(UsuarioDTO usuarioDTO);

    UsuarioDTO update(Long id, UsuarioDTO usuarioDTO);

    void delete(Long id);
}
