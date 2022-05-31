package com.proyecto.entidad;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_autores")
@AllArgsConstructor
@NoArgsConstructor
public class Autores {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String descripcion;

	public Autores(int id) {
		this.id = id;
	}
}
