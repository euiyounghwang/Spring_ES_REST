package com.poscoict.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.google.gson.Gson;
import com.poscoict.rest.entity.BookEntity;
import com.poscoict.rest.store.BookRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController()
public class BookController {

	@Autowired
	private BookRepository bookRepository;

	@PostMapping("/book")
	public BookEntity createBook(@RequestBody BookEntity bookEntity) {
		System.out.println("@@ PostMapping -> \n" + bookEntity.toString());
		BookEntity created = bookRepository.save(bookEntity);
		System.out.println(new Gson().toJson(created));
		return created;
	}

	@GetMapping("/book")
	public List<BookEntity> listAllBooks() {
		List<BookEntity> list = new ArrayList<>();
		
		Iterable<BookEntity> iterable = bookRepository.findAll();
		System.out.println("\n@@ GetMapping : \n" + new Gson().toJson(iterable));
		
		for (BookEntity bookEntity : iterable) {
			list.add(bookEntity);
		}
		
//		bookRepository.findAll().forEach(list::add);
		
		return list;
	}

	@PutMapping("/book/{bookId}")
	public BookEntity updateBook(@PathVariable("bookId") UUID bookId, @RequestBody BookEntity bookEntity) {
		bookEntity.setId(bookId);
		BookEntity updated = bookRepository.save(bookEntity);
		return updated;
	}

	@DeleteMapping("/book/{bookId}")
	public void deleteBook(@PathVariable("bookId") UUID bookId) {
		bookRepository.deleteById(bookId);
	}
}
