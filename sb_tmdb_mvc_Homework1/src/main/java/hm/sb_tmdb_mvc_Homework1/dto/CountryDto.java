package hm.sb_tmdb_mvc_Homework1.dto;

import java.util.List;

public class CountryDto {

	private String countryCode;
	private List<ReleaseDatesDto> releaseDates;
	
	
	public CountryDto(String countryCode, List<ReleaseDatesDto> releaseDates) {
		super();
		this.countryCode = countryCode;
		this.releaseDates = releaseDates;
	}


	public String getCountryCode() {
		return countryCode;
	}


	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}


	public List<ReleaseDatesDto> getReleaseDates() {
		return releaseDates;
	}


	public void setReleaseDates(List<ReleaseDatesDto> releaseDates) {
		this.releaseDates = releaseDates;
	}
	
}
