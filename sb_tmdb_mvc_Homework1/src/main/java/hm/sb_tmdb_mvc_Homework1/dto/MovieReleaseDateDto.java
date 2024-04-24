package hm.sb_tmdb_mvc_Homework1.dto;

import java.util.List;

public class MovieReleaseDateDto {

	private int id;
	private List<ReleaseDatesDto> results;
	
	
	
	public MovieReleaseDateDto(int id, List<ReleaseDatesDto> results) {
		super();
		this.id = id;
		this.results = results;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public List<ReleaseDatesDto> getResults() {
		return results;
	}
	
	public void setResults(List<ReleaseDatesDto> results) {
		this.results = results;
	}
	
}
