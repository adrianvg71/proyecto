package com.dawes.proyecto.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dawes.proyecto.modelo.EjercicioVO;
import com.dawes.proyecto.modelo.UsuarioEjercicioVO;
import com.dawes.proyecto.modelo.UsuarioVO;

@Repository
public interface UsuarioEjercicioRepository extends JpaRepository<UsuarioEjercicioVO, Integer> {

	Optional<UsuarioEjercicioVO> findByUsuarioAndEjercicio(UsuarioVO user, EjercicioVO ejer);

	Optional<List<UsuarioEjercicioVO>> findByUsuario(UsuarioVO user);
}
