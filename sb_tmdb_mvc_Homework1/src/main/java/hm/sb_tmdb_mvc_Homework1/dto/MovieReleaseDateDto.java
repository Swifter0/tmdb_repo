package hm.sb_tmdb_mvc_Homework1.dto;

import java.util.List;

public class MovieReleaseDateDto {

	private int id;
	private List<CountryDto> countries;
	
	
	public MovieReleaseDateDto(int id, List<CountryDto> countries) {
		super();
		this.id = id;
		this.countries = countries;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public List<CountryDto> getCountries() {
		return countries;
	}


	public void setCountries(List<CountryDto> countries) {
		this.countries = countries;
	}
	
}
