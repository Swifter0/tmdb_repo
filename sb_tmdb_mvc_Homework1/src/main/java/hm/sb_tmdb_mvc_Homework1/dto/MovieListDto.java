package hm.sb_tmdb_mvc_Homework1.dto;

import java.util.List;

public class MovieListDto {
	
	List<MovieDto> movies;

	public MovieListDto(List<MovieDto> movies) {
		super();
		this.movies = movies;
	}

	public List<MovieDto> getMovies() {
		return movies;
	}

	public void setMovies(List<MovieDto> movies) {
		this.movies = movies;
	}

	@Override
	public String toString() {
		return "MovieListDto [movies=" + movies + "]";
	}
	
}
