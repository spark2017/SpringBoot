package com.basics.library;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/books")
public class BookController {

	private final BookService bookService;

	public BookController(BookService bookService) {
		this.bookService = bookService;
	}

	@GetMapping("/books.html")
	public String all(Model model) {
		model.addAttribute("books", bookService.findAll());
		return "books/list.html";
	}

	@GetMapping
	public Iterable<Book> list() {
		return bookService.findAll();
	}

	@GetMapping("/{isbn}")
	public ResponseEntity<Book> get(@PathVariable("isbn") String isbn) {
		return bookService.find(isbn).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<Book> create(@RequestBody Book book, UriComponentsBuilder uriBuilder) {
		Book created = bookService.create(book);
		URI newBookUri = uriBuilder.path("/books/{isbn}").build(created.getIsbn());
		try {
			System.out.println(newBookUri.toURL().toString());
		} catch (Exception exp) {
			System.out.println("Exception:" + exp.getMessage());
		}
		return ResponseEntity.created(newBookUri).body(created);
	}

}
