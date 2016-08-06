package io.pratik.Movie.controller;

import java.util.List;
import io.pratik.Movie.entity.Movie;
import io.pratik.Movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "movies")
public class MovieController {

	@Autowired
	MovieService service;
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> findAll() {
		return service.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, path = "{name}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Movie findByName(@PathVariable("name") String movieName) {
		return service.findByName(movieName);
	}

	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Movie create(@RequestBody Movie mov) {
		return service.create(mov);
	}

	@RequestMapping(method = RequestMethod.PUT, path = "{name}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Movie update(@PathVariable("name") String movieName, @RequestBody Movie mov) {
		return service.update(movieName, mov);
	}

	@RequestMapping(method = RequestMethod.DELETE, path = "{name}")
	public void delete(@PathVariable("name") String movieName) {
		service.delete(movieName);
	}
}
