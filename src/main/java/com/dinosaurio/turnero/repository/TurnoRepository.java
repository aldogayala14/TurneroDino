package com.dinosaurio.turnero.repository;

import com.dinosaurio.turnero.entity.TurnoEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TurnoRepository  extends JpaRepository<TurnoEntity,Long> {
    List<TurnoEntity> findAll(Specification<TurnoEntity> specification);

    @Procedure(value = "SP_SET_ESTADO")
    void setEstado();
}
