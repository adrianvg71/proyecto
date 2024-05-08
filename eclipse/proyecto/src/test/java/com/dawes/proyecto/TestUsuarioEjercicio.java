package com.dawes.proyecto;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import com.dawes.proyecto.modelo.EjercicioVO;
import com.dawes.proyecto.modelo.UsuarioEjercicioVO;
import com.dawes.proyecto.modelo.UsuarioVO;
import com.dawes.proyecto.servicios.ServicioEjercicio;
import com.dawes.proyecto.servicios.ServicioUsuario;
import com.dawes.proyecto.servicios.ServicioUsuarioEjercicio;

@SpringBootTest
@ComponentScan
@TestMethodOrder(MethodOrderer.MethodName.class)
class TestUsuarioEjercicio {

	@Autowired
	private ServicioUsuario su;
	@Autowired
	private ServicioEjercicio se;
	@Autowired
	private ServicioUsuarioEjercicio sue;

	@Test
	void test01Insertar() {
		UsuarioVO usu = su.findByCorreo("adrixc4@gmail.com").get();
		EjercicioVO ejer = se.findById(1).get();

		assertNotNull(sue.save(new UsuarioEjercicioVO(usu, ejer, 10)));
	}

	@Test
	void test02FindById() {
		assertEquals(10, sue.findById(1).get().getAciertos());
	}

	@Test
	void test03Modificar() {
		UsuarioEjercicioVO usuej = sue.findById(1).get();
		usuej.setAciertos(5);
		assertNotNull(sue.save(usuej));
	}
}
