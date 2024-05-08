package com.dawes.proyecto;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ TestEjercicio.class, TestUsuario.class, TestUsuarioEjercicio.class })
public class AllTests {

}
