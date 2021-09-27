package com.chevrolet.bookstore.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
 
public interface BookRepository extends CrudRepository<Book, Long> {
	//Optional<Book> findById(@Param("id") Long id);
}
