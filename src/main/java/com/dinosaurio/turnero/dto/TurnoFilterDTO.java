package com.dinosaurio.turnero.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;

@Getter
@Setter
public class TurnoFilterDTO {

    private int estado;
    private String order;


    public TurnoFilterDTO(int estado, String order) {
        this.estado = estado;
        this.order = order;
    }

    public boolean isASC(){return this.order.compareToIgnoreCase("ASC") == 0;}
    public boolean isDESC(){return this.order.compareToIgnoreCase("DESC") == 0;}
}
