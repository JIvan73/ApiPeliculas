package com.mx.ApiCrudPeliculas.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="PELICULAS")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Peliculas {

	/*
ID NUMBER PRIMARY KEY,
NOMBRE VARCHAR2(80) NOT NULL,
GENERO VARCHAR2(50) NOT NULL,
FECHA_LANZ DATE,
PRECIO NUMBER
	 */
	
	
	/////MAPEO
	@Id
	@Column(name = "ID")
	private Long id;
	@Column(name = "NOMBRE")
	private String nombre;
	@Column(name = "GENERO")
	private String genero;
	@Column (name = "FECHA_LANZ")
	private Date fecha;
	@Column (name = "PRECIO")
	private Float precio;
	
	
	
	
	///////////////////////////////////////////////////////////////////////
}
