package com.dawes.proyecto.servicios;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import com.dawes.proyecto.modelo.EjercicioVO;
import com.dawes.proyecto.modelo.PreguntaVO;

public interface ServicioPregunta {

	<S extends PreguntaVO> S save(S entity);

	<S extends PreguntaVO> List<S> saveAll(Iterable<S> entities);

	<S extends PreguntaVO> Optional<S> findOne(Example<S> example);

	List<PreguntaVO> findAll(Sort sort);

	void flush();

	Page<PreguntaVO> findAll(Pageable pageable);

	<S extends PreguntaVO> S saveAndFlush(S entity);

	<S extends PreguntaVO> List<S> saveAllAndFlush(Iterable<S> entities);

	List<PreguntaVO> findAll();

	List<PreguntaVO> findAllById(Iterable<Integer> ids);

	void deleteInBatch(Iterable<PreguntaVO> entities);

	<S extends PreguntaVO> Page<S> findAll(Example<S> example, Pageable pageable);

	Optional<PreguntaVO> findById(Integer id);

	void deleteAllInBatch(Iterable<PreguntaVO> entities);

	boolean existsById(Integer id);

	<S extends PreguntaVO> long count(Example<S> example);

	void deleteAllByIdInBatch(Iterable<Integer> ids);

	<S extends PreguntaVO> boolean exists(Example<S> example);

	void deleteAllInBatch();

	PreguntaVO getOne(Integer id);

	<S extends PreguntaVO, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

	long count();

	void deleteById(Integer id);

	PreguntaVO getById(Integer id);

	void delete(PreguntaVO entity);

	void deleteAllById(Iterable<? extends Integer> ids);

	PreguntaVO getReferenceById(Integer id);

	void deleteAll(Iterable<? extends PreguntaVO> entities);

	<S extends PreguntaVO> List<S> findAll(Example<S> example);

	<S extends PreguntaVO> List<S> findAll(Example<S> example, Sort sort);

	void deleteAll();

	Optional<List<PreguntaVO>> findByEjercicio(EjercicioVO ejercicio);

}