package com.dawes.proyecto.servicios;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import com.dawes.proyecto.modelo.HashKey;
import com.dawes.proyecto.repositorio.HashKeyRepository;

@Service
public class ServicioHashKeyImpl implements ServicioHashKey {

	@Autowired
	private HashKeyRepository hsk;

	@Override
	public <S extends HashKey> S save(S entity) {
		return hsk.save(entity);
	}

	@Override
	public <S extends HashKey> List<S> saveAll(Iterable<S> entities) {
		return hsk.saveAll(entities);
	}

	@Override
	public <S extends HashKey> Optional<S> findOne(Example<S> example) {
		return hsk.findOne(example);
	}

	@Override
	public List<HashKey> findAll(Sort sort) {
		return hsk.findAll(sort);
	}

	@Override
	public void flush() {
		hsk.flush();
	}

	@Override
	public Page<HashKey> findAll(Pageable pageable) {
		return hsk.findAll(pageable);
	}

	@Override
	public <S extends HashKey> S saveAndFlush(S entity) {
		return hsk.saveAndFlush(entity);
	}

	@Override
	public <S extends HashKey> List<S> saveAllAndFlush(Iterable<S> entities) {
		return hsk.saveAllAndFlush(entities);
	}

	@Override
	public List<HashKey> findAll() {
		return hsk.findAll();
	}

	@Override
	public List<HashKey> findAllById(Iterable<Integer> ids) {
		return hsk.findAllById(ids);
	}

	@Override
	public void deleteInBatch(Iterable<HashKey> entities) {
		hsk.deleteInBatch(entities);
	}

	@Override
	public <S extends HashKey> Page<S> findAll(Example<S> example, Pageable pageable) {
		return hsk.findAll(example, pageable);
	}

	@Override
	public Optional<HashKey> findById(Integer id) {
		return hsk.findById(id);
	}

	@Override
	public void deleteAllInBatch(Iterable<HashKey> entities) {
		hsk.deleteAllInBatch(entities);
	}

	@Override
	public boolean existsById(Integer id) {
		return hsk.existsById(id);
	}

	@Override
	public <S extends HashKey> long count(Example<S> example) {
		return hsk.count(example);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Integer> ids) {
		hsk.deleteAllByIdInBatch(ids);
	}

	@Override
	public <S extends HashKey> boolean exists(Example<S> example) {
		return hsk.exists(example);
	}

	@Override
	public void deleteAllInBatch() {
		hsk.deleteAllInBatch();
	}

	@Override
	public HashKey getOne(Integer id) {
		return hsk.getOne(id);
	}

	@Override
	public <S extends HashKey, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		return hsk.findBy(example, queryFunction);
	}

	@Override
	public long count() {
		return hsk.count();
	}

	@Override
	public void deleteById(Integer id) {
		hsk.deleteById(id);
	}

	@Override
	public HashKey getById(Integer id) {
		return hsk.getById(id);
	}

	@Override
	public void delete(HashKey entity) {
		hsk.delete(entity);
	}

	@Override
	public void deleteAllById(Iterable<? extends Integer> ids) {
		hsk.deleteAllById(ids);
	}

	@Override
	public HashKey getReferenceById(Integer id) {
		return hsk.getReferenceById(id);
	}

	@Override
	public void deleteAll(Iterable<? extends HashKey> entities) {
		hsk.deleteAll(entities);
	}

	@Override
	public <S extends HashKey> List<S> findAll(Example<S> example) {
		return hsk.findAll(example);
	}

	@Override
	public <S extends HashKey> List<S> findAll(Example<S> example, Sort sort) {
		return hsk.findAll(example, sort);
	}

	@Override
	public void deleteAll() {
		hsk.deleteAll();
	}

}
