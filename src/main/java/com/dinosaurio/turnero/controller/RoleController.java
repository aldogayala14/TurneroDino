package com.dinosaurio.turnero.controller;

import com.dinosaurio.turnero.dto.RoleBasicDTO;
import com.dinosaurio.turnero.dto.SectorDTO;
import com.dinosaurio.turnero.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping("API/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping("/all")
    public ResponseEntity<Set<RoleBasicDTO>> getAll(){
        Set<RoleBasicDTO> result = this.roleService.getAll();
        return ResponseEntity.ok().body(result);
    }

    @PostMapping
    public ResponseEntity<RoleBasicDTO> save(@RequestBody RoleBasicDTO roleBasicDTO){
        RoleBasicDTO result = this.roleService.save(roleBasicDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);

    }

}
