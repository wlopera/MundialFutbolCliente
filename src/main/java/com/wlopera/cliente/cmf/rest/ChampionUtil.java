package com.wlopera.cliente.cmf.rest;

import java.util.ArrayList;
import java.util.List;

public class ChampionUtil {

	/**
	 * Annios de los torneos
	 * 
	 * @author Willian Lopera
	 * 
	 * @return Lista de annios de los torneos
	 */
	public static final List<String> getYears() {
		List<String> years = new ArrayList<>();
		
		years.add("1930");
		years.add("1934");
		years.add("1938");
		years.add("1950");
		years.add("1954");
		years.add("1958");
		years.add("1962");
		years.add("1966");
		years.add("1970");
		years.add("1974");
		years.add("1978");
		years.add("1982");
		years.add("1986");
		years.add("1990");
		years.add("1994");
		years.add("1998");
		years.add("2002");
		years.add("2006");
		years.add("2010");
		years.add("2014");
		years.add("2018");
		
		return years;
	}

	/**
	 * Cantidad exacta de torneos ganados por un pais
	 * 
	 * @author Willian Lopera
	 * 
	 * @return Lista de cantidad exacta de torneos ganados
	 */
	public static final List<String> getChampionsWinQty() {
		List<String> qty = new ArrayList<>();
		
		qty.add("1");
		qty.add("2");
		qty.add("3");
		qty.add("4");
		qty.add("5");
		
		return qty;
	}
}
