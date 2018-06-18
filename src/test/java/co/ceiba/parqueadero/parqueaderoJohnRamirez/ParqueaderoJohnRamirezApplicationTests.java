package co.ceiba.parqueadero.parqueaderoJohnRamirez;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Calendar;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import co.ceiba.parqueadero.parqueaderoJohnRamirez.enums.Propiedades;
import co.ceiba.parqueadero.parqueaderoJohnRamirez.modelo.Vehiculo;
import co.ceiba.parqueadero.parqueaderoJohnRamirez.repositorio.PropiedadesRepositorio;
import co.ceiba.parqueadero.parqueaderoJohnRamirez.repositorio.TiqueteParqueoRepositorio;
import co.ceiba.parqueadero.parqueaderoJohnRamirez.service.IParqueaderoService;
import co.ceiba.parqueadero.parqueaderoJohnRamirez.service.IVigilanteService;
import co.ceiba.parqueadero.parqueaderoJohnRamirez.test.VehiculoPlacaIniciaPorA;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ParqueaderoJohnRamirezApplicationTests {
	@Autowired
	IVigilanteService vigilanteService;
	@Autowired
	IParqueaderoService parqueaderoService;
	
	@Autowired
	PropiedadesRepositorio propiedadesRepositorio;

	@Before
	public void setup() {
	}

	@Test
	public void contextLoads() {
	}

	@Test
	public void parqueaderoDisponibleCarros() {
		// Arrange
		TiqueteParqueoRepositorio tiqueteParqueoRepositorio = mock(TiqueteParqueoRepositorio.class);
		when(tiqueteParqueoRepositorio.cantidadCarrosParqueados()).thenReturn(19);
		// Act
		boolean disponible = parqueaderoService.verificarDisponibilidadCarro(tiqueteParqueoRepositorio);
		// Assert
		Assert.assertTrue(disponible);
	}

	@Test
	public void parqueaderoNoDisponibleCarros() {
		// Arrange
		TiqueteParqueoRepositorio tiqueteParqueoRepositorio = mock(TiqueteParqueoRepositorio.class);
		when(tiqueteParqueoRepositorio.cantidadCarrosParqueados()).thenReturn(20);
		// Act
		boolean disponible = parqueaderoService.verificarDisponibilidadCarro(tiqueteParqueoRepositorio);
		// Assert
		Assert.assertFalse(disponible);
	}

	@Test
	public void parqueaderoDisponibleMotos() {
		// Arrange
		TiqueteParqueoRepositorio tiqueteParqueoRepositorio = mock(TiqueteParqueoRepositorio.class);
		when(tiqueteParqueoRepositorio.cantidadMotosParqueados()).thenReturn(9);
		// Act
		boolean disponible = parqueaderoService.verificarDisponibilidadMoto(tiqueteParqueoRepositorio);
		// Assert
		Assert.assertTrue(disponible);
	}

	@Test
	public void parqueaderoNoDisponibleMotos() {
		// Arrange
		TiqueteParqueoRepositorio tiqueteParqueoRepositorio = mock(TiqueteParqueoRepositorio.class);
		when(tiqueteParqueoRepositorio.cantidadMotosParqueados()).thenReturn(10);
		// Act
		boolean disponible = parqueaderoService.verificarDisponibilidadMoto(tiqueteParqueoRepositorio);
		// Assert
		Assert.assertFalse(disponible);
	}
	
	@Test
	public void placaPermitida() {
		//Arrange
		Vehiculo vehiculo = new VehiculoPlacaIniciaPorA().build();
		//Act
		boolean validarPlaca = vigilanteService.verificarPlaca(vehiculo.getPlaca());
		//Assert
		Assert.assertTrue(validarPlaca);
	}
	
	@Test
	public void verificarDomingo() {
		//Arrange
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		//Act
		boolean isDomingo = vigilanteService.verificarDiaSemana(calendar);
		//Assert
		Assert.assertTrue(isDomingo);
	}
	
	@Test
	public void verificarLunes() {
		//Arrange
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		//Act
		boolean isLunes = vigilanteService.verificarDiaSemana(calendar);
		//Assert
		Assert.assertTrue(isLunes);
	}
	
	@Test
	public void verificarNoLunesNiDomingo() {
		//Arrange
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
		//Act
		boolean noEsLunesNiDomingo = vigilanteService.verificarDiaSemana(calendar);
		//Assert
		Assert.assertFalse(noEsLunesNiDomingo);
	}
	
	@Test
	public void registrarIngreso() {
		//Arrange
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		Vehiculo vehiculo = new VehiculoPlacaIniciaPorA().build();
		//Act
		boolean isRegistro = vigilanteService.registrarIngreso(vehiculo, calendar);
		//Assert
		Assert.assertTrue(isRegistro);
	}
	
	@Test
	public void obtenerPropiedad() {
		//Arrange
		String nombrePropiedad = Propiedades.cantCarrosPermitidos.getNombrePropiedad();
		//Act
		String carros = parqueaderoService.obtenerValorPropiedad(nombrePropiedad);
		//
		Assert.assertEquals("20", carros);
	}
	
	@Test
	public void getPropiedades() {
		List<co.ceiba.parqueadero.parqueaderoJohnRamirez.modelo.Propiedades> list = propiedadesRepositorio.findAll();
		co.ceiba.parqueadero.parqueaderoJohnRamirez.modelo.Propiedades prop = list.get(0);
	}

}
