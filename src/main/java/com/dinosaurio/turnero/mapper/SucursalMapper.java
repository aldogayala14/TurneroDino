package com.dinosaurio.turnero.mapper;


import com.dinosaurio.turnero.dto.SucursalDTO;
import com.dinosaurio.turnero.entity.SucursalEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class SucursalMapper {

    private ModelMapper modelMapper = new ModelMapper();


    public SucursalDTO sucursalEntity2DTO(SucursalEntity entity){
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        SucursalDTO result = this.modelMapper.map(entity, SucursalDTO.class);
        return result;
    }

    public SucursalEntity sucursalDTO2Entity(SucursalDTO sucursalDTO){
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        SucursalEntity result = this.modelMapper.map(sucursalDTO, SucursalEntity.class);
        return result;
    }

    public Set<SucursalDTO> sucursalEntity2DTOList(List<SucursalEntity> entities){
        Set<SucursalDTO> dtos = new HashSet<>();
        for(SucursalEntity entity:entities){
            dtos.add(this.sucursalEntity2DTO(entity));
        }
        return dtos;
    }

    public Set<SucursalEntity> sucursalDTO2EntityList(List<SucursalDTO> dtos){
        Set<SucursalEntity> entities = new HashSet<>();
        for(SucursalDTO dto:dtos){
            entities.add(this.sucursalDTO2Entity(dto));
        }
        return entities;

    }

}
