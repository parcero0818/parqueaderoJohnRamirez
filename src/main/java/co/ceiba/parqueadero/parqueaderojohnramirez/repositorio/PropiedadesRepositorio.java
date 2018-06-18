package co.ceiba.parqueadero.parqueaderojohnramirez.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.ceiba.parqueadero.parqueaderojohnramirez.modelo.Propiedades;

public interface PropiedadesRepositorio extends JpaRepository<Propiedades, Long>{

	@Query("select p.valorPropiedad from propiedades p where p.nombrePropiedad=?1")
	String obtenerValorPropiedad(String nombrePropiedad);
	
}
