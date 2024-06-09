package com.dawes.proyecto.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

<<<<<<< HEAD
=======
/**
 * Clase que representa una opción de una pregunta.
 * 
 * <p>
 * Esta clase contiene la información de una opción, incluyendo su descripción,
 * si es correcta y la pregunta a la que pertenece.
 * </p>
 */
>>>>>>> master
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Data
@Entity
<<<<<<< HEAD

@Table(name = "opciones")
public class OpcionVO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idopcion;
	@NonNull
	private String descripcion;
	@NonNull
	private Boolean correcta;
=======
@Table(name = "opciones")
public class OpcionVO {

	/**
	 * Identificador único de la opción.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idopcion;

	/**
	 * Descripción de la opción.
	 */
	@NonNull
	private String descripcion;

	/**
	 * Indica si la opción es correcta o no.
	 */
	@NonNull
	private Boolean correcta;

	/**
	 * Pregunta a la que pertenece la opción.
	 */
>>>>>>> master
	@ManyToOne
	@JoinColumn(name = "idpregunta")
	@JsonIgnore
	@NonNull
	private PreguntaVO pregunta;
<<<<<<< HEAD
=======

	public int getIdopcion() {
		return idopcion;
	}

	public void setIdopcion(int idopcion) {
		this.idopcion = idopcion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Boolean getCorrecta() {
		return correcta;
	}

	public void setCorrecta(Boolean correcta) {
		this.correcta = correcta;
	}

	public PreguntaVO getPregunta() {
		return pregunta;
	}

	public void setPregunta(PreguntaVO pregunta) {
		this.pregunta = pregunta;
	}
>>>>>>> master
}
