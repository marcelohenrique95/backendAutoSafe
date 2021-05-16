package br.com.collareda.business.domain.enums;

public enum ServiceStatusEnum {
	AGURDANDO_DADOS(1), ATIVO(2), PAUSADO(3), EXCLUIDO(4);

	private int statusId;

	ServiceStatusEnum(int statusId) {
		this.statusId = statusId;
	}

	public static ServiceStatusEnum fromInt(int id) {
		for (ServiceStatusEnum e : ServiceStatusEnum.values()) {
			if (e.statusId == id) {
				return e;
			}
		}
		return null;
	}

}
