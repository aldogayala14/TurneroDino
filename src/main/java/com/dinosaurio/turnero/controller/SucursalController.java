package com.dinosaurio.turnero.controller;

import com.dinosaurio.turnero.dto.SucursalDTO;
import com.dinosaurio.turnero.service.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping("/API/sucursal")
public class SucursalController {

    @Autowired
    private SucursalService sucursalService;

    @GetMapping("/all")
    public ResponseEntity<Set<SucursalDTO>> getAll(){
        Set<SucursalDTO> result = this.sucursalService.getAll();
        return ResponseEntity.ok().body(result);
    }

    @PostMapping
    public ResponseEntity<SucursalDTO> save(@RequestBody SucursalDTO sucursalDTO){
        SucursalDTO result = this.sucursalService.save(sucursalDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);

    }

    @PutMapping("/{id}")
    public ResponseEntity<SucursalDTO> update(@PathVariable Long id,
                                            @RequestBody SucursalDTO sucursalDTO){
        SucursalDTO result = this.sucursalService.update(id, sucursalDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        this.sucursalService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }
}
