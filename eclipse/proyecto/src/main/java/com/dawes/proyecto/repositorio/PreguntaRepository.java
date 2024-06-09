package com.dawes.proyecto.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dawes.proyecto.modelo.EjercicioVO;
import com.dawes.proyecto.modelo.PreguntaVO;

@Repository
public interface PreguntaRepository extends JpaRepository<PreguntaVO, Integer> {

	Optional<List<PreguntaVO>> findByEjercicio(EjercicioVO ejercicio);
}
