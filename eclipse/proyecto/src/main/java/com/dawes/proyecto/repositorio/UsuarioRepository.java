package com.dawes.proyecto.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dawes.proyecto.modelo.UsuarioVO;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioVO, Integer> {

	Optional<UsuarioVO> findByCorreo(String correo);
}
