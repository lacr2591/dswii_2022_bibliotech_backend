package com.proyecto.entidad;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class DashboardCategorias {

	public List<String> lstY;

	public List<Integer> lstX;

	public DashboardCategorias() {
		lstY = new ArrayList<String>();
		lstX = new ArrayList<Integer>();

	}

}
