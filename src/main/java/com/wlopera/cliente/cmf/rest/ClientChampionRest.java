package com.wlopera.cliente.cmf.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

import com.wlopera.api.SoccerWorldChampionshipApi;
import com.wlopera.api.SoccerWorldChampionshipImpl;

@SpringBootApplication // Indica que se trata de una aplicación Spring Boot
@ComponentScan(useDefaultFilters = false) // La configuración predeterminada de escáner de componentes heredada de
											// Spring Boot busca clases @Component y,
											// en este caso, intenta crearlo. Sin embargo, quiero crearlo yo mismo,
											// así que deshabilito el escáner
public class ClientChampionRest {

	public static void main(String[] args) {
		SpringApplication.run(ClientChampionRest.class, args);
	}

	@LoadBalanced // Asegúrese de inyectar la plantilla de carga correcta
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	public SoccerWorldChampionshipApi getSoccerWorldChampionshipApi() {
		return new SoccerWorldChampionshipImpl();
	}

	@Bean
	public ChampionController getChampionController() {
		return new ChampionController(getSoccerWorldChampionshipApi());
	}
}
