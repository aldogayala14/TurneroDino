package com.dinosaurio.turnero.entity;


import com.dinosaurio.turnero.util.RoleEnum;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "role")
@Getter
@Setter
public class RoleEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name="name",nullable=false)
    @NotNull
    @Enumerated(EnumType.STRING)
    private RoleEnum.roleEnum name;
    @Column(name="description")
    private String description;
    @Column(name="creation_date",updatable=false)
    @CreationTimestamp
    private Timestamp creationDate;
    @Column(name="update_date")
    @UpdateTimestamp
    private Timestamp updateDate;



}
