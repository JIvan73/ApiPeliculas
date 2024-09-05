package com.mx.ApiCrudPeliculas.service;

import java.util.List;

import com.mx.ApiCrudPeliculas.entity.Peliculas;

public interface PeliculasServ {
	
	public List<Peliculas> listar();
	
	public String guardar (Peliculas pelicula);
	
	public Peliculas buscar (Long id);  ////////////SE VALIDA QUE EL ID EXISTE PARA BUSCAR
	
	public boolean editar (Peliculas pelicula);
	
	public boolean eliminar (Long id);   ////////////SE VALIDA QUE EL ID EXISTE PARA ELIMINAR
	
	public String buscarporNombre(Peliculas pelicula);
	
	public String buscarporGenero(Peliculas pelicula);
	
	public String EliminarporNombre(Peliculas pelicula);

}
