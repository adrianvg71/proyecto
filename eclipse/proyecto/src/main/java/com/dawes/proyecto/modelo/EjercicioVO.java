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

	@OneToMany(mappedBy = "ejercicio")
	@JsonBackReference
	private List<UsuarioEjercicioVO> usuarios;

	@OneToMany(mappedBy = "ejercicio")
	private List<PreguntaVO> preguntas;

	public EjercicioVO(String nombre, String idioma, String nivel) {
		super();
		this.nombre = nombre;
		this.idioma = idioma;
		this.nivel = nivel;
		this.usuarios = new ArrayList<>();
		this.preguntas = new ArrayList<>();
	}

	public EjercicioVO() {
		this.usuarios = new ArrayList<>();
		this.preguntas = new ArrayList<>();
	}

}
