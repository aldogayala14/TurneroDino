package com.dinosaurio.turnero.mapper;

import com.dinosaurio.turnero.dto.UsuarioDTO;
import com.dinosaurio.turnero.entity.UsuarioEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class UsuarioMapper {

    private ModelMapper modelMapper = new ModelMapper();

    public UsuarioDTO usuarioEntity2DTO(UsuarioEntity entity){
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UsuarioDTO result = this.modelMapper.map(entity, UsuarioDTO.class);
        return result;
    }

    public UsuarioEntity usuarioDTO2Entity(UsuarioDTO usuarioDTO){
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UsuarioEntity result = this.modelMapper.map(usuarioDTO, UsuarioEntity.class);
        return result;
    }

    public Set<UsuarioDTO> usuarioEntity2DTOList(List<UsuarioEntity> entities){
        Set<UsuarioDTO> dtos = new HashSet<>();
        for(UsuarioEntity entity:entities){
            dtos.add(this.usuarioEntity2DTO(entity));
        }
        return dtos;
    }

    public Set<UsuarioEntity> usuarioDTO2EntityList(List<UsuarioDTO> dtos){
        Set<UsuarioEntity> entities = new HashSet<>();
        for(UsuarioDTO dto:dtos){
            entities.add(this.usuarioDTO2Entity(dto));
        }
        return entities;

    }
}
