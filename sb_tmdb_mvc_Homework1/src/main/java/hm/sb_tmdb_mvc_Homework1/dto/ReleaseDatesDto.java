package hm.sb_tmdb_mvc_Homework1.dto;

public class ReleaseDatesDto {

	private String releaseDate;
	private int type;
	
	
	public ReleaseDatesDto(String releaseDate, int type) {
		super();
		this.releaseDate = releaseDate;
		this.type = type;
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
