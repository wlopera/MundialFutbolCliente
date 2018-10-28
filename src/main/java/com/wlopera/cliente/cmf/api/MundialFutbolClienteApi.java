package com.wlopera.cliente.cmf.api;

import java.util.List;

import com.wlopera.cliente.cmf.soap.Campeonato;

public interface MundialFutbolClienteApi {

	/**
	 * Consultar la lista de paises ganadores de una cantidad especifica de
	 * mundiales de futbol
	 * 
	 * @param numeroCMFGanados Cantidad de campeonatos ganados
	 * 
	 * @return Listado de paises que solo han ganado esa cantidad exacta de
	 *         campeonatos
	 */
	List<Campeonato> getListaCMFPorCampeonatoGanado(String numeroCMFGanados);

	/**
	 * Consulta todos los paises ganadores de campeones mundiales de futbol
	 * 
	 * @return Listado de paises gnadores de mundiales
	 */
	List<Campeonato> getListaCMFTodos();

	/**
	 * Consultar el pais ganador del mundial de un annio requerido
	 * 
	 * @param year Annio del mundial
	 * 
	 * @return Pais que gano el campeonato ese annio
	 */
	Campeonato getCMFPorAnnio(String annio);
}
