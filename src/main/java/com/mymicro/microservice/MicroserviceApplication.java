package com.mymicro.microservice;


import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MicroserviceApplication  {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception
//	{
//		// Inserting the data in the mysql table.
//		Movie movie1 = new Movie("Babylon1","JDK1",LocalDate.parse("1998-01-10"));
//		Movie movie2 = new Movie("Babylon2","JDK2",LocalDate.parse("1999-01-10"));
//		Movie movie3 = new Movie("Babylon3","JDK3",LocalDate.parse("2000-01-10"));
//		// ob.save() method
//		movieService.addMovie(movie1);
//		movieService.addMovie(movie2);
//		movieService.addMovie(movie3);
//	}

}
