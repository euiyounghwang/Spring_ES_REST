package com.poscoict.rest.store;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.poscoict.rest.entity.BookEntity;

import java.util.UUID;

@Repository
public interface BookRepository extends CrudRepository<BookEntity, UUID> {
	
	void deleteById(String bookId);

}