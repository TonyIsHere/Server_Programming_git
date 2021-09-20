package com.chevrolet.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.chevrolet.bookstore.domain.Book;
import com.chevrolet.bookstore.domain.BookRepository;
import com.chevrolet.bookstore.domain.Category;
import com.chevrolet.bookstore.domain.CategoryRepository;


@SpringBootApplication
public class BookstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository repository,CategoryRepository crepository) {
		return (args) -> {
			Category c1 = new Category("Horror");
			crepository.save(c1);
			crepository.save(new Category("Fun"));
			log.info("fetch all category");
			Iterable<Category> data = crepository.findAll();
			for (Category b : data) {
				log.info(b.toString());
			}
			
			repository.save(new Book("Ernest Hemingway","1232323-21","A Farewell to Arms",1929,c1));
			repository.save(new Book("George Orwell","2212343-5","Animal Farm",1945,c1));
			log.info("fetch all books");
			Iterable<Book> dataBook = repository.findAll();
			for (Book b : dataBook) {
				log.info(b.toString());
			}
		};
		}
}
