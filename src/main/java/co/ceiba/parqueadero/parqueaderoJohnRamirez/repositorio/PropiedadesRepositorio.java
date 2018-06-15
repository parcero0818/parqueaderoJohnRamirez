package co.ceiba.parqueadero.parqueaderoJohnRamirez.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.ceiba.parqueadero.parqueaderoJohnRamirez.modelo.Propiedades;

public interface PropiedadesRepositorio extends JpaRepository<Propiedades, Long>{

	@Query("select p.valorPropiedad from propiedades p where p.nombrePropiedad=?1")
	String obtenerValorPropiedad(String nombrePropiedad);
	
}
