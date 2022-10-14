package com.dinosaurio.turnero.service.Impl;

import com.dinosaurio.turnero.dto.SectorDTO;
import com.dinosaurio.turnero.dto.TurnoDTO;
import com.dinosaurio.turnero.entity.SectorEntity;
import com.dinosaurio.turnero.mapper.SectorMapper;
import com.dinosaurio.turnero.mapper.TurnoMapper;
import com.dinosaurio.turnero.repository.SectorRepository;
import com.dinosaurio.turnero.service.SectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class SectorServiceImpl implements SectorService {

    private SectorRepository sectorRepository;
    private SectorMapper sectorMapper;

    private TurnoMapper turnoMapper;

    @Autowired
    public SectorServiceImpl(SectorRepository sectorRepository,
                             SectorMapper sectorMapper,
                             TurnoMapper turnoMapper) {
        this.sectorRepository = sectorRepository;
        this.sectorMapper = sectorMapper;
        this.turnoMapper = turnoMapper;
    }
    @Override
    public Set<SectorDTO> getAll() {
        Set<SectorDTO> result = sectorMapper.sectorEntity2DTOList(this.sectorRepository.findAll());
        return result;
    }

    @Override
    public SectorDTO save(SectorDTO sectorDTO) {
        SectorEntity entity = this.sectorMapper.sectorDTO2Entity(sectorDTO);
        SectorEntity sectorSaved = this.sectorRepository.save(entity);
        SectorDTO result = this.sectorMapper.sectorEntity2DTO(sectorSaved);
        return result;
    }

    @Override
    public SectorDTO update(Long id, SectorDTO sectorDTO) {
        SectorEntity entity = this.sectorRepository.findById(id).orElse(null);
        entity.setSector(sectorDTO.getSector());
        entity.setNumeroSector(sectorDTO.getNumeroSector());
        List<TurnoDTO> listTurnos = new ArrayList<>(sectorDTO.getTurnos());
        entity.setTurnos(this.turnoMapper.turnoDTO2EntityList(listTurnos));
        SectorEntity entitySave = this.sectorRepository.save(entity);
        SectorDTO result = this.sectorMapper.sectorEntity2DTO(entitySave);
        return  result;
    }

    @Override
    public void delete(Long id) {
            this.sectorRepository.deleteById(id);
    }
}
