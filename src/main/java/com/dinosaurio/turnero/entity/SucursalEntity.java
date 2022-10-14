package com.dinosaurio.turnero.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "sucursal")
@Getter
@Setter
@SQLDelete(sql = "UPDATE sucursal SET habilitado = 0 WHERE id=?")
@Where(clause = "Habilitado = 1")
public class SucursalEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "numero_sucursal")
    private int numeroSucursal;
    @Column(name = "descripcion")
    private String sucursal;

    @OneToMany(mappedBy="sucursal")
    private Set<TurnoEntity> turnos;

    @OneToMany(mappedBy="sucursal")
    private Set<UsuarioEntity> usuarios;

    @Column(name = "Habilitado")
    private boolean Habilitado = true;



    //Metodos add and remove de entidades
    public void addUsuario(UsuarioEntity usuarioEntity){ this.usuarios.add(usuarioEntity);}

    public void addTurno(TurnoEntity turnoEntity){this.turnos.add(turnoEntity);}

    public void removeUsuario(UsuarioEntity usuarioEntity){this.usuarios.remove(usuarioEntity);}

    public void removeTurno(TurnoEntity turnoEntity){this.turnos.remove(turnoEntity);}

}
