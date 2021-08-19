package com.zemoso.springboot.spring_Assignment;

import com.zemoso.springboot.spring_Assignment.dao.MovieRepository;
import com.zemoso.springboot.spring_Assignment.entity.Movie;
import com.zemoso.springboot.spring_Assignment.entity.Review;
import com.zemoso.springboot.spring_Assignment.service.MovieService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SpringAssignmentApplicationTests {

	@Autowired
	private MovieService movieService;

	@MockBean
	private MovieRepository movieRepository;

	private List<Movie> getMovies()
	{
		List<Movie> movies = new ArrayList<>();
		Movie movie1 = new Movie("Saaho","Telugu","Prabhas","Sujeeth","Action-Thriller", 9.8f);
		Movie movie2 = new Movie("RadheShyam","Telugu","Prabhas","Radha Krishna","Love", 10.0f);
		Movie movie3 = new Movie("Sallar","Telugu","Prabhas","Prashanth","Action", 10.0f);
		Movie movie4 = new Movie("Projectk","Telugu","Prabhas","Nag Ashwin","Sci-Fi", 10.0f);
		movies.add(movie1);
		movies.add(movie2);
		movies.add(movie3);
		movies.add(movie4);
		return movies;
	}

	@Test
	void testFindAll()
	{
		List<Movie> movies = getMovies();
		Mockito.when(movieRepository.findAll()).thenReturn(movies);
		List<Movie> listofMovies = movieService.findAll();
		System.out.println(movies);
		assertEquals(movies.size(), listofMovies.size());
	}

	@Test()
	void testFindById(){
		int theId = 2;
		List<Movie> movies = getMovies();
		Mockito.when(movieRepository.findById(theId)).thenReturn(Optional.of(movies.get(theId)));

		assertEquals(movies.get(theId),movieService.findById(theId));

		theId = 1;
		Mockito.when(movieRepository.findById(theId)).thenReturn(Optional.of(movies.get(theId)));

		assertEquals(movies.get(theId),movieService.findById(theId));

		}
	@Test
	void testSave(){
		Movie movie5 = new Movie("Mirchi","Telugu","Prabhas","Shiva","Family",10.0f);
		movieService.save(movie5);
		Mockito.verify(movieRepository,Mockito.times(1)).
				save(movie5);
	}
	@Test
	void testDeleteById(){
		int theId=5;
		movieService.deleteById(theId);

		Mockito.verify(movieRepository,Mockito.times(1)).
				deleteById(theId);
	}



}
