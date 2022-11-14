package com.dinosaurio.turnero.service;

import com.dinosaurio.turnero.dto.TurnoDTO;

import java.util.List;
import java.util.Set;

public interface TurnoService {
    Set<TurnoDTO> getAll();

    TurnoDTO save(TurnoDTO turnoDTO);

    TurnoDTO update(Long id, TurnoDTO turnoDTO);

    void delete(Long id);

    List<TurnoDTO> getByFilters(int estado, String order);

    void setEstado();
}
