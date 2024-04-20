package hm.sb_tmdb_mvc_Homework1.dto;

import java.util.List;

public class GenreListDto {

	private List<GenreDto> genres;

	public GenreListDto(List<GenreDto> genres) {
		super();
		this.genres = genres;
	}

	public List<GenreDto> getGenres() {
		return genres;
	}

	public void setGenres(List<GenreDto> genres) {
		this.genres = genres;
	}

	@Override
	public String toString() {
		return "GenreListDto [genres=" + genres + "]";
	}
	
}
