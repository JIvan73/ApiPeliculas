package com.mx.ApiCrudPeliculas.repository;

import org.springframework.data.repository.CrudRepository;

import com.mx.ApiCrudPeliculas.entity.Peliculas;

public interface PeliculasDao extends CrudRepository<Peliculas, Long>{
	

}
