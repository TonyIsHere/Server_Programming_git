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
import com.chevrolet.bookstore.domain.User;
import com.chevrolet.bookstore.domain.UserRepository;


@SpringBootApplication
public class BookstoreApplication {
	


	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository repository,CategoryRepository crepository,UserRepository urepository) {
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
			
			// Create users: admin/admin user/user
			User user1 = new User("user",
			"$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin",
			"$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
		};
		}
}
