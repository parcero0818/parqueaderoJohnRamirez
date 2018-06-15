package co.ceiba.parqueadero.parqueaderoJohnRamirez.service;

import co.ceiba.parqueadero.parqueaderoJohnRamirez.repositorio.TiqueteParqueoRepositorio;

public interface IParqueaderoService {

	public boolean verificarDisponibilidadCarro(TiqueteParqueoRepositorio tiqueteParqueoRepositorio);

	public boolean verificarDisponibilidadMoto(TiqueteParqueoRepositorio tiqueteParqueoRepositorio);

	public String obtenerValorPropiedad(String nombrePropiedad);

	public int cantidadMotosParqueados(TiqueteParqueoRepositorio tiqueteParqueoRepositorio);

	public int cantidadCarrosParqueados(TiqueteParqueoRepositorio tiqueteParqueoRepositorio);
}
