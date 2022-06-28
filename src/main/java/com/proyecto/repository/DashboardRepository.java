package com.proyecto.repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.proyecto.entidad.DashboardCategorias;

public class DashboardRepository {

	public DashboardCategorias GetUSP_GetCategoriasLibrosDASH() {

		DashboardCategorias obj = new DashboardCategorias();

		try {

			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/bd_bibliotech_1?serverTimezone=America/Lima", "root", "1234");

			String query = "{CALL USP_GetCategoriasLibrosDASH()}";
			CallableStatement stmt = conn.prepareCall(query);

			ResultSet rs = stmt.executeQuery();

			ResultSetMetaData rsmd = rs.getMetaData();

			while (rs.next()) {

				obj.lstY.add(rs.getString(1));
				obj.lstX.add(rs.getInt(2));
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return obj;

	}

	public DashboardCategorias GetUSP_GetInteraccionesCategoriasDASH() {

		DashboardCategorias obj = new DashboardCategorias();

		try {

			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/bd_bibliotech_1?serverTimezone=America/Lima", "root", "1234");

			String query = "{CALL USP_GetInteraccionesCategoriasDASH()}";
			CallableStatement stmt = conn.prepareCall(query);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				obj.lstY.add(rs.getString(1));
				obj.lstX.add(rs.getInt(2));
			}
		} catch (

		Exception e) {
			System.out.println(e);
		}

		return obj;

	}

	public DashboardCategorias GetUSP_GetLibrosRankDASH() {
		DashboardCategorias obj = new DashboardCategorias();

		try {

			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/bd_bibliotech_1?serverTimezone=America/Lima", "root", "1234");

			String query = "{CALL USP_GetLibrosRankDASH()}";
			CallableStatement stmt = conn.prepareCall(query);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				obj.lstY.add(rs.getString(1));
				obj.lstX.add(rs.getInt(2));
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return obj;

	}

}
