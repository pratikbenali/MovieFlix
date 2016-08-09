package io.pratik.Movie.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
@NamedQuery(name = "Movie.findAll", query = "SELECT m FROM Movie m ORDER BY m.name ASC")
public class Movie {
	 	
	@Id
	@Column(unique=true)
     private String name;
     private String summary;
     private String type;
     
     private int released;
     private int runtime;
     private String director;
     private String writer;
     private String actors;
     private String language;
     private String country;
     private String awards;
     
   //One Movie can have only One Rating
     //@OneToOne
    // private Rating rate;
     
     //One Movie can have many Genres
     @OneToMany
     private List<Genre> genre;
     
     private int year;
     public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getReleased() {
		return released;
	}
	public void setReleased(int released) {
		this.released = released;
	}
	public int getRuntime() {
		return runtime;
	}
	public void setRuntime(int runtime) {
		this.runtime = runtime;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getActors() {
		return actors;
	}
	public void setActors(String actors) {
		this.actors = actors;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getAwards() {
		return awards;
	}
	public void setAwards(String awards) {
		this.awards = awards;
	}
     
//	public Rating getRate() {
//		return rate;
//	}
//	public void setRate(Rating rate) {
//		this.rate = rate;
//	}
	public List<Genre> getGenre() {
		return genre;
	}
	public void setGenre(List<Genre> genre) {
		this.genre = genre;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return "Movie[" + "Name=" + name + ", summary=" + summary + ", type=" + type
		+ "]";
	}
}
