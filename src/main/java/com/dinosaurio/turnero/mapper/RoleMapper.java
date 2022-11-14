package com.dinosaurio.turnero.mapper;

import com.dinosaurio.turnero.dto.RoleBasicDTO;
import com.dinosaurio.turnero.entity.RoleEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RoleMapper {

    private ModelMapper modelMapper = new ModelMapper();

    public RoleBasicDTO roleEntity2DTO(RoleEntity entity){
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        RoleBasicDTO result = this.modelMapper.map(entity, RoleBasicDTO.class);
        return result;
    }

    public RoleEntity roleDTO2Entity(RoleBasicDTO roleDTO){
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
       RoleEntity result = this.modelMapper.map(roleDTO, RoleEntity.class);
        return result;
    }

    public Set<RoleBasicDTO> roleEntity2DTOList(List<RoleEntity> entities){
        Set<RoleBasicDTO> dtos = new HashSet<>();
        for(RoleEntity entity:entities){
            dtos.add(this.roleEntity2DTO(entity));
        }
        return dtos;
    }

    public Set<RoleEntity> usuarioDTO2EntityList(List<RoleBasicDTO> dtos){
        Set<RoleEntity> entities = new HashSet<>();
        for(RoleBasicDTO dto:dtos){
            entities.add(this.roleDTO2Entity(dto));
        }
        return entities;

    }
}
