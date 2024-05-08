package com.dawes.proyecto;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import com.dawes.proyecto.modelo.UsuarioVO;
import com.dawes.proyecto.servicios.ServicioUsuario;

@SpringBootTest
@ComponentScan
@TestMethodOrder(MethodOrderer.MethodName.class)
class TestUsuario {

	@Autowired
	private ServicioUsuario su;

	@Test
	void test01Insertar() {
		assertNotNull(su.save(new UsuarioVO("adrixc4@gmail.com", "adrixc4", "1234")));
	}

	@Test
	void test02Modificar() {
		UsuarioVO usu = su.findByCorreo("adrixc4@gmail.com").get();
		usu.setContraseña("contrasEñA");
		assertNotNull(su.save(usu));
	}

}
