package com.dinosaurio.turnero.service;

import com.dinosaurio.turnero.dto.SectorDTO;

import java.util.Set;

public interface SectorService {
    Set<SectorDTO> getAll();

    SectorDTO save(SectorDTO sectorDTO);

    SectorDTO update(Long id, SectorDTO sectorDTO);

    void delete(Long id);
}
