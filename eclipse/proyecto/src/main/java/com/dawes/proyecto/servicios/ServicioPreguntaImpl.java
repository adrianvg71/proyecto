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

import com.dawes.proyecto.modelo.EjercicioVO;
import com.dawes.proyecto.modelo.PreguntaVO;
import com.dawes.proyecto.repositorio.PreguntaRepository;

/**
 * Implementación del servicio de preguntas.
 */

@Service
public class ServicioPreguntaImpl implements ServicioPregunta {

	@Autowired
	private PreguntaRepository pr;

	@Override
	public <S extends PreguntaVO> S save(S entity) {
		return pr.save(entity);
	}

	@Override
	public <S extends PreguntaVO> List<S> saveAll(Iterable<S> entities) {
		return pr.saveAll(entities);
	}

	@Override
	public <S extends PreguntaVO> Optional<S> findOne(Example<S> example) {
		return pr.findOne(example);
	}

	@Override
	public List<PreguntaVO> findAll(Sort sort) {
		return pr.findAll(sort);
	}

	@Override
	public void flush() {
		pr.flush();
	}

	@Override
	public Page<PreguntaVO> findAll(Pageable pageable) {
		return pr.findAll(pageable);
	}

	@Override
	public <S extends PreguntaVO> S saveAndFlush(S entity) {
		return pr.saveAndFlush(entity);
	}

	@Override
	public <S extends PreguntaVO> List<S> saveAllAndFlush(Iterable<S> entities) {
		return pr.saveAllAndFlush(entities);
	}

	@Override
	public List<PreguntaVO> findAll() {
		return pr.findAll();
	}

	@Override
	public List<PreguntaVO> findAllById(Iterable<Integer> ids) {
		return pr.findAllById(ids);
	}

	@Override
	public void deleteInBatch(Iterable<PreguntaVO> entities) {
		pr.deleteInBatch(entities);
	}

	@Override
	public <S extends PreguntaVO> Page<S> findAll(Example<S> example, Pageable pageable) {
		return pr.findAll(example, pageable);
	}

	@Override
	public Optional<PreguntaVO> findById(Integer id) {
		return pr.findById(id);
	}

	@Override
	public void deleteAllInBatch(Iterable<PreguntaVO> entities) {
		pr.deleteAllInBatch(entities);
	}

	@Override
	public boolean existsById(Integer id) {
		return pr.existsById(id);
	}

	@Override
	public <S extends PreguntaVO> long count(Example<S> example) {
		return pr.count(example);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Integer> ids) {
		pr.deleteAllByIdInBatch(ids);
	}

	@Override
	public <S extends PreguntaVO> boolean exists(Example<S> example) {
		return pr.exists(example);
	}

	@Override
	public void deleteAllInBatch() {
		pr.deleteAllInBatch();
	}

	@Override
	public PreguntaVO getOne(Integer id) {
		return pr.getOne(id);
	}

	@Override
	public <S extends PreguntaVO, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		return pr.findBy(example, queryFunction);
	}

	@Override
	public long count() {
		return pr.count();
	}

	@Override
	public void deleteById(Integer id) {
		pr.deleteById(id);
	}

	@Override
	public PreguntaVO getById(Integer id) {
		return pr.getById(id);
	}

	@Override
	public void delete(PreguntaVO entity) {
		pr.delete(entity);
	}

	@Override
	public void deleteAllById(Iterable<? extends Integer> ids) {
		pr.deleteAllById(ids);
	}

	@Override
	public PreguntaVO getReferenceById(Integer id) {
		return pr.getReferenceById(id);
	}

	@Override
	public void deleteAll(Iterable<? extends PreguntaVO> entities) {
		pr.deleteAll(entities);
	}

	@Override
	public <S extends PreguntaVO> List<S> findAll(Example<S> example) {
		return pr.findAll(example);
	}

	@Override
	public <S extends PreguntaVO> List<S> findAll(Example<S> example, Sort sort) {
		return pr.findAll(example, sort);
	}

	@Override
	public void deleteAll() {
		pr.deleteAll();
	}

	@Override
	public Optional<List<PreguntaVO>> findByEjercicio(EjercicioVO ejercicio) {
		return pr.findByEjercicio(ejercicio);
	}

}
