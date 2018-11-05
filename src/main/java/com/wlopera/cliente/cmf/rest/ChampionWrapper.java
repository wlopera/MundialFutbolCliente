package com.wlopera.cliente.cmf.rest;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.wlopera.api.ChampionDTO;

@JsonRootName("ClientWrapper")
public class ChampionWrapper implements Serializable {

	private static final long serialVersionUID = -6453185814072830906L;

	private List<ChampionDTO> champions;
	
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