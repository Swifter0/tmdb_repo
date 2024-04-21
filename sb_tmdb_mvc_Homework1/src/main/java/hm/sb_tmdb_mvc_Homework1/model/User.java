package hm.sb_tmdb_mvc_Homework1.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "users")
public class User {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "username")
	private String userName;
	
	@Transient
	private List<Integer> seenMovieIds;

	public User() {
		
		this.seenMovieIds = new ArrayList<>();
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<Integer> getSeenMovieIds() {
		return seenMovieIds;
	}

	public void setSeenMovieIds(List<Integer> seenMovieIds) {
		this.seenMovieIds = seenMovieIds;
	}
	
	public void addSeenMovieId(Integer id) {
		
		this.seenMovieIds.add(id);
	}
	
}












