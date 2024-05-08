package com.dawes.proyecto.servicios;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import com.dawes.proyecto.modelo.UsuarioEjercicioVO;

public interface ServicioUsuarioEjercicio {

	<S extends UsuarioEjercicioVO> S save(S entity);

	<S extends UsuarioEjercicioVO> List<S> saveAll(Iterable<S> entities);

	<S extends UsuarioEjercicioVO> Optional<S> findOne(Example<S> example);

	List<UsuarioEjercicioVO> findAll(Sort sort);

	void flush();

	Page<UsuarioEjercicioVO> findAll(Pageable pageable);

	<S extends UsuarioEjercicioVO> S saveAndFlush(S entity);

	<S extends UsuarioEjercicioVO> List<S> saveAllAndFlush(Iterable<S> entities);

	List<UsuarioEjercicioVO> findAll();

	List<UsuarioEjercicioVO> findAllById(Iterable<Integer> ids);

	void deleteInBatch(Iterable<UsuarioEjercicioVO> entities);

	<S extends UsuarioEjercicioVO> Page<S> findAll(Example<S> example, Pageable pageable);

	Optional<UsuarioEjercicioVO> findById(Integer id);

	void deleteAllInBatch(Iterable<UsuarioEjercicioVO> entities);

	boolean existsById(Integer id);

	<S extends UsuarioEjercicioVO> long count(Example<S> example);

	void deleteAllByIdInBatch(Iterable<Integer> ids);

	<S extends UsuarioEjercicioVO> boolean exists(Example<S> example);

	void deleteAllInBatch();

	UsuarioEjercicioVO getOne(Integer id);

	<S extends UsuarioEjercicioVO, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

	long count();

	void deleteById(Integer id);

	UsuarioEjercicioVO getById(Integer id);

	void delete(UsuarioEjercicioVO entity);

	void deleteAllById(Iterable<? extends Integer> ids);

	UsuarioEjercicioVO getReferenceById(Integer id);

	void deleteAll(Iterable<? extends UsuarioEjercicioVO> entities);

	<S extends UsuarioEjercicioVO> List<S> findAll(Example<S> example);

	<S extends UsuarioEjercicioVO> List<S> findAll(Example<S> example, Sort sort);

	void deleteAll();

}