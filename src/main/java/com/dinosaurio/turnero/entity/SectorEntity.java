package com.dinosaurio.turnero.entity;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "sector")
@Getter
@Setter
@SQLDelete(sql = "UPDATE sector SET habilitado = 0 WHERE id=?")
@Where(clause = "habilitado = 1")
public class SectorEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "numero_sector")
    private int numeroSector;
    @Column(name = "descripcion")
    private String sector;

    @OneToMany(mappedBy="sector")
    private Set<TurnoEntity> turnos;

    @Column(name = "Habilitado")
    private boolean Habilitado = true;


    //Add and remove turnos
    public void addTurno(TurnoEntity turnoEntity){this.turnos.add(turnoEntity);}

    public void removeTurno(TurnoEntity turnoEntity){this.turnos.remove(turnoEntity);}
}
