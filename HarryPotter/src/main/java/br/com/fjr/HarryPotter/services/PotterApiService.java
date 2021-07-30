package br.com.fjr.HarryPotter.services;

import java.util.List;

import javax.net.ssl.SSLContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import org.apache.http.conn.ssl.TrustStrategy;

import org.apache.http.conn.ssl.SSLConnectionSocketFactory;

import br.com.fjr.HarryPotter.character.controller.dto.HouseInputDto;
import br.com.fjr.HarryPotter.character.controller.dto.ResponseApiInputDto;
import br.com.fjr.HarryPotter.exeptionConf.BadRequesException;


import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PotterApiService {
	
	private String URL_BASE= "http://us-central1-rh-challenges.cloudfunctions.net/potterApi/houses";
	private String apiKey = "54946db0-c9de-4bbd-8358-e62167e004bf";
	@Autowired
	private RestTemplate restTemplate;

    public HouseInputDto findHouseById(String houseId) {
    	HttpEntity<Object> request = new HttpEntity<>("{}", getHeaders());
        ResponseEntity<ResponseApiInputDto> exchange;
        try {
            exchange = restTemplate.exchange(URL_BASE,
                    HttpMethod.GET,
                    request,ResponseApiInputDto.class);
            
        } catch (Exception ex) {
        	ex.printStackTrace();
        	throw new BadRequesException("House not found");
        }

        if (exchange.getBody()==null) {
            return null;
        }
        
        List<HouseInputDto> houses = exchange.getBody().getHouses();
        
        for(int i=0; i<houses.size();i++) {
        	if(houses.get(i).getId().equals(houseId)) {
        		return houses.get(i);
        	}
        }

        return null;
    }
	
	 private HttpHeaders getHeaders() {
   	  HttpHeaders headers = new HttpHeaders();
   	  headers.add("apikey", apiKey);
   	  return headers;
   }
	 
	 @Bean
	 public RestTemplate restTemplate() {
	     return new RestTemplate();
	 }

}
