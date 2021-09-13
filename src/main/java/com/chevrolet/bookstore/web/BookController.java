package com.chevrolet.bookstore.web;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.chevrolet.bookstore.domain.*;

import org.springframework.ui.Model;

@Controller
public class BookController {
	
	@Autowired
	private BookRepository repository;
	@RequestMapping("/booklist")
	public String booklist(Model model)
	{
		model.addAttribute("books",repository.findAll());
		return "booklist"; 
	}
	@RequestMapping("/addbook")
	public String addbook(@ModelAttribute Book book,Model model)
	{
		
		return "addbook"; 
	}
	@PostMapping("/savebook")
	public String postAddbook(@ModelAttribute Book book,Model model)
	{
		repository.save(book);
		return "redirect:/booklist";
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long bookid,Model model)
	{
		repository.deleteById(bookid);
		return "redirect:/booklist";
	}
	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long bookid,Model model)
	{
		Optional<Book> item = repository.findById(bookid);
		model.addAttribute("book", item);
		return "editbook";
	}
}
