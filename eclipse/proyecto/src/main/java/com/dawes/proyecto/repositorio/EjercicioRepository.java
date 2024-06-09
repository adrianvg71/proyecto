package com.dawes.proyecto.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dawes.proyecto.modelo.EjercicioVO;

@Repository
public interface EjercicioRepository extends JpaRepository<EjercicioVO, Integer> {

	Optional<List<EjercicioVO>> findByNivel(String nivel);
}
