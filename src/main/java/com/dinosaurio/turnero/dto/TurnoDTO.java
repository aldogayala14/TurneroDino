package com.dinosaurio.turnero.dto;


import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class TurnoDTO {
    private Long id;
    private int numero_turno;
    private ZonedDateTime fechaHora;
    private ZonedDateTime fechaAlta;
    private boolean estado;
    private Long sucursalId;
    private Long sectorId;
}
