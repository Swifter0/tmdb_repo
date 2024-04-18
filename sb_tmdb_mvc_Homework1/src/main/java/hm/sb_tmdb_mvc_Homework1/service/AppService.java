package hm.sb_tmdb_mvc_Homework1.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import hm.sb_tmdb_mvc_Homework1.dto.MovieDto;
import hm.sb_tmdb_mvc_Homework1.model.Movie;

@Service
public class AppService {

	private String API_KEY =  "c1fa0cf3eda97ff6dbd2a15bf9e29f75";
	
	
	
	public MovieDto getMovieById(int movieId) {
		
		MovieDto mDto = null;
		
		RestTemplate rt = new RestTemplate();
		Movie movie = rt.getForObject("https://api.themoviedb.org/3/movie/" + movieId + "?api_key=" + API_KEY, Movie.class);
		
		mDto = convertMovieToMovieDto(movie);
		
		return mDto;
	}



	private MovieDto convertMovieToMovieDto(Movie movie) {
		
		MovieDto mDto = new MovieDto(
				movie.getId(),
				movie.getOriginal_title(),
				movie.getOverview()
				);
		
		return mDto;
	}

}














