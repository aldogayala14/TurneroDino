package com.dinosaurio.turnero.service.Impl;

import com.dinosaurio.turnero.dto.UsuarioDTO;
import com.dinosaurio.turnero.entity.UsuarioEntity;
import com.dinosaurio.turnero.mapper.UsuarioMapper;
import com.dinosaurio.turnero.repository.UsuarioRepository;
import com.dinosaurio.turnero.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private UsuarioRepository usuarioRepository;
    private UsuarioMapper usuarioMapper;

    @Autowired
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository, UsuarioMapper usuarioMapper) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioMapper = usuarioMapper;
    }

    @Override
    public Set<UsuarioDTO> getAll() {
        Set<UsuarioDTO> result = usuarioMapper.usuarioEntity2DTOList(this.usuarioRepository.findAll());
        return result;
    }

    @Override
    public UsuarioDTO save(UsuarioDTO usuarioDTO) {
        UsuarioEntity entity = this.usuarioMapper.usuarioDTO2Entity(usuarioDTO);
        UsuarioEntity usuarioSaved = this.usuarioRepository.save(entity);
        UsuarioDTO result = this.usuarioMapper.usuarioEntity2DTO(usuarioSaved);
        return result;
    }

    @Override
    public UsuarioDTO update(Long id, UsuarioDTO usuarioDTO) {
        UsuarioEntity entity = this.usuarioRepository.findById(id).orElse(null);
        entity.setNombreUsuario(usuarioDTO.getNombreUsuario());
        entity.setPassword(usuarioDTO.getPassword());
        entity.setSucursal(usuarioDTO.getSucursal());
        UsuarioEntity entitySave = this.usuarioRepository.save(entity);
        UsuarioDTO result = this.usuarioMapper.usuarioEntity2DTO(entitySave);
        return  result;
    }

    @Override
    public void delete(Long id) {
    this.usuarioRepository.deleteById(id);
    }
}
