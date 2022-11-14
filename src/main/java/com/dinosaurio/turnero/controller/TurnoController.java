package com.dinosaurio.turnero.controller;

import com.dinosaurio.turnero.dto.TurnoDTO;
import com.dinosaurio.turnero.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/API/turno")
@CrossOrigin(origins = "http://localhost:9090")
public class TurnoController {

    @Autowired
    private TurnoService turnoService;


    @GetMapping("/all")
    public ResponseEntity<Set<TurnoDTO>> getAll(){
        Set<TurnoDTO> result = this.turnoService.getAll();
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/filter")
        public ResponseEntity<List<TurnoDTO>> getDetailsByFilters(@RequestParam(required = false, defaultValue = "1") int estado,
                                                              @RequestParam(required = false , defaultValue = "ASC") String order)
    {
        List<TurnoDTO> turnoDTOS = turnoService.getByFilters(estado,order);
        return ResponseEntity.status(HttpStatus.OK).body(turnoDTOS);

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

    @PostMapping("/setEstado")
    public ResponseEntity<String> setEstado(){
        String message = "Set estado OK";
        this.turnoService.setEstado();
        return ResponseEntity.status(HttpStatus.OK).body(message);
    }
}
