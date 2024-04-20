package hm.sb_tmdb_mvc_Homework1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import hm.sb_tmdb_mvc_Homework1.dto.GenreListDto;
import hm.sb_tmdb_mvc_Homework1.dto.MovieDto;
import hm.sb_tmdb_mvc_Homework1.service.AppService;

@Controller
public class AppController {

	private AppService service;

	@Autowired
	public AppController(AppService service) {
		super();
		this.service = service;
	}
	

	@GetMapping("/")
	public String openIndex() {
		
		return "index.html";
	}
	
	
	@GetMapping("/movie/{movieid}")
	public String showMovieById(
			Model model,
			@PathVariable("movieid") int movieId
			) {
		
		MovieDto mDto = service.getMovieById(movieId);
		model.addAttribute("movie", mDto);
		
		return "movie.html";
	}
	
	
	@GetMapping("/movie/search")
	public String getMovieByTitle(
			Model model,
			@RequestParam("title") String movieTitle
			) {
		
		MovieDto mDto = service.getMovieByTitle(movieTitle);
		model.addAttribute("movie", mDto);
		
		return "movie.html";
	}
	
	
	@GetMapping("/movie/genres")
	public String getGenres(Model model) {
	
		GenreListDto genreListDto = service.getGenres();
		model.addAttribute("genrelistdto", genreListDto);
		
		return "genres.html";
	}
	
	
}














