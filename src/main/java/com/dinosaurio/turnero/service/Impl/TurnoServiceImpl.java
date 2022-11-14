package com.dinosaurio.turnero.service.Impl;

import com.dinosaurio.turnero.dto.TurnoDTO;
import com.dinosaurio.turnero.dto.TurnoFilterDTO;
import com.dinosaurio.turnero.entity.TurnoEntity;
import com.dinosaurio.turnero.mapper.TurnoMapper;
import com.dinosaurio.turnero.repository.TurnoRepository;
import com.dinosaurio.turnero.repository.specification.TurnoSpecification;
import com.dinosaurio.turnero.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TurnoServiceImpl implements TurnoService {

    private TurnoRepository turnoRepository;
    private TurnoSpecification turnoSpecification;
    private TurnoMapper turnoMapper;

    @Autowired
    public TurnoServiceImpl(TurnoRepository turnoRepository, TurnoMapper turnoMapper, TurnoSpecification turnoSpecification) {
        this.turnoRepository = turnoRepository;
        this.turnoMapper = turnoMapper;
        this.turnoSpecification = turnoSpecification;
    }

    @Override
    public Set<TurnoDTO> getAll() {
        Set<TurnoDTO> result = turnoMapper.turnoEntity2DTOList(this.turnoRepository.findAll());
        return result;
    }

    @Override
    public TurnoDTO save(TurnoDTO userDTO) {
        TurnoEntity entity = this.turnoMapper.turnoDTO2Entity(userDTO);
        TurnoEntity turnoSaved = this.turnoRepository.save(entity);
        TurnoDTO result = this.turnoMapper.turnoEntity2DTO(turnoSaved);
        return result;
    }

    @Override
    public TurnoDTO update(Long id, TurnoDTO turnoDTO) {
        TurnoEntity entity = this.turnoRepository.findById(id).orElse(null);
        entity.setNumero_turno(turnoDTO.getNumero_turno());
        entity.setFechaHora(turnoDTO.getFechaHora());
        TurnoEntity entitySave = this.turnoRepository.save(entity);
        TurnoDTO result = this.turnoMapper.turnoEntity2DTO(entitySave);
        return  result;
    }

    @Override
    public void delete(Long id) {
        this.turnoRepository.deleteById(id);
    }


    @Override
    public List<TurnoDTO> getByFilters(int estado, String order) {

        TurnoFilterDTO turnoFilterDTO = new TurnoFilterDTO(estado,order);
        List<TurnoEntity> entities = turnoRepository.findAll(turnoSpecification.getByFilters(turnoFilterDTO));
        Set<TurnoDTO> turnoDTOS = turnoMapper.turnoEntity2DTOList(entities);
        List<TurnoDTO> result = new ArrayList<>(turnoDTOS);
        if(turnoFilterDTO.isASC()){
            result.sort(Comparator.comparing(TurnoDTO::getId));
        }else if(turnoFilterDTO.isDESC()){
            result.sort(Comparator.comparing(TurnoDTO::getId));
            Collections.reverse(result);
        }
        return result;
    }

    @Override
    public void setEstado() {
        this.turnoRepository.setEstado();
    }
}
