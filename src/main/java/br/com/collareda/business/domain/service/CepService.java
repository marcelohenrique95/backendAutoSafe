package br.com.collareda.business.domain.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.collareda.business.domain.dto.CepResponseDTO;
import br.com.collareda.business.domain.util.JsonUtil;

@Service
public class CepService {
	
	  static String webService = "http://viacep.com.br/ws/";
	    static int codigoSucesso = 200;

	    public CepResponseDTO buscaEnderecoPelo(String cep) throws Exception {
	        String urlParaChamada = webService + cep + "/json";

	        try {
	            URL url = new URL(urlParaChamada);
	            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();

	            if (conexao.getResponseCode() != codigoSucesso)
	                throw new RuntimeException("HTTP error code : " + conexao.getResponseCode());

	            BufferedReader resposta = new BufferedReader(new InputStreamReader((conexao.getInputStream())));
	            String jsonEmString = JsonUtil.converteJsonEmString(resposta);

	            ObjectMapper mapper = new ObjectMapper();
	            CepResponseDTO endereco =  mapper.readValue(jsonEmString, CepResponseDTO.class);

	            return endereco;
	        } catch (Exception e) {
	            throw new Exception("ERRO: " + e);
	        }
	    }
	}

