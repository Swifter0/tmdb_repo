package hm.sb_tmdb_mvc_Homework1.dto;

import java.util.List;

public class UserDto {

	private int id;
	private String username;
	private List<MovieDto> seenMovies;
	
	
	public UserDto(int id, String username, List<MovieDto> seenMovies) {
		super();
		this.id = id;
		this.username = username;
		this.seenMovies = seenMovies;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public List<MovieDto> getSeenMovies() {
		return seenMovies;
	}


	public void setSeenMovies(List<MovieDto> seenMovies) {
		this.seenMovies = seenMovies;
	}


	@Override
	public String toString() {
		return "UserDto [id=" + id + ", username=" + username + ", seenMovies=" + seenMovies + "]";
	}
	
}
