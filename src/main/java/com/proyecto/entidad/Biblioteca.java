package com.proyecto.entidad;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_biblioteca")
@AllArgsConstructor
@NoArgsConstructor
public class Biblioteca {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idInstitucionFK", nullable = false, insertable = false, updatable = false)
	private Instituciones idInstitucionFK;
	
	@Column(name="idInstitucionFK")
	private int idInstitucion;
	
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idLibroFK", nullable = false, insertable = false, updatable = false)
	private Libro idLibroFK;
	
	@Column(name="idLibroFK")
	private int idLibro;
	
	
	private int stockDisponible;
	private boolean estado;
}
