package hm.sb_tmdb_mvc_Homework1.model;

import java.util.List;

public class MovieReleaseDatesResult {

	private int id;
	private List<MovieCountry> results;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public List<MovieCountry> getResults() {
		return results;
	}
	
	public void setResults(List<MovieCountry> results) {
		this.results = results;
	}
	
}
