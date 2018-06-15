package co.ceiba.parqueadero.parqueaderoJohnRamirez.test;

import co.ceiba.parqueadero.parqueaderoJohnRamirez.modelo.Vehiculo;

public class VehiculoPlacaIniciaPorA {

	private String placa;
	private int cilindraje;
	private String tipoVehiculo;

	public VehiculoPlacaIniciaPorA() {
		this.placa = "FZV-283";
		this.cilindraje = 220;
		this.tipoVehiculo = "Carro";
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public int getCilindraje() {
		return cilindraje;
	}

	public void setCilindraje(int cilindraje) {
		this.cilindraje = cilindraje;
	}

	public String getTipoVehiculo() {
		return tipoVehiculo;
	}

	public void setTipoVehiculo(String tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}

	public Vehiculo build() {
		return new Vehiculo(placa, cilindraje, tipoVehiculo);
	}

}
