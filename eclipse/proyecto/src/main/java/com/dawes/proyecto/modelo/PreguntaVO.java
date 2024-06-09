package com.dawes.proyecto.modelo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

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

/**
 * Clase que representa una pregunta en un ejercicio.
 * 
 * <p>
 * Esta clase contiene la información de una pregunta, incluyendo su enunciado,
 * el ejercicio al que pertenece y las opciones asociadas.
 * </p>
 */
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "preguntas")
public class PreguntaVO {

	/**
	 * Identificador único de la pregunta.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idpregunta;

	/**
	 * Ejercicio al que pertenece la pregunta.
	 */
	@ManyToOne
	@JoinColumn(name = "idejercicio")
	@JsonIgnore
	@NonNull
	private EjercicioVO ejercicio;

	/**
	 * Enunciado de la pregunta.
	 */
	@NonNull
	private String enunciado;

	/**
	 * Lista de opciones asociadas a la pregunta.
	 */
	@OneToMany(mappedBy = "pregunta")
	@NonNull
	private List<OpcionVO> opciones;

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
}
