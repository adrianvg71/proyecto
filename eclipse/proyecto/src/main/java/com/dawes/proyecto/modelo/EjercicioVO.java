package com.dawes.proyecto.modelo;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;

<<<<<<< HEAD
@AllArgsConstructor
@Data
@Entity

@Table(name = "ejercicios", uniqueConstraints = { @UniqueConstraint(columnNames = { "nombre", "idioma", "nivel" }) })
public class EjercicioVO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idejercicio;
	private String nombre;
	private String idioma;
	private String nivel;

=======
/**
 * Clase que representa un ejercicio.
 * 
 * <p>
 * Esta clase contiene la información de un ejercicio, incluyendo su nombre,
 * idioma, nivel y las listas de usuarios y preguntas asociadas.
 * </p>
 */
@AllArgsConstructor
@Data
@Entity
@Table(name = "ejercicios", uniqueConstraints = { @UniqueConstraint(columnNames = { "nombre", "idioma", "nivel" }) })
public class EjercicioVO {

	/**
	 * Identificador único del ejercicio.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idejercicio;

	/**
	 * Nombre del ejercicio.
	 */
	private String nombre;

	/**
	 * Idioma del ejercicio.
	 */
	private String idioma;

	/**
	 * Nivel del ejercicio.
	 */
	private String nivel;

	/**
	 * Lista de usuarios asociados al ejercicio.
	 */
>>>>>>> master
	@OneToMany(mappedBy = "ejercicio")
	@JsonBackReference
	private List<UsuarioEjercicioVO> usuarios;

<<<<<<< HEAD
	@OneToMany(mappedBy = "ejercicio")
	private List<PreguntaVO> preguntas;

=======
	/**
	 * Lista de preguntas asociadas al ejercicio.
	 */
	@OneToMany(mappedBy = "ejercicio")
	private List<PreguntaVO> preguntas;

	/**
	 * Constructor con parámetros nombre, idioma y nivel.
	 * 
	 * @param nombre el nombre del ejercicio.
	 * @param idioma el idioma del ejercicio.
	 * @param nivel  el nivel del ejercicio.
	 */
>>>>>>> master
	public EjercicioVO(String nombre, String idioma, String nivel) {
		super();
		this.nombre = nombre;
		this.idioma = idioma;
		this.nivel = nivel;
		this.usuarios = new ArrayList<>();
		this.preguntas = new ArrayList<>();
	}

<<<<<<< HEAD
=======
	/**
	 * Constructor por defecto.
	 */
>>>>>>> master
	public EjercicioVO() {
		this.usuarios = new ArrayList<>();
		this.preguntas = new ArrayList<>();
	}

<<<<<<< HEAD
=======
	public int getIdejercicio() {
		return idejercicio;
	}

	public void setIdejercicio(int idejercicio) {
		this.idejercicio = idejercicio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public List<UsuarioEjercicioVO> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<UsuarioEjercicioVO> usuarios) {
		this.usuarios = usuarios;
	}

	public List<PreguntaVO> getPreguntas() {
		return preguntas;
	}

	public void setPreguntas(List<PreguntaVO> preguntas) {
		this.preguntas = preguntas;
	}
>>>>>>> master
}
