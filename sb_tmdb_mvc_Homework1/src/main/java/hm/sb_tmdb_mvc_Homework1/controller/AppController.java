package hm.sb_tmdb_mvc_Homework1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
	
	@GetMapping("/movie/{movieid}")
	public String showMovieById(
			Model model,
			@PathVariable("movieid") int movieId
			) {
		
		MovieDto mDto = service.getMovieById(movieId);
		model.addAttribute("movie", mDto);
		
		return "movie.html";
	}
	
	
	
}