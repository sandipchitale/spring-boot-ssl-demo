package org.example.books.server;

import java.util.List;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
class BookDataLoader implements ApplicationRunner {

	private final BookRepository repository;

	BookDataLoader(BookRepository repository) {
		this.repository = repository;
	}

	@Override
	public void run(ApplicationArguments args) {
		List<Book> books = List.of(
				new Book("Spring in Action", List.of("Craig Walls"), "Manning"),
				new Book("Spring Boot in Action", List.of("Craig Walls"), "Manning"),
				new Book("Spring Microservices in Action", List.of("John Carnell"), "Manning"),
				new Book("Reactive Spring", List.of("Josh Long"), "Josh Long"),
				new Book("Spring 5",
						List.of("Iuliana Cosmina", "Rob Harrop", "Chris Schaefer", "Clarence Ho"), "Apress"),
				new Book("Spring 5 Recipes: A Problem-Solution Approach",
						List.of("Marten Deinum", "Daniel Rubio", "Josh Long"), "Apress"),
				new Book("Spring Boot: Up and Running", List.of("Mark Heckler"), "O'Reilly"),
				new Book("Spring Security in Action", List.of("Laurentiu Spilca"), "Manning"),
				new Book("Spring Data: Modern Data Access for Enterprise Java",
						List.of("Jonathan L. Brisbin", "Oliver Gierke", "Thomas Risberg", "Mark Pollack", "Michael Hunger"),
						"O'Reilly"),
				new Book("Spring Integration in Action",
						List.of("Mark Fisher", "Jonas Partner", "Marius Bogoevici", "Iwein Fuld"), "Manning")

		);
		this.repository.saveAll(books);
	}

}
