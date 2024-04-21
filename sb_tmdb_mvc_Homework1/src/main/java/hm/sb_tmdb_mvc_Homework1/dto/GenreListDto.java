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

	public void getGenreDtosInIdOrder() {
		
		for(int mainIndex = 0; mainIndex < genres.size(); mainIndex++) {
			
			for(int index = mainIndex+1; index < genres.size(); index++) {
				
				GenreDto currentGenreDto = genres.get(mainIndex);
				GenreDto nextGenreDto = genres.get(index);
				
				if(nextGenreDto.getId() < currentGenreDto.getId()) {
					
					genres.set(mainIndex, nextGenreDto);
					genres.set(index, currentGenreDto);
					mainIndex = -1;
					break;
				}
			}
		}
	}
}
