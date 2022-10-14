package com.dinosaurio.turnero.service.Impl;

import com.dinosaurio.turnero.dto.SucursalDTO;
import com.dinosaurio.turnero.dto.TurnoDTO;
import com.dinosaurio.turnero.dto.UsuarioDTO;
import com.dinosaurio.turnero.entity.SucursalEntity;
import com.dinosaurio.turnero.mapper.SucursalMapper;
import com.dinosaurio.turnero.mapper.TurnoMapper;
import com.dinosaurio.turnero.mapper.UsuarioMapper;
import com.dinosaurio.turnero.repository.SucursalRepository;
import com.dinosaurio.turnero.service.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class SucursalServiceImpl implements SucursalService {

    private SucursalRepository sucursalRepository;
    private SucursalMapper sucursalMapper;
    private TurnoMapper turnoMapper;
    private UsuarioMapper usuarioMapper;

    @Autowired
    public SucursalServiceImpl(SucursalRepository sucursalRepository,
                             SucursalMapper sucursalMapper,
                               TurnoMapper turnoMapper,
                               UsuarioMapper usuarioMapper) {
        this.sucursalRepository = sucursalRepository;
        this.sucursalMapper = sucursalMapper;
        this.turnoMapper = turnoMapper;
        this.usuarioMapper = usuarioMapper;
    }
    @Override
    public Set<SucursalDTO> getAll() {
        Set<SucursalDTO> result = sucursalMapper.sucursalEntity2DTOList(this.sucursalRepository.findAll());
        return result;
    }

    @Override
    public SucursalDTO save(SucursalDTO sucursalDTO) {
        SucursalEntity entity = this.sucursalMapper.sucursalDTO2Entity(sucursalDTO);
        SucursalEntity sucursalSaved = this.sucursalRepository.save(entity);
        SucursalDTO result = this.sucursalMapper.sucursalEntity2DTO(sucursalSaved);
        return result;
    }

    @Override
    public SucursalDTO update(Long id, SucursalDTO sucursalDTO) {
        SucursalEntity entity = this.sucursalRepository.findById(id).orElse(null);
        entity.setSucursal(sucursalDTO.getSucursal());
        entity.setNumeroSucursal(sucursalDTO.getNumeroSucursal());
        List<TurnoDTO> listTurnos = new ArrayList<>(sucursalDTO.getTurnos());
        entity.setTurnos(this.turnoMapper.turnoDTO2EntityList(listTurnos));
        List<UsuarioDTO> listUsuarios = new ArrayList<>(sucursalDTO.getUsuarios());
        entity.setUsuarios(this.usuarioMapper.usuarioDTO2EntityList(listUsuarios));
        SucursalEntity entitySave = this.sucursalRepository.save(entity);
        SucursalDTO result = this.sucursalMapper.sucursalEntity2DTO(entitySave);
        return  result;
    }

    @Override
    public void delete(Long id) {
        this.sucursalRepository.deleteById(id);
    }
}
