package com.proyecto.entidad;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "tb_libro_autor")
@AllArgsConstructor
@NoArgsConstructor
public class LibroAutor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	

	@ManyToOne
	@JoinColumn(name = "id", nullable = false, insertable = false, updatable = false)
	private Autor idAutorFK;
	
	@ManyToOne
	@JoinColumn(name = "id", nullable = false, insertable = false, updatable = false)
	private Libro idLibroFK;
	

	
	public LibroAutor(int id) {
		this.id = id;
	}
}
