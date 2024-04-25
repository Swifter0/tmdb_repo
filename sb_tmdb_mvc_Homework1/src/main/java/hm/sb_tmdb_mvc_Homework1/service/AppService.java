package hm.sb_tmdb_mvc_Homework1.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import hm.sb_tmdb_mvc_Homework1.database.Database;
import hm.sb_tmdb_mvc_Homework1.dto.CountryDto;
import hm.sb_tmdb_mvc_Homework1.dto.GenreDto;
import hm.sb_tmdb_mvc_Homework1.dto.GenreListDto;
import hm.sb_tmdb_mvc_Homework1.dto.MovieDto;
import hm.sb_tmdb_mvc_Homework1.dto.MovieListDto;
import hm.sb_tmdb_mvc_Homework1.dto.MovieReleaseDateDto;
import hm.sb_tmdb_mvc_Homework1.dto.ReleaseDatesDto;
import hm.sb_tmdb_mvc_Homework1.dto.UserDto;
import hm.sb_tmdb_mvc_Homework1.model.Genre;
import hm.sb_tmdb_mvc_Homework1.model.Movie;
import hm.sb_tmdb_mvc_Homework1.model.MovieCountry;
import hm.sb_tmdb_mvc_Homework1.model.MovieReleaseDatesResult;
import hm.sb_tmdb_mvc_Homework1.model.ReleaseDates;
import hm.sb_tmdb_mvc_Homework1.model.TMDBGenreResult;
import hm.sb_tmdb_mvc_Homework1.model.TMDBMovieResult;
import hm.sb_tmdb_mvc_Homework1.model.User;

@Service
public class AppService {

	private String API_KEY =  "c1fa0cf3eda97ff6dbd2a15bf9e29f75";
	private Database db;
	
	@Autowired
	public AppService(Database db) {
		super();
		this.db = db;
	}



	public MovieDto getMovieById(int movieId) {
		
		MovieDto mDto = null;
		Movie movie = null;
		
		
		try {
			RestTemplate rt = new RestTemplate();
			movie = rt.getForObject("https://api.themoviedb.org/3/movie/" + movieId + "?api_key=" + API_KEY, Movie.class);
		}catch(Exception e) {
			
		//Hiba elkapva
			
		}

		if(movie != null) {
			
			mDto = convertMovieToMovieDto(movie);
			
		}
		
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
		genreListDto.getGenreDtosInIdOrder();
		
		
		return genreListDto;
	}



	public UserDto getSeenMoviesByUserId(int userId) {
		
		UserDto uDto = null;
		User user = db.getUserById(userId);
		
		if(user != null) {
			
			List<MovieDto> seenMovies = new ArrayList<>();
			List<Integer> seenMovieIds = user.getSeenMovieIds();
			
			RestTemplate rt = new RestTemplate();
			
			for(int index = 0; index < seenMovieIds.size(); index++) {
				
				int currentId = seenMovieIds.get(index);
				
				Movie movie =
						rt.getForObject("https://api.themoviedb.org/3/movie/" + currentId + "?api_key=" + API_KEY, Movie.class);
				
				MovieDto mDto = convertMovieToMovieDto(movie);
				seenMovies.add(mDto);
				
			}
			
			uDto = convertUserToUserDto(user, seenMovies);	
			
		}
		
		return uDto;
	}

	public UserDto convertUserToUserDto(User user, List<MovieDto> seenMovies) {
		
		UserDto uDto = new UserDto(
				user.getId(),
				user.getUserName(),
				seenMovies
				);
		
		return uDto;
	}



	public MovieListDto getFirst10MoviesByTitle(String title) {
		
		MovieListDto mListDto = null;
		
		RestTemplate rt = new RestTemplate();
		TMDBMovieResult movieResults =
				rt.getForObject("https://api.themoviedb.org/3/search/movie?query=" + title + "&api_key=" + API_KEY, TMDBMovieResult.class);
		
		List<Movie> movies = movieResults.getResults();
		List<MovieDto> movieDtos = new ArrayList<>();
		
		
		
		if(movies.size() >= 10) {
			
			for(int index = 0; index < 10; index++) {
				
				Movie currentMovie = movies.get(index);
				MovieDto currentMovieDto = convertMovieToMovieDto(currentMovie);
				movieDtos.add(currentMovieDto);
				
			}
		}else {
			
			for(int index = 0; index < movies.size(); index++) {
				
				Movie currentMovie = movies.get(index);
				MovieDto currentMovieDto = convertMovieToMovieDto(currentMovie);
				movieDtos.add(currentMovieDto);
				
			}
			
		}
		
		mListDto = new MovieListDto(movieDtos);
 		
		return mListDto;
	}



	public void persistSeenMovieById(int movieId, int userId) {
		
		db.persistSeenMovie(movieId,userId);
		
	}



	public MovieReleaseDateDto getMovieReleaseDateById(int movieId) {
		
		MovieReleaseDateDto mRDto = null;
		
		RestTemplate rt = new RestTemplate();
		MovieReleaseDatesResult mReleaseDatesResult =
				rt.getForObject("https://api.themoviedb.org/3/movie/" + movieId + "/release_dates?api_key=" + API_KEY, MovieReleaseDatesResult.class);
		 
		List<MovieCountry> tmdbMCountry = mReleaseDatesResult.getResults();
		List<CountryDto> countryDtoList = new ArrayList<>();
		
		for(int mainindex = 0; mainindex < tmdbMCountry.size(); mainindex++) {
			
			MovieCountry currentMCountry = tmdbMCountry.get(mainindex);
			
			List<ReleaseDates> releaseDList = currentMCountry.getRelease_dates();
			List<ReleaseDatesDto> releaseDDtoList = new ArrayList<>();
			
			for(int secindex = 0; secindex < releaseDList.size(); secindex++) {
				
				ReleaseDates currentRDate = releaseDList.get(secindex);
				
				ReleaseDatesDto releaseDDto = new ReleaseDatesDto(
						currentRDate.getRelease_date().substring(0,10),
						currentRDate.getType()
						);
				
				releaseDDtoList.add(releaseDDto);
			}
			
			CountryDto countryDto = new CountryDto(
					currentMCountry.getIso_3166_1(),
					releaseDDtoList
					);
			
			countryDtoList.add(countryDto);
				
		}
				
		 mRDto = new MovieReleaseDateDto(
				 movieId,
				 countryDtoList
				 );
		
		return mRDto;
	}
	
	
	
	
	
}














