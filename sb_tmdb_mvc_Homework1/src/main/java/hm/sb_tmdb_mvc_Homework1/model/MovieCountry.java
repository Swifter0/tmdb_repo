package hm.sb_tmdb_mvc_Homework1.model;

import java.util.List;

public class MovieCountry {

	private String iso_3166_1;
	private List<ReleaseDates> release_dates;
	
	public String getIso_3166_1() {
		return iso_3166_1;
	}
	
	public void setIso_3166_1(String iso_3166_1) {
		this.iso_3166_1 = iso_3166_1;
	}
	
	public List<ReleaseDates> getRelease_dates() {
		return release_dates;
	}
	
	public void setRelease_dates(List<ReleaseDates> release_dates) {
		this.release_dates = release_dates;
	}
	
}
