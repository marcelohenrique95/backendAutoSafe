package br.com.collareda.business.domain.util;

import java.util.UUID;

public class GenerateGUIDFile {

	public static String generateImageId(Long partnerId) {
		UUID uuid = UUID.randomUUID();
		return partnerId + "+" + uuid.toString().replace("-", "");
	}

}
