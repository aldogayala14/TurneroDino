package com.dinosaurio.turnero.service.Impl;

import com.dinosaurio.turnero.dto.RoleBasicDTO;
import com.dinosaurio.turnero.dto.SectorDTO;
import com.dinosaurio.turnero.entity.RoleEntity;
import com.dinosaurio.turnero.entity.SectorEntity;
import com.dinosaurio.turnero.mapper.RoleMapper;
import com.dinosaurio.turnero.repository.RoleRepository;
import com.dinosaurio.turnero.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private RoleMapper roleMapper;


    @Override
    public Set<RoleBasicDTO> getAll() {
        Set<RoleBasicDTO> result = roleMapper.roleEntity2DTOList(this.roleRepository.findAll());
        return result;
    }

    @Override
    public RoleBasicDTO save(RoleBasicDTO roleBasicDTO) {
        RoleEntity entity = this.roleMapper.roleDTO2Entity(roleBasicDTO);
        RoleEntity roleSaved = this.roleRepository.save(entity);
        RoleBasicDTO result = this.roleMapper.roleEntity2DTO(roleSaved);
        return result;
    }
}
