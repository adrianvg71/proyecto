package com.dawes.proyecto.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

<<<<<<< HEAD
@AllArgsConstructor
@Data
@Entity

@Table(name = "usuarios")
public class UsuarioVO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idusuario;
	@Column(unique = true)
	private String correo;
	private String nombre;
	private String contraseña;

	private LocalDate fechacreacion;
	private String tipo;
	private String nivel;
	private String idioma;

=======
/**
 * Clase que representa un usuario.
 * 
 * <p>
 * Esta clase contiene la información de un usuario, incluyendo su correo,
 * nombre, contraseña, fecha de creación, tipo, nivel, idioma y los ejercicios
 * asociados.
 * </p>
 */
@AllArgsConstructor
@Data
@Entity
@Table(name = "usuarios")
public class UsuarioVO {

	/**
	 * Identificador único del usuario.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idusuario;

	/**
	 * Correo del usuario.
	 */
	@Column(unique = true)
	private String correo;

	/**
	 * Nombre del usuario.
	 */
	private String nombre;

	/**
	 * Contraseña del usuario.
	 */
	private String contraseña;

	/**
	 * Fecha de creación del usuario.
	 */
	private LocalDate fechacreacion;

	/**
	 * Tipo de usuario (e.g., admin, user).
	 */
	private String tipo;

	/**
	 * Nivel del usuario.
	 */
	private String nivel;

	/**
	 * Idioma preferido del usuario.
	 */
	private String idioma;

	/**
	 * Lista de ejercicios asociados al usuario.
	 */
>>>>>>> master
	@OneToMany(mappedBy = "usuario")
	@JsonBackReference
	private List<UsuarioEjercicioVO> ejercicios;

<<<<<<< HEAD
=======
	/**
	 * Constructor con parámetros correo, nombre y contraseña.
	 * 
	 * @param correo     el correo del usuario.
	 * @param nombre     el nombre del usuario.
	 * @param contraseña la contraseña del usuario.
	 */
>>>>>>> master
	public UsuarioVO(String correo, String nombre, String contraseña) {
		super();
		this.correo = correo;
		this.nombre = nombre;
		this.contraseña = contraseña;
		this.fechacreacion = LocalDate.now();
		this.ejercicios = new ArrayList<>();
	}
<<<<<<< HEAD
	
=======

	/**
	 * Constructor con parámetros correo, nombre, contraseña y tipo.
	 * 
	 * @param correo     el correo del usuario.
	 * @param nombre     el nombre del usuario.
	 * @param contraseña la contraseña del usuario.
	 * @param tipo       el tipo de usuario.
	 */
>>>>>>> master
	public UsuarioVO(String correo, String nombre, String contraseña, String tipo) {
		super();
		this.correo = correo;
		this.nombre = nombre;
		this.contraseña = contraseña;
		this.fechacreacion = LocalDate.now();
		this.tipo = tipo;
		this.ejercicios = new ArrayList<>();
	}
<<<<<<< HEAD
	
=======

	/**
	 * Constructor con parámetros correo, nombre, contraseña, tipo e idioma.
	 * 
	 * @param correo     el correo del usuario.
	 * @param nombre     el nombre del usuario.
	 * @param contraseña la contraseña del usuario.
	 * @param tipo       el tipo de usuario.
	 * @param idioma     el idioma preferido del usuario.
	 */
>>>>>>> master
	public UsuarioVO(String correo, String nombre, String contraseña, String tipo, String idioma) {
		super();
		this.correo = correo;
		this.nombre = nombre;
		this.contraseña = contraseña;
		this.fechacreacion = LocalDate.now();
		this.tipo = tipo;
		this.idioma = idioma;
		this.ejercicios = new ArrayList<>();
	}

<<<<<<< HEAD
=======
	/**
	 * Constructor por defecto que inicializa la fecha de creación a la fecha actual
	 * y establece el tipo de usuario como "user".
	 */
>>>>>>> master
	public UsuarioVO() {
		this.fechacreacion = LocalDate.now();
		this.ejercicios = new ArrayList<>();
		this.tipo = "user";
	}

	@Override
	public String toString() {
		return "usuario";
	}

<<<<<<< HEAD
=======
	public int getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public LocalDate getFechacreacion() {
		return fechacreacion;
	}

	public void setFechacreacion(LocalDate fechacreacion) {
		this.fechacreacion = fechacreacion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public List<UsuarioEjercicioVO> getEjercicios() {
		return ejercicios;
	}

	public void setEjercicios(List<UsuarioEjercicioVO> ejercicios) {
		this.ejercicios = ejercicios;
	}
>>>>>>> master
}
