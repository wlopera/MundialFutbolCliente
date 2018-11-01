package com.wlopera.cliente.cmf.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.wlopera.api.SoccerWorldChampionshipApi;

@Controller
public class ChampionController {

	protected SoccerWorldChampionshipApi swcsApi;

	@Autowired
	protected RestTemplate restTemplate;

	public ChampionController(SoccerWorldChampionshipApi swcsApi) {
		this.swcsApi = swcsApi;
	}

	/**
	  * Go to home.
	  * 
	  * Probar servicio rest activo => netstat -ano | find "8585"
	  * @return
	  */
	// http://localhost:8585/
	@RequestMapping("/")
	public String home() {
		System.out.println("Levantar Controlador y Servicios");
		return "index";
	}

	/**
	  * Go to champion.
	  * 
	  * @return
	  */
	@RequestMapping("/champion")
	public String goHome() {
		return "champion";
	}

	/**
	  * Servicio Rest listado de todos los campeonatos
	  * 
	  * @return Listado de campeonatos
	  */
	// http://localhost:8585/champion/allChampions
	@RequestMapping(value = "/champion/allChampions")
	@ResponseBody
	public ChampionWrapper getAllChampions() {

		System.out.println("Inicio consulta servicio rest ChampionWrapper");
		ChampionWrapper clientWrapper = new ChampionWrapper();

		clientWrapper.setChampions(swcsApi.getListChampionsWin());
		System.out.println("Campeones: " + clientWrapper.getChampions().toString());
		return clientWrapper;
	
	}

}
