package com.wlopera.cliente.cmf.rest;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.wlopera.api.ChampionDTO;

@JsonRootName("ClientWrapper")
public class ChampionWrapper {

	private List<ChampionDTO> champions;

	public ChampionWrapper() {
	}

	public ChampionWrapper(List<ChampionDTO> champions) {
		this.champions = champions;
	}

	public List<ChampionDTO> getChampions() {
		return champions;
	}

	public void setChampions(List<ChampionDTO> champions) {
		this.champions = champions;
	}

	@Override
	public String toString() {
		return "ChampionWrapper [champions=" + champions + "]";
	}
	
}