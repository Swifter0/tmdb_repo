package hm.sb_tmdb_mvc_Homework1.dto;

public class ReleaseDatesDto {

	private String country;
	private String releaseDate;
	private int type;
	
	
	public ReleaseDatesDto(String country, String releaseDate, int type) {
		super();
		this.country = country;
		this.releaseDate = releaseDate;
		this.type = type;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getReleaseDate() {
		return releaseDate;
	}


	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}


	public int getType() {
		return type;
	}


	public void setType(int type) {
		this.type = type;
	}
	
}
