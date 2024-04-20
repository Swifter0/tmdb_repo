package hm.sb_tmdb_mvc_Homework1.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import hm.sb_tmdb_mvc_Homework1.dto.GenreDto;
import hm.sb_tmdb_mvc_Homework1.dto.GenreListDto;
import hm.sb_tmdb_mvc_Homework1.dto.MovieDto;
import hm.sb_tmdb_mvc_Homework1.model.Genre;
import hm.sb_tmdb_mvc_Homework1.model.Movie;
import hm.sb_tmdb_mvc_Homework1.model.TMDBGenreResult;
import hm.sb_tmdb_mvc_Homework1.model.TMDBMovieResult;

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
				movie.getOverview(),
				movie.getGenre_ids()
				);
		
		return mDto;
	}



	public MovieDto getMovieByTitle(String movieTitle) {
		
		MovieDto mDto = null;
		
		RestTemplate rt = new RestTemplate();
		TMDBMovieResult movieResult =
				rt.getForObject("https://api.themoviedb.org/3/search/movie?query=" + movieTitle + "&api_key=" + API_KEY, TMDBMovieResult.class);
		
		List<Movie> movies = movieResult.getResults();
		if(movies.size() > 0) {
			
			Movie movie = movieResult.getResults().get(0);
			mDto = convertMovieToMovieDto(movie);
		}
		
		return mDto;
	}



	public GenreListDto getGenres() {
		
		GenreListDto genreListDto = null;
		
		RestTemplate rt = new RestTemplate();
		TMDBGenreResult genreResults =
				rt.getForObject("https://api.themoviedb.org/3/genre/movie/list?api_key=" + API_KEY, TMDBGenreResult.class);
		
		List<GenreDto> genreDtos = new ArrayList<>();
		List<Genre> genres = genreResults.getGenres();
		
		for(int index = 0; index < genres.size(); index++) {
			
			Genre currentGenre = genres.get(index);
			GenreDto gDto = new GenreDto(currentGenre.getId(), currentGenre.getName());
			
			genreDtos.add(gDto);
		}
		
		genreListDto = new GenreListDto(genreDtos);
		
		
		return genreListDto;
	}

}














