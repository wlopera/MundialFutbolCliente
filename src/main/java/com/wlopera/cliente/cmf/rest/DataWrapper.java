package com.wlopera.cliente.cmf.rest;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("ClientWrapper")
public class DataWrapper implements Serializable {

	private static final long serialVersionUID = 7831642959650748773L;

	private List<String> qtys;
	private List<String> years;
	
	public List<String> getQtys() {
		return qtys;
	}

	public void setQtys(List<String> qtys) {
		this.qtys = qtys;
	}

	public List<String> getYears() {
		return years;
	}

	public void setYears(List<String> years) {
		this.years = years;
	}

	@Override
	public String toString() {
		return "DataWrapper [qtys=" + qtys + ", years=" + years + "]";
	}
	
}