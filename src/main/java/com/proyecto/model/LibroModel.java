package com.proyecto.model;

import java.util.List;

import com.proyecto.entidad.RatingLibro;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LibroModel {

	int Id_Libro;
	String Title;
	String Title_Long;
	String Language;
	String Edition;
	int Pages;
	String CoverLink;
	String Synopsys;
	int StockDisponible;
	double Puntuacion;
	String Categorias;
	List<RatingModel> Ratings;

}
