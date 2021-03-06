package co.ceiba.parqueadero.parqueaderojohnramirez.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.ceiba.parqueadero.parqueaderojohnramirez.modelo.TiqueteParqueo;

public interface TiqueteParqueoRepositorio extends JpaRepository<TiqueteParqueo, Long> {

	@Query("select count(*) from tiqueteParqueo t where lower(t.tipoVehiculo)=lower('carro') and t.fechaSalida is null")
	Integer cantidadCarrosParqueados();

	@Query("select count(*) from tiqueteParqueo t where lower(t.tipoVehiculo)=lower('moto') and t.fechaSalida is null")
	Integer cantidadMotosParqueados();
}
