package co.ceiba.parqueadero.parqueaderojohnramirez.enums;

public enum TipoVehiculoEnum {

	VehiculoCarro("Carro"), VehiculoMoto("Moto");

	private String tipoVehiculo;

	private TipoVehiculoEnum(String tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}

	public String getTipoVehiculo() {
		return tipoVehiculo;
	}

}
