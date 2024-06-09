package com.dawes.proyecto.servicios;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import com.dawes.proyecto.modelo.OpcionVO;

/**
 * Interfaz para el servicio relacionado con la entidad {@link OpcionVO}.
 * 
 * <p>
 * Define métodos para realizar operaciones CRUD y consultas personalizadas en
 * la entidad OpcionVO.
 * </p>
 */
public interface ServicioOpcion {

	<S extends OpcionVO> S save(S entity);

	<S extends OpcionVO> List<S> saveAll(Iterable<S> entities);

	<S extends OpcionVO> Optional<S> findOne(Example<S> example);

	List<OpcionVO> findAll(Sort sort);

	void flush();

	Page<OpcionVO> findAll(Pageable pageable);

	<S extends OpcionVO> S saveAndFlush(S entity);

	<S extends OpcionVO> List<S> saveAllAndFlush(Iterable<S> entities);

	List<OpcionVO> findAll();

	List<OpcionVO> findAllById(Iterable<Integer> ids);

	void deleteInBatch(Iterable<OpcionVO> entities);

	<S extends OpcionVO> Page<S> findAll(Example<S> example, Pageable pageable);

	Optional<OpcionVO> findById(Integer id);

	void deleteAllInBatch(Iterable<OpcionVO> entities);

	boolean existsById(Integer id);

	<S extends OpcionVO> long count(Example<S> example);

	void deleteAllByIdInBatch(Iterable<Integer> ids);

	<S extends OpcionVO> boolean exists(Example<S> example);

	void deleteAllInBatch();

	OpcionVO getOne(Integer id);

	<S extends OpcionVO, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

	long count();

	void deleteById(Integer id);

	OpcionVO getById(Integer id);

	void delete(OpcionVO entity);

	void deleteAllById(Iterable<? extends Integer> ids);

	OpcionVO getReferenceById(Integer id);

	void deleteAll(Iterable<? extends OpcionVO> entities);

	<S extends OpcionVO> List<S> findAll(Example<S> example);

	<S extends OpcionVO> List<S> findAll(Example<S> example, Sort sort);

	void deleteAll();

}
