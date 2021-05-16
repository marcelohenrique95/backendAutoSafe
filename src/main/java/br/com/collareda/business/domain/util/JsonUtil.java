package br.com.collareda.business.domain.util;

import java.io.BufferedReader;
import java.io.IOException;

public class JsonUtil {
	
	 public static String converteJsonEmString(BufferedReader buffereReader) throws IOException {
	        String resposta, jsonEmString = "";
	        while ((resposta = buffereReader.readLine()) != null) {
	            jsonEmString += resposta;
	        }
	        return jsonEmString;
	    }
	}


