package com.dawes.proyecto;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import com.dawes.proyecto.modelo.EjercicioVO;
import com.dawes.proyecto.servicios.ServicioEjercicio;

@SpringBootTest
@ComponentScan
@TestMethodOrder(MethodOrderer.MethodName.class)
class TestEjercicio {

	@Autowired
	private ServicioEjercicio se;

	@Test
	void test01Insertar() {
		assertNotNull(se.save(new EjercicioVO("ejercicio 1", "Ingles", "B1")));
	}

}
