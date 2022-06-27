package com.proyecto.model;

import com.proyecto.entidad.RatingLibro;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RatingModel {

	int Puntuacion;
	String fechaComentario;
	String Comentario;

}
