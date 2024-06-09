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
import com.dawes.proyecto.modelo.UsuarioEjercicioVO;
import com.dawes.proyecto.modelo.UsuarioVO;
import com.dawes.proyecto.repositorio.UsuarioEjercicioRepository;

/**
 * Implementación de ServicioUsuarioEjercicio que proporciona métodos para
 * realizar operaciones CRUD relacionadas con UsuarioEjercicio.
 */
@Service
public class ServicioUsuarioEjercicioImpl implements ServicioUsuarioEjercicio {

	@Autowired
	private UsuarioEjercicioRepository uer;

	@Override
	public <S extends UsuarioEjercicioVO> S save(S entity) {
		return uer.save(entity);
	}

	@Override
	public <S extends UsuarioEjercicioVO> List<S> saveAll(Iterable<S> entities) {
		return uer.saveAll(entities);
	}

	@Override
	public <S extends UsuarioEjercicioVO> Optional<S> findOne(Example<S> example) {
		return uer.findOne(example);
	}

	@Override
	public List<UsuarioEjercicioVO> findAll(Sort sort) {
		return uer.findAll(sort);
	}

	@Override
	public void flush() {
		uer.flush();
	}

	@Override
	public Page<UsuarioEjercicioVO> findAll(Pageable pageable) {
		return uer.findAll(pageable);
	}

	@Override
	public <S extends UsuarioEjercicioVO> S saveAndFlush(S entity) {
		return uer.saveAndFlush(entity);
	}

	@Override
	public <S extends UsuarioEjercicioVO> List<S> saveAllAndFlush(Iterable<S> entities) {
		return uer.saveAllAndFlush(entities);
	}

	@Override
	public List<UsuarioEjercicioVO> findAll() {
		return uer.findAll();
	}

	@Override
	public List<UsuarioEjercicioVO> findAllById(Iterable<Integer> ids) {
		return uer.findAllById(ids);
	}

	@Override
	public void deleteInBatch(Iterable<UsuarioEjercicioVO> entities) {
		uer.deleteInBatch(entities);
	}

	@Override
	public <S extends UsuarioEjercicioVO> Page<S> findAll(Example<S> example, Pageable pageable) {
		return uer.findAll(example, pageable);
	}

	@Override
	public Optional<UsuarioEjercicioVO> findById(Integer id) {
		return uer.findById(id);
	}

	@Override
	public void deleteAllInBatch(Iterable<UsuarioEjercicioVO> entities) {
		uer.deleteAllInBatch(entities);
	}

	@Override
	public boolean existsById(Integer id) {
		return uer.existsById(id);
	}

	@Override
	public <S extends UsuarioEjercicioVO> long count(Example<S> example) {
		return uer.count(example);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Integer> ids) {
		uer.deleteAllByIdInBatch(ids);
	}

	@Override
	public <S extends UsuarioEjercicioVO> boolean exists(Example<S> example) {
		return uer.exists(example);
	}

	@Override
	public void deleteAllInBatch() {
		uer.deleteAllInBatch();
	}

	@Override
	public UsuarioEjercicioVO getOne(Integer id) {
		return uer.getOne(id);
	}

	@Override
	public <S extends UsuarioEjercicioVO, R> R findBy(Example<S> example,
			Function<FetchableFluentQuery<S>, R> queryFunction) {
		return uer.findBy(example, queryFunction);
	}

	@Override
	public long count() {
		return uer.count();
	}

	@Override
	public void deleteById(Integer id) {
		uer.deleteById(id);
	}

	@Override
	public UsuarioEjercicioVO getById(Integer id) {
		return uer.getById(id);
	}

	@Override
	public void delete(UsuarioEjercicioVO entity) {
		uer.delete(entity);
	}

	@Override
	public void deleteAllById(Iterable<? extends Integer> ids) {
		uer.deleteAllById(ids);
	}

	@Override
	public UsuarioEjercicioVO getReferenceById(Integer id) {
		return uer.getReferenceById(id);
	}

	@Override
	public void deleteAll(Iterable<? extends UsuarioEjercicioVO> entities) {
		uer.deleteAll(entities);
	}

	@Override
	public <S extends UsuarioEjercicioVO> List<S> findAll(Example<S> example) {
		return uer.findAll(example);
	}

	@Override
	public <S extends UsuarioEjercicioVO> List<S> findAll(Example<S> example, Sort sort) {
		return uer.findAll(example, sort);
	}

	@Override
	public void deleteAll() {
		uer.deleteAll();
	}

	@Override
	public Optional<UsuarioEjercicioVO> findByUsuarioAndEjercicio(UsuarioVO user, EjercicioVO ejer) {
		return uer.findByUsuarioAndEjercicio(user, ejer);
	}

	@Override
	public Optional<List<UsuarioEjercicioVO>> findByUsuario(UsuarioVO user) {
		return uer.findByUsuario(user);
	}

}
