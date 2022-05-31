package com.proyecto.entidad;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_configuraciones")
public class Configuraciones {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private int cantDiasPrestamo;

}