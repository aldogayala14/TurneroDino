package com.dinosaurio.turnero.repository;

import com.dinosaurio.turnero.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity,Long>  {
}
