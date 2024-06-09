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

<<<<<<< HEAD
@AllArgsConstructor
@Data
@Entity

=======
/**
 * Clase que representa la relación entre un usuario y un ejercicio.
 * 
 * <p>
 * Esta clase contiene la información sobre la relación entre un usuario y un
 * ejercicio, incluyendo el número de aciertos y la fecha de realización.
 * </p>
 */
@AllArgsConstructor
@Data
@Entity
>>>>>>> master
@Table(name = "usuarioejercicio", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "idusuario", "idejercicio" }) })
public class UsuarioEjercicioVO {

<<<<<<< HEAD
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idusuarioejercicio;
	@JsonIgnoreProperties("usuarioEjercicios")
=======
	/**
	 * Identificador único de la relación usuario-ejercicio.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idusuarioejercicio;

	/**
	 * Usuario asociado a la relación.
	 */
>>>>>>> master
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idusuario")
	@NonNull
	private UsuarioVO usuario;
<<<<<<< HEAD
=======

	/**
	 * Ejercicio asociado a la relación.
	 */
>>>>>>> master
	@JsonIgnoreProperties("usuarioEjercicios")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idejercicio")
	@NonNull
	private EjercicioVO ejercicio;
<<<<<<< HEAD
	@NonNull
	private Integer aciertos;

	private LocalDateTime fecharealizacion;

=======

	/**
	 * Número de aciertos del usuario en el ejercicio.
	 */
	@NonNull
	private Integer aciertos;

	/**
	 * Fecha y hora en que se realizó el ejercicio.
	 */
	private LocalDateTime fecharealizacion;

	/**
	 * Constructor por defecto que inicializa la fecha de realización a la fecha y
	 * hora actual.
	 */
>>>>>>> master
	public UsuarioEjercicioVO() {
		this.fecharealizacion = LocalDateTime.now();
	}

<<<<<<< HEAD
=======
	/**
	 * Constructor con parámetros usuario, ejercicio y aciertos.
	 * 
	 * @param usuario   el usuario asociado.
	 * @param ejercicio el ejercicio asociado.
	 * @param aciertos  el número de aciertos.
	 */
>>>>>>> master
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

<<<<<<< HEAD
=======
	public int getIdusuarioejercicio() {
		return idusuarioejercicio;
	}

	public void setIdusuarioejercicio(int idusuarioejercicio) {
		this.idusuarioejercicio = idusuarioejercicio;
	}

	public UsuarioVO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioVO usuario) {
		this.usuario = usuario;
	}

	public EjercicioVO getEjercicio() {
		return ejercicio;
	}

	public void setEjercicio(EjercicioVO ejercicio) {
		this.ejercicio = ejercicio;
	}

	public Integer getAciertos() {
		return aciertos;
	}

	public void setAciertos(Integer aciertos) {
		this.aciertos = aciertos;
	}

	public LocalDateTime getFecharealizacion() {
		return fecharealizacion;
	}

	public void setFecharealizacion(LocalDateTime fecharealizacion) {
		this.fecharealizacion = fecharealizacion;
	}
>>>>>>> master
}
