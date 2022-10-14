package com.dinosaurio.turnero.mapper;

import com.dinosaurio.turnero.dto.SectorDTO;
import com.dinosaurio.turnero.entity.SectorEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class SectorMapper {
    private ModelMapper modelMapper = new ModelMapper();

    public SectorDTO sectorEntity2DTO(SectorEntity entity){
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        SectorDTO result = this.modelMapper.map(entity, SectorDTO.class);
        return result;
    }

    public SectorEntity sectorDTO2Entity(SectorDTO sectorDTO){
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        SectorEntity result = this.modelMapper.map(sectorDTO, SectorEntity.class);
        return result;
    }

    public Set<SectorDTO> sectorEntity2DTOList(List<SectorEntity> entities){
        Set<SectorDTO> dtos = new HashSet<>();
        for(SectorEntity entity:entities){
            dtos.add(this.sectorEntity2DTO(entity));
        }
        return dtos;
    }

    public Set<SectorEntity> sectorDTO2EntityList(List<SectorDTO> dtos){
        Set<SectorEntity> entities = new HashSet<>();
        for(SectorDTO dto:dtos){
            entities.add(this.sectorDTO2Entity(dto));
        }
        return entities;

    }

}
