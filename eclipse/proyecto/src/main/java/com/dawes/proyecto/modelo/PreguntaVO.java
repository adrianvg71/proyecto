package com.dawes.proyecto.modelo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
<<<<<<< HEAD
=======
import com.fasterxml.jackson.annotation.JsonProperty;
>>>>>>> master

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

<<<<<<< HEAD
=======
/**
 * Clase que representa una pregunta en un ejercicio.
 * 
 * <p>
 * Esta clase contiene la información de una pregunta, incluyendo su enunciado,
 * el ejercicio al que pertenece y las opciones asociadas.
 * </p>
 */
>>>>>>> master
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "preguntas")
public class PreguntaVO {

<<<<<<< HEAD
=======
	/**
	 * Identificador único de la pregunta.
	 */
>>>>>>> master
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idpregunta;

<<<<<<< HEAD
=======
	/**
	 * Ejercicio al que pertenece la pregunta.
	 */
>>>>>>> master
	@ManyToOne
	@JoinColumn(name = "idejercicio")
	@JsonIgnore
	@NonNull
	private EjercicioVO ejercicio;

<<<<<<< HEAD
	@NonNull
	private String enunciado;

=======
	/**
	 * Enunciado de la pregunta.
	 */
	@NonNull
	private String enunciado;

	/**
	 * Lista de opciones asociadas a la pregunta.
	 */
>>>>>>> master
	@OneToMany(mappedBy = "pregunta")
	@NonNull
	private List<OpcionVO> opciones;

<<<<<<< HEAD
=======
	/**
	 * Obtiene el identificador del ejercicio al que pertenece la pregunta.
	 * 
	 * @return el identificador del ejercicio, o null si no hay ejercicio asociado.
	 */
	@JsonProperty("idejercicio")
	public Integer getEjercicioId() {
		return ejercicio != null ? ejercicio.getIdejercicio() : null;
	}

	public int getIdpregunta() {
		return idpregunta;
	}

	public void setIdpregunta(int idpregunta) {
		this.idpregunta = idpregunta;
	}

	public EjercicioVO getEjercicio() {
		return ejercicio;
	}

	public void setEjercicio(EjercicioVO ejercicio) {
		this.ejercicio = ejercicio;
	}

	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	public List<OpcionVO> getOpciones() {
		return opciones;
	}

	public void setOpciones(List<OpcionVO> opciones) {
		this.opciones = opciones;
	}
>>>>>>> master
}
