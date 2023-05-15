package org.example.books.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class BookApiController {

	private final RestTemplate restTemplate;

	@Value("${app.server-base-url}")
	private String baseUrl;

	public BookApiController(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@GetMapping("/books")
	public List<Book> index() {
		ResponseEntity<List<Book>> response = restTemplate.exchange(baseUrl + "/api/books",
				HttpMethod.GET, null, new ParameterizedTypeReference<>() {});
		return response.getBody();
	}

}
