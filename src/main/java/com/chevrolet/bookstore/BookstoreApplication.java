package com.chevrolet.bookstore;


import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.chevrolet.bookstore.domain.Book;
import com.chevrolet.bookstore.domain.BookRepository;

import jdk.internal.org.jline.utils.Log;



@SpringBootApplication
public class BookstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository repository) {
		return (args) -> {
			repository.save(new Book("Ernest Hemingway","1232323-21","A Farewell to Arms",1929));
			repository.save(new Book("George Orwell","2212343-5","Animal Farm",1945));
			log.info("fetch all books");
			Iterable<Book> data = repository.findAll();
			for (Book b : data) {
				log.info(b.toString());
			}
		};
		}
}
