package com.dawes.proyecto.modelo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "preguntas")
public class PreguntaVO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idpregunta;

	@ManyToOne
	@JoinColumn(name = "idejercicio")
	@JsonIgnore
	@NonNull
	private EjercicioVO ejercicio;

	@NonNull
	private String enunciado;

	@OneToMany(mappedBy = "pregunta")
	@NonNull
	private List<OpcionVO> opciones;

}
