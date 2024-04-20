package hm.sb_tmdb_mvc_Homework1.dto;

import java.util.List;

public class MovieDto {

	private int id;
	private String original_title;
	private String overview;
	private List<Integer> genreIds;
	
	
	public MovieDto(int id, String original_title, String overview, List<Integer> genreIds) {
		super();
		this.id = id;
		this.original_title = original_title;
		this.overview = overview;
		this.genreIds = genreIds;
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


	public List<Integer> getGenreIds() {
		return genreIds;
	}


	public void setGenreIds(List<Integer> genreIds) {
		this.genreIds = genreIds;
	}


	@Override
	public String toString() {
		return "MovieDto [id=" + id + ", original_title=" + original_title + ", overview=" + overview + ", genreIds="
				+ genreIds + "]";
	}
	
}
