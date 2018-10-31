package com.wlopera.api;

import java.util.List;

public interface SoccerWorldChampionshipApi {

	/**
	 * Consultar la lista de paises ganadores de una cantidad especifica de
	 * mundiales de futbol
	 * 
	 * @param numeroCMFGanados Cantidad de campeonatos ganados
	 * 
	 * @return Listado de paises que solo han ganado esa cantidad exacta de
	 *         campeonatos
	 */
	List<ChampionDTO> getListChampionsWinByQty(String qty);

	/**
	 * Consulta todos los paises ganadores de campeones mundiales de futbol
	 * 
	 * @return Listado de paises gnadores de mundiales
	 */
	List<ChampionDTO> getListChampionsWin();

	/**
	 * Consultar el pais ganador del mundial de un annio requerido
	 * 
	 * @param year Annio del mundial
	 * 
	 * @return Pais que gano el campeonato ese annio
	 */
	ChampionDTO getChampionByYear(String year);
}
