package com.wlopera.api;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;

import com.wlopera.cliente.cmf.api.MundialFutbolClienteImpl;
import com.wlopera.cliente.cmf.soap.Campeonato;

public class SoccerWorldChampionshipImpl implements SoccerWorldChampionshipApi {

	private static MundialFutbolClienteImpl instance = null;

	// retorna la instancia singleton creada
	public static MundialFutbolClienteImpl getInstance() {

		if (null == instance) {

			instance = new MundialFutbolClienteImpl();
		}
		return instance;
	}

	@Override
	public List<ChampionDTO> getListChampionsWinByQty(String qty) {

		List<Campeonato> campeonatos = getInstance().getListaCMFPorCampeonatoGanado(qty);
		
		List<ChampionDTO> champions = new ArrayList<>();
		
		for (Campeonato campeonato : campeonatos) {
			champions.add(getChampionByDozer(campeonato));			
		}
		System.out.println(champions.toString());
		return champions;
	}

	@Override
	public List<ChampionDTO> getListChampionsWin() {

		List<Campeonato> campeonatos = getInstance().getListaCMFTodos();

		List<ChampionDTO> champions = new ArrayList<>();
		
		for (Campeonato campeonato : campeonatos) {
			champions.add(getChampionByDozer(campeonato));			
		}
		System.out.println(champions.toString());
		return champions;
	}

	@Override
	public ChampionDTO getChampionByYear(String year) {

		ChampionDTO champion = getChampionByDozer(getInstance().getCMFPorAnnio(year));
	
		System.out.println(champion.toString());
		
		return champion;
	}

	private ChampionDTO getChampionByDozer(Campeonato campeonato) {

		List<String> list = new ArrayList<>();

		list.add("champion-mapping.xml");

		DozerBeanMapper mapper = new DozerBeanMapper();

		mapper.setMappingFiles(list);

		ChampionDTO champion = new ChampionDTO();

		mapper.map(campeonato, champion, "champion");

		return champion;
	}
	
	public static void main(String[] args) {
		SoccerWorldChampionshipImpl cmf = new SoccerWorldChampionshipImpl();
		
		System.out.println("Campeon 1986: ");
		cmf.getChampionByYear("1986");
		
		System.out.println("Campeones ");
		cmf.getListChampionsWin();
		
		System.out.println("Campeones en 2 torneos ");
		cmf.getListChampionsWinByQty("2");
		
	}
	
}
