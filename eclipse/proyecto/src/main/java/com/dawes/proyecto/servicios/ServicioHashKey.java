package com.dawes.proyecto.servicios;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import com.dawes.proyecto.modelo.HashKey;

public interface ServicioHashKey {

	<S extends HashKey> S save(S entity);

	<S extends HashKey> List<S> saveAll(Iterable<S> entities);

	<S extends HashKey> Optional<S> findOne(Example<S> example);

	List<HashKey> findAll(Sort sort);

	void flush();

	Page<HashKey> findAll(Pageable pageable);

	<S extends HashKey> S saveAndFlush(S entity);

	<S extends HashKey> List<S> saveAllAndFlush(Iterable<S> entities);

	List<HashKey> findAll();

	List<HashKey> findAllById(Iterable<Integer> ids);

	void deleteInBatch(Iterable<HashKey> entities);

	<S extends HashKey> Page<S> findAll(Example<S> example, Pageable pageable);

	Optional<HashKey> findById(Integer id);

	void deleteAllInBatch(Iterable<HashKey> entities);

	boolean existsById(Integer id);

	<S extends HashKey> long count(Example<S> example);

	void deleteAllByIdInBatch(Iterable<Integer> ids);

	<S extends HashKey> boolean exists(Example<S> example);

	void deleteAllInBatch();

	HashKey getOne(Integer id);

	<S extends HashKey, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

	long count();

	void deleteById(Integer id);

	HashKey getById(Integer id);

	void delete(HashKey entity);

	void deleteAllById(Iterable<? extends Integer> ids);

	HashKey getReferenceById(Integer id);

	void deleteAll(Iterable<? extends HashKey> entities);

	<S extends HashKey> List<S> findAll(Example<S> example);

	<S extends HashKey> List<S> findAll(Example<S> example, Sort sort);

	void deleteAll();

}