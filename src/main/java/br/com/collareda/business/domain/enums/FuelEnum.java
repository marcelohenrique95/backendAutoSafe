package br.com.collareda.business.domain.enums;

public enum FuelEnum {
	FLEX(1), GASOLINA(2), DIESEL(4), ALCOOL(5);

	private int fuelId;

	FuelEnum(int fuelId) {
		this.fuelId = fuelId;
	}

	public static FuelEnum fromInt(int id) {
		for (FuelEnum e : FuelEnum.values()) {
			if (e.fuelId == id) {
				return e;
			}
		}
		return null;
	}

}
