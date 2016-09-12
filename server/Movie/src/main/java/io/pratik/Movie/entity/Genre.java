package io.pratik.Movie.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
@NamedQuery(name = "Genre.findAll", query = "SELECT g FROM Genre g ORDER BY g.movieName ASC")
public class Genre {
	
	@Id
	@GenericGenerator(name="customUUID", strategy="uuid2")
	@GeneratedValue(generator="customUUID")	
	private String id;
	@Column(unique=true)
	private String movieName;
	private String genre;

public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getmovieName() {
	return movieName;
}
public void setmovieName(String name) {
	this.movieName = name;
}
public String getGenre() {
	return genre;
}
public void setGenre(String genre) {
	this.genre = genre;
}

}
