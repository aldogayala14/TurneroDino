package com.dinosaurio.turnero.dto;

import com.dinosaurio.turnero.entity.SucursalEntity;
import lombok.Data;

@Data
public class UsuarioDTO {
    private Long id;
    private String nombreUsuario;
    private String password;
    private SucursalEntity sucursal;

}
