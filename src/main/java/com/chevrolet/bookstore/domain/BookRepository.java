package com.chevrolet.bookstore.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;
 
@RepositoryRestResource
public interface BookRepository extends CrudRepository<Book, Long> {
	List<Book> findByYear(@Param("year") int year);
}
