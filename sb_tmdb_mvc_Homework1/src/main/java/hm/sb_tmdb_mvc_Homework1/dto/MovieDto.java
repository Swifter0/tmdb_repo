package hm.sb_tmdb_mvc_Homework1.dto;

public class MovieDto {

	private int id;
	private String original_title;
	private String overview;
	
	
	public MovieDto(int id, String original_title, String overview) {
		super();
		this.id = id;
		this.original_title = original_title;
		this.overview = overview;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getOriginal_title() {
		return original_title;
	}


	public void setOriginal_title(String original_title) {
		this.original_title = original_title;
	}


	public String getOverview() {
		return overview;
	}


	public void setOverview(String overview) {
		this.overview = overview;
	}


	@Override
	public String toString() {
		return "MovieDto [id=" + id + ", original_title=" + original_title + ", overview=" + overview + "]";
	}
	
}
