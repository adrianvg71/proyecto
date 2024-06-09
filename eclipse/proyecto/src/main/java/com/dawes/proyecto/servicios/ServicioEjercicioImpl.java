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
import com.dawes.proyecto.repositorio.EjercicioRepository;

<<<<<<< HEAD
=======
/**
 * Implementación del servicio relacionado con la entidad {@link EjercicioVO}.
 * 
 * <p>
 * Proporciona implementaciones para los métodos definidos en
 * {@link ServicioEjercicio}.
 * </p>
 */
>>>>>>> master
@Service
public class ServicioEjercicioImpl implements ServicioEjercicio {

	@Autowired
	private EjercicioRepository er;

	@Override
	public <S extends EjercicioVO> S save(S entity) {
		return er.save(entity);
	}

	@Override
	public <S extends EjercicioVO> List<S> saveAll(Iterable<S> entities) {
		return er.saveAll(entities);
	}

	@Override
	public <S extends EjercicioVO> Optional<S> findOne(Example<S> example) {
		return er.findOne(example);
	}

	@Override
	public List<EjercicioVO> findAll(Sort sort) {
		return er.findAll(sort);
	}

	@Override
	public void flush() {
		er.flush();
	}

	@Override
	public Page<EjercicioVO> findAll(Pageable pageable) {
		return er.findAll(pageable);
	}

	@Override
	public <S extends EjercicioVO> S saveAndFlush(S entity) {
		return er.saveAndFlush(entity);
	}

	@Override
	public <S extends EjercicioVO> List<S> saveAllAndFlush(Iterable<S> entities) {
		return er.saveAllAndFlush(entities);
	}

	@Override
	public List<EjercicioVO> findAll() {
		return er.findAll();
	}

	@Override
	public List<EjercicioVO> findAllById(Iterable<Integer> ids) {
		return er.findAllById(ids);
	}

	@Override
	public void deleteInBatch(Iterable<EjercicioVO> entities) {
		er.deleteInBatch(entities);
	}

	@Override
	public <S extends EjercicioVO> Page<S> findAll(Example<S> example, Pageable pageable) {
		return er.findAll(example, pageable);
	}

	@Override
	public Optional<EjercicioVO> findById(Integer id) {
		return er.findById(id);
	}

	@Override
	public void deleteAllInBatch(Iterable<EjercicioVO> entities) {
		er.deleteAllInBatch(entities);
	}

	@Override
	public boolean existsById(Integer id) {
		return er.existsById(id);
	}

	@Override
	public <S extends EjercicioVO> long count(Example<S> example) {
		return er.count(example);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Integer> ids) {
		er.deleteAllByIdInBatch(ids);
	}

	@Override
	public <S extends EjercicioVO> boolean exists(Example<S> example) {
		return er.exists(example);
	}

	@Override
	public void deleteAllInBatch() {
		er.deleteAllInBatch();
	}

	@Override
	public EjercicioVO getOne(Integer id) {
		return er.getOne(id);
	}

	@Override
	public <S extends EjercicioVO, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		return er.findBy(example, queryFunction);
	}

	@Override
	public long count() {
		return er.count();
	}

	@Override
	public void deleteById(Integer id) {
		er.deleteById(id);
	}

	@Override
	public EjercicioVO getById(Integer id) {
		return er.getById(id);
	}

	@Override
	public void delete(EjercicioVO entity) {
		er.delete(entity);
	}

	@Override
	public void deleteAllById(Iterable<? extends Integer> ids) {
		er.deleteAllById(ids);
	}

	@Override
	public EjercicioVO getReferenceById(Integer id) {
		return er.getReferenceById(id);
	}

	@Override
	public void deleteAll(Iterable<? extends EjercicioVO> entities) {
		er.deleteAll(entities);
	}

	@Override
	public <S extends EjercicioVO> List<S> findAll(Example<S> example) {
		return er.findAll(example);
	}

	@Override
	public <S extends EjercicioVO> List<S> findAll(Example<S> example, Sort sort) {
		return er.findAll(example, sort);
	}

	@Override
	public void deleteAll() {
		er.deleteAll();
	}

	@Override
	public Optional<List<EjercicioVO>> findByNivel(String nivel) {
		return er.findByNivel(nivel);
	}

}
