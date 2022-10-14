package com.dinosaurio.turnero.dto;

import lombok.Data;

import java.util.Set;

@Data
public class SectorDTO {
    private Long id;
    private int numeroSector;
    private String sector;
    private Set<TurnoDTO> turnos;
}
