package com.dinosaurio.turnero.controller;

import com.dinosaurio.turnero.dto.SectorDTO;
import com.dinosaurio.turnero.service.SectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping("/API/sector")
public class SectorController {
    @Autowired
    private SectorService sectorService;

    @GetMapping("/all")
    public ResponseEntity<Set<SectorDTO>> getAll(){
        Set<SectorDTO> result = this.sectorService.getAll();
        return ResponseEntity.ok().body(result);
    }

    @PostMapping
    public ResponseEntity<SectorDTO> save(@RequestBody SectorDTO sectorDTO){
        SectorDTO result = this.sectorService.save(sectorDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);

    }

    @PutMapping("/{id}")
    public ResponseEntity<SectorDTO> update(@PathVariable Long id,
                                           @RequestBody SectorDTO sectorDTO){
        SectorDTO result = this.sectorService.update(id, sectorDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        this.sectorService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }
}
