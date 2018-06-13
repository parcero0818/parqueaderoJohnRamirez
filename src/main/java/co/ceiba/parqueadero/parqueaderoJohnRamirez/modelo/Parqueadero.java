package co.ceiba.parqueadero.parqueaderoJohnRamirez.modelo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Parqueadero {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idParqueadero;
	private String placaVehiculo;
	private Date fechaEntrada;
	private Date fechaSalida;

	public int getIdParqueadero() {
		return idParqueadero;
	}

	public void setIdParqueadero(int idParqueadero) {
		this.idParqueadero = idParqueadero;
	}

	public String getPlacaVehiculo() {
		return placaVehiculo;
	}

	public void setPlacaVehiculo(String placaVehiculo) {
		this.placaVehiculo = placaVehiculo;
	}

	public Date getFechaEntrada() {
		return fechaEntrada;
	}

	public void setFechaEntrada(Date fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

	public Date getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

}
