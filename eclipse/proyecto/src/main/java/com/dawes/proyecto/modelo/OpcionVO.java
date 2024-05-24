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

@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Data
@Entity

@Table(name = "opciones")
public class OpcionVO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idopcion;
	@NonNull
	private String descripcion;
	@NonNull
	private Boolean correcta;
	@ManyToOne
	@JoinColumn(name = "idpregunta")
	@JsonIgnore
	@NonNull
	private PreguntaVO pregunta;
}
