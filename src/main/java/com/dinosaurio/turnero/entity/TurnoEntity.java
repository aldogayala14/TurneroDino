package com.dinosaurio.turnero.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;
import java.time.ZonedDateTime;

@Entity
@Table(name = "turno")
@Getter
@Setter@SQLDelete(sql = "UPDATE turno SET habilitado = 0 WHERE id=?")
@Where(clause = "habilitado = 1")
public class TurnoEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "numero_turno")
    private int numero_turno;

    @Column(name = "fecha_hora")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private ZonedDateTime fechaHora = ZonedDateTime.now();

    @Column(name = "fecha_alta")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private ZonedDateTime fechaAlta = ZonedDateTime.now();

    @ManyToOne
    @JoinColumn(name="sucursal_id", insertable = false,updatable = false)
    private SucursalEntity sucursal;

    @Column(name = "sucursal_id", nullable = false)
    private Long sucursalId;

    @ManyToOne
    @JoinColumn(name="sector_id", insertable = false,updatable = false)
    private SectorEntity sector;

    @Column(name = "sector_id", nullable = false)
    private Long sectorId;

    @Column(name = "Habilitado")
    private boolean Habilitado = true;

    @Column(name = "Estado")
    private boolean estado = true;


}
