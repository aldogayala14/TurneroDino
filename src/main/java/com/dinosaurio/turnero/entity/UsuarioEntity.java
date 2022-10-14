package com.dinosaurio.turnero.entity;



import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "usuario")
@Getter
@Setter
@SQLDelete(sql = "UPDATE usuario SET habilitado = 0 WHERE id=?")
@Where(clause = "habilitado = 1")
public class UsuarioEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "nombre_usuario")
    private String nombreUsuario;
    @Column(name = "password")
    private String password;
    @ManyToOne
    @JoinColumn(name="sucursal_id", nullable=false)
    private SucursalEntity sucursal;

    @Column(name = "Habilitado")
    private boolean Habilitado = true;
}
