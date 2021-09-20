package com.chevrolet.bookstore.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.yaml.snakeyaml.constructor.Construct;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;

//To define a table in db
@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_book")
	private long id;
	private String author;
	private String isbn;
	private String title;
	private int year;
	@ManyToOne
	@JoinColumn(name="id_category")
	private Category category;
	
	public Book() {
		
	}
	
	public Book(String author,String isbn,String title,int year)
	{
		this.author = author;
		this.isbn = isbn;
		this.title = title;
		this.year = year;
	}
	
	public Book(String author,String isbn,String title,int year,Category category)
	{
		this(author,isbn,title,year);
		this.category = category;
	}

	
	@Override
	public String toString() {
		return "Book [id=" + id + ", author=" + author + ", isbn=" + isbn + ", title=" + title + ", year=" + year + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
}
