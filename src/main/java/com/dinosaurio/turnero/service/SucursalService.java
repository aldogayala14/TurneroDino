package com.dinosaurio.turnero.service;

import com.dinosaurio.turnero.dto.SucursalDTO;

import java.util.Set;

public interface SucursalService {
    Set<SucursalDTO> getAll();

    SucursalDTO save(SucursalDTO sucursalDTO);

    SucursalDTO update(Long id, SucursalDTO sucursalDTO);

    void delete(Long id);
}
