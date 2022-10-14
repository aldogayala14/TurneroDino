package com.dinosaurio.turnero.mapper;

import com.dinosaurio.turnero.dto.TurnoDTO;
import com.dinosaurio.turnero.entity.TurnoEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class TurnoMapper {

    private ModelMapper modelMapper = new ModelMapper();

    public TurnoDTO turnoEntity2DTO(TurnoEntity entity){
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        TurnoDTO result = this.modelMapper.map(entity, TurnoDTO.class);
        return result;
    }

    public TurnoEntity turnoDTO2Entity(TurnoDTO turnoDTO){
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        TurnoEntity result = this.modelMapper.map(turnoDTO, TurnoEntity.class);
        return result;
    }

    public Set<TurnoDTO> turnoEntity2DTOList(List<TurnoEntity> entities){
        Set<TurnoDTO> dtos = new HashSet<>();
        for(TurnoEntity entity:entities){
            dtos.add(this.turnoEntity2DTO(entity));
        }
        return dtos;
    }

    public Set<TurnoEntity> turnoDTO2EntityList(List<TurnoDTO> dtos){
        Set<TurnoEntity> entities = new HashSet<>();
        for(TurnoDTO dto:dtos){
            entities.add(this.turnoDTO2Entity(dto));
        }
        return entities;

    }

}
