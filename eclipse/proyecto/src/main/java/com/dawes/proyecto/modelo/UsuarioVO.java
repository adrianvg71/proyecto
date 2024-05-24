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

	@OneToMany(mappedBy = "usuario")
	@JsonBackReference
	private List<UsuarioEjercicioVO> ejercicios;

	public UsuarioVO(String correo, String nombre, String contraseña) {
		super();
		this.correo = correo;
		this.nombre = nombre;
		this.contraseña = contraseña;
		this.fechacreacion = LocalDate.now();
		this.ejercicios = new ArrayList<>();
	}

	public UsuarioVO() {
		this.fechacreacion = LocalDate.now();
		this.ejercicios = new ArrayList<>();
		this.tipo = "user";
	}

	@Override
	public String toString() {
		return "usuario";
	}

}
