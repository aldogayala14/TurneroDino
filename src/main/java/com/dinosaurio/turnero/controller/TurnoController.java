package com.dinosaurio.turnero.controller;

import com.dinosaurio.turnero.dto.TurnoDTO;
import com.dinosaurio.turnero.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/API/turno")
public class TurnoController {

    @Autowired
    private TurnoService turnoService;

    @GetMapping("/all")
    public ResponseEntity<Set<TurnoDTO>> getAll(){
        Set<TurnoDTO> result = this.turnoService.getAll();
        return ResponseEntity.ok().body(result);
    }

    @PostMapping
    public ResponseEntity<TurnoDTO> save(@RequestBody TurnoDTO turnoDTO){
       TurnoDTO result = this.turnoService.save(turnoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);

    }

    @PutMapping("/{id}")
    public ResponseEntity<TurnoDTO> update(@PathVariable Long id,
                                          @RequestBody TurnoDTO turnoDTO){
        TurnoDTO result = this.turnoService.update(id, turnoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        this.turnoService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }
}