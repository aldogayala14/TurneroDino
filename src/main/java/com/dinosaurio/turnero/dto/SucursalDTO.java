package com.dinosaurio.turnero.dto;


import lombok.Data;

import java.util.Set;

@Data
public class SucursalDTO {
    private Long id;
    private int numeroSucursal;
    private String sucursal;
    private Set<TurnoDTO> turnos;
    private Set<UsuarioDTO> usuarios;

}
