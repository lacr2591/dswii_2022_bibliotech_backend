package com.proyecto.entidad;

import java.math.BigDecimal;
import java.text.DecimalFormat;

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
@Table(name = "tb_libros")
@AllArgsConstructor
@NoArgsConstructor
public class Libro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	private String title_long;
	private String isbn;
	private String isbn13;
	private String dewey_decimal;
	private String binding;
	private String publisher;
	private String language;
	private String date_published;
	private String edition;
	private int pages;
	private String dimensions;
	private String overview;
	private String coverLink;
	private String excerpt;
	private String synopsys;
	private boolean estado;

}
