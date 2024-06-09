package com.dawes.proyecto.modelo;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@AllArgsConstructor
@Data
@Entity

@Table(name = "usuarioejercicio", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "idusuario", "idejercicio" }) })
public class UsuarioEjercicioVO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idusuarioejercicio;
	@JsonIgnoreProperties("usuarioEjercicios")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idusuario")
	@NonNull
	private UsuarioVO usuario;
	@JsonIgnoreProperties("usuarioEjercicios")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idejercicio")
	@NonNull
	private EjercicioVO ejercicio;
	@NonNull
	private Integer aciertos;

	private LocalDateTime fecharealizacion;

	public UsuarioEjercicioVO() {
		this.fecharealizacion = LocalDateTime.now();
	}

	public UsuarioEjercicioVO(@NonNull UsuarioVO usuario, @NonNull EjercicioVO ejercicio, @NonNull Integer aciertos) {
		super();
		this.usuario = usuario;
		this.ejercicio = ejercicio;
		this.aciertos = aciertos;
		this.fecharealizacion = LocalDateTime.now();
	}

	@Override
	public String toString() {
		return "usuarioejercicio";
	}

}
