package com.dinosaurio.turnero.repository;

import com.dinosaurio.turnero.entity.TurnoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurnoRepository  extends JpaRepository<TurnoEntity,Long> {
}
