package com.wlopera.api;

import java.io.Serializable;

public class ChampionDTO implements Serializable {

	private static final long serialVersionUID = -2527025805502767454L;

	private int year;
	private String championName;
	private String headquarter;
	private String subChampionName;
	private String result;

	public ChampionDTO() {}
	
	public ChampionDTO(int year, String championName, String headquarter, String subChampionName, String result) {
		this.year = year;
		this.championName = championName;
		this.headquarter = headquarter;
		this.subChampionName = subChampionName;
		this.result = result;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getChampionName() {
		return championName;
	}

	public void setChampionName(String championName) {
		this.championName = championName;
	}

	public String getHeadquarter() {
		return headquarter;
	}

	public void setHeadquarter(String headquarter) {
		this.headquarter = headquarter;
	}

	public String getSubChampionName() {
		return subChampionName;
	}

	public void setSubChampionName(String subChampionName) {
		this.subChampionName = subChampionName;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "Champion [year=" + year + ", championName=" + championName + ", headquarter=" + headquarter
				+ ", subChampionName=" + subChampionName + ", result=" + result + "]";
	}

}
