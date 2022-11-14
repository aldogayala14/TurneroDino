package com.dinosaurio.turnero.entity;



import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


@Entity
@Table(name = "usuario")
@Getter
@Setter
@SQLDelete(sql = "UPDATE usuario SET habilitado = 0 WHERE id=?")
@Where(clause = "habilitado = 1")
public class UsuarioEntity implements Serializable, UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "nombre_usuario")
    private String username;
    @Column(name = "password")
    private String password;
    @ManyToOne
    @JoinColumn(name="sucursal_id", nullable=false)
    private SucursalEntity sucursal;

    @Column(name = "Habilitado")
    private boolean Habilitado = true;

    @ManyToOne
    @JoinColumn(name = "ROLE_ID", insertable = false,updatable = false, referencedColumnName = "ID")
    private RoleEntity role;

    @Column(name = "ROLE_ID", nullable = false)
    private Long roleId;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(getRole().getName().toString()));
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
