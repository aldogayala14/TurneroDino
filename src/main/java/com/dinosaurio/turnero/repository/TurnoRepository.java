package com.dinosaurio.turnero.repository;

import com.dinosaurio.turnero.entity.TurnoEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface TurnoRepository  extends JpaRepository<TurnoEntity,Long> {
    List<TurnoEntity> findAll(Specification<TurnoEntity> specification);

    @Query(value = "EXEC SP_SET_ESTADO", nativeQuery = true)
    void setEstado();
}
