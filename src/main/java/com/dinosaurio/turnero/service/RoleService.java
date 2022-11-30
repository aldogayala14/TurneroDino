package com.dinosaurio.turnero.service;

import com.dinosaurio.turnero.dto.RoleBasicDTO;

import java.util.Set;

public interface RoleService {

    Set<RoleBasicDTO> getAll();

    RoleBasicDTO save(RoleBasicDTO roleBasicDTO);


}
