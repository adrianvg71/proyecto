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

public interface ServicioEjercicio {

	<S extends EjercicioVO> S save(S entity);

	<S extends EjercicioVO> List<S> saveAll(Iterable<S> entities);

	<S extends EjercicioVO> Optional<S> findOne(Example<S> example);

	List<EjercicioVO> findAll(Sort sort);

	void flush();

	Page<EjercicioVO> findAll(Pageable pageable);

	<S extends EjercicioVO> S saveAndFlush(S entity);

	<S extends EjercicioVO> List<S> saveAllAndFlush(Iterable<S> entities);

	List<EjercicioVO> findAll();

	List<EjercicioVO> findAllById(Iterable<Integer> ids);

	void deleteInBatch(Iterable<EjercicioVO> entities);

	<S extends EjercicioVO> Page<S> findAll(Example<S> example, Pageable pageable);

	Optional<EjercicioVO> findById(Integer id);

	void deleteAllInBatch(Iterable<EjercicioVO> entities);

	boolean existsById(Integer id);

	<S extends EjercicioVO> long count(Example<S> example);

	void deleteAllByIdInBatch(Iterable<Integer> ids);

	<S extends EjercicioVO> boolean exists(Example<S> example);

	void deleteAllInBatch();

	EjercicioVO getOne(Integer id);

	<S extends EjercicioVO, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

	long count();

	void deleteById(Integer id);

	EjercicioVO getById(Integer id);

	void delete(EjercicioVO entity);

	void deleteAllById(Iterable<? extends Integer> ids);

	EjercicioVO getReferenceById(Integer id);

	void deleteAll(Iterable<? extends EjercicioVO> entities);

	<S extends EjercicioVO> List<S> findAll(Example<S> example);

	<S extends EjercicioVO> List<S> findAll(Example<S> example, Sort sort);

	void deleteAll();

	Optional<List<EjercicioVO>> findByNivel(String nivel);

}