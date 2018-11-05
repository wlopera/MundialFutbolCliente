package com.wlopera.cliente.cmf.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.wlopera.api.ChampionDTO;
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
	 * 
	 * @return
	 */
	// http://localhost:8585/
	@RequestMapping("/")
	public String home() {
		return "index";
	}

	/**
	 * Servicio Rest Data listado de annios jugados y cantidad de torneos ganados
	 * 
	 * @return Listado de datos
	 */
	// http://localhost:8585/champion/allChampions
	@RequestMapping(value = "/champion/data")
	@ResponseBody
	public DataWrapper getData() {

		System.out.println("Inicio consulta servicio rest getData");
		DataWrapper wrapper = new DataWrapper();

		wrapper.setYears(ChampionUtil.getYears());
		wrapper.setQtys(ChampionUtil.getChampionsWinQty());
		
		return wrapper;

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
		ChampionWrapper wrapper = new ChampionWrapper();

		wrapper.setChampions(swcsApi.getListChampionsWin());
		return wrapper;

	}

	/**
	 * Servicio Rest campeon por annio
	 * 
	 * @return Campeon para un annio requerido
	 */
	// http://localhost:8585/champion/championByYear/1986
	@GetMapping(value = "/champion/championByYear/{year}")
	@ResponseBody
	public ChampionWrapper getChampionByYear(@PathVariable("year") String year) {

		System.out.println("Inicio consulta servicio rest getChampionByYear para el año: " + year);
		ChampionWrapper wrapper = new ChampionWrapper();

		List<ChampionDTO> champions = new ArrayList<>();
		champions.add(swcsApi.getChampionByYear(year));

		wrapper.setChampions(champions);
		
		System.out.println("getChampionByYear: " + wrapper.getChampions().toString());
		return wrapper;

	}

	/**
	 * Servicio Rest listado de todos los campeones ganadores para una catidad
	 * exacta de campeonatos
	 * 
	 * @return Listado de campeonatos
	 */
	// http://localhost:8585/champion/championsByWins/2
	@GetMapping(value = "/champion/championsByWins/{numberWins}")
	@ResponseBody
	public ChampionWrapper getChampionsByWins(@PathVariable("numberWins") String numberWins) {

		System.out.println("Inicio consulta servicio rest getChampionsByWins para partidos ganados: " + numberWins);
		ChampionWrapper wrapper = new ChampionWrapper();

		wrapper.setChampions(swcsApi.getListChampionsWinByQty(numberWins));
		
		System.out.println("getChampionsByWins: " + wrapper.getChampions().toString());
		return wrapper;

	}
}
