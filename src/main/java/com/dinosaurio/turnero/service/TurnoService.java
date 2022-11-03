package com.dinosaurio.turnero.service;

import com.dinosaurio.turnero.dto.TurnoDTO;

import java.util.Set;

public interface TurnoService {
    Set<TurnoDTO> getAll();

    TurnoDTO save(TurnoDTO turnoDTO);

    TurnoDTO update(Long id, TurnoDTO turnoDTO);

    void delete(Long id);

    Set<TurnoDTO> getByFilters(boolean estado, String order);

    void setEstado();
}
