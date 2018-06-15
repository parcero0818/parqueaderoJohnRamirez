package co.ceiba.parqueadero.parqueaderoJohnRamirez.enums;

public enum TipoVehiculoEnum {

	Carro("Carro"), Moto("Moto");

	private String tipoVehiculo;

	private TipoVehiculoEnum(String tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}

	public String getTipoVehiculo() {
		return tipoVehiculo;
	}

	public void setTipoVehiculo(String tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}

}
