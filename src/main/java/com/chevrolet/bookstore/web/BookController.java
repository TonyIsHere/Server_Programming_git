package com.chevrolet.bookstore.web;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.chevrolet.bookstore.domain.*;


@Controller
public class BookController {
	
	@Autowired
	private BookRepository repository;
	
	@Autowired
	private CategoryRepository crepository;
	
	
	@RequestMapping({"/booklist","/"})
	public String booklist(Model model)
	{
		model.addAttribute("books",repository.findAll());
		return "booklist"; 
	}
	@RequestMapping("/addbook")
	public String addbook(@ModelAttribute Book book,Model model)
	{
		model.addAttribute("myCategories",crepository.findAll());
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
		model.addAttribute("myCategories", crepository.findAll());
		return "editbook";
	}
	
	
    @RequestMapping("/books")
    public @ResponseBody List<Book> bookListRest() {	
        return (List<Book>) repository.findAll();
    }    
	
	@RequestMapping("/book/{id}")
	public @ResponseBody Optional<Book> getbookRest(@PathVariable("id") Long id)
	{
		return repository.findById(id);
	}
}
