package com.chevrolet.bookstore;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import com.chevrolet.bookstore.domain.Book;
import com.chevrolet.bookstore.domain.BookRepository;
import com.chevrolet.bookstore.domain.Category;
import com.chevrolet.bookstore.domain.CategoryRepository;
import com.chevrolet.bookstore.domain.UserRepository;
import com.chevrolet.bookstore.web.BookController;
import com.chevrolet.bookstore.web.UserDetailServiceImpl;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class BookstoreApplicationTests {




	@Autowired
	private BookRepository brepository;
	
	@Autowired
	private CategoryRepository crepository;
	
	@Autowired
	private UserRepository urepository;


	@Test
	public void findByYearShouldReturnStudent() {
		List<Book> books = brepository.findByYear(1929);
		assertThat(books).hasSize(1);
		assertThat(books.get(0).getAuthor()).isEqualTo("Ernest Hemingway");
	}

	@Test
	public void createNewBook() {
		Category c1 = new Category("Funny");
		crepository.save(c1);
		Book book = new Book("Anthony", "1232322-21", "Very bad trip", 2020, c1);
		brepository.save(book);
		assertThat(book.getId()).isNotNull();

	}
	
	@Test
	public void testDelete()
	{
		List<Book> books = brepository.findByYear(1929);
		brepository.delete(books.get(0));
		books = brepository.findByYear(1929);
		assertThat(books).hasSize(0);
		
		
	}
	
	

}
