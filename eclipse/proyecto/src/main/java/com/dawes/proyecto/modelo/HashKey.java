package com.dawes.proyecto.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity

@Table(name = "hashkey")
public class HashKey {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idkey;

	@Column(unique = true)
	private String key;
}
