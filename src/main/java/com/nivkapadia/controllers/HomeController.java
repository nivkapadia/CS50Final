package com.nivkapadia.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.nivkapadia.beans.Author;
import com.nivkapadia.beans.Book;
import com.nivkapadia.beans.User;
import com.nivkapadia.database.DatabaseAccess;

@Controller
public class HomeController {
	
	@Autowired
	private DatabaseAccess da;
	
	@GetMapping("/")
	public String home()
	{
		return "index";
	}
	
	@GetMapping("/login")
	public String login()
	{
		return "login";
	}
	
	@GetMapping("/secure")
	public String secureHome()
	{
		return "secure/index";
	}
	
	@GetMapping("/secure/home")
	public String secureHomee()
	{
		return "secure/index";
	}
	
	@GetMapping("/secure/book-search")
	public String bookSearch()
	{
		return "secure/book";
	}
	
	@GetMapping("/admin/add-book")
	public String addBook(Model model)
	{
		model.addAttribute("book", new Book());
		return "admin/addBook";
	}
	
	@PostMapping("/admin/bookadded")
	public String bookAdded(@ModelAttribute Book book)
	{
		da.insertBook(book);
		return "redirect:/admin/view-book";
	}
	
	@GetMapping("/admin/add-author")
	public String authorAdded(Model model)
	{
		model.addAttribute("author", new Author());
		return "admin/addAuthor";
	}
	
	@PostMapping("/admin/authoradded")
	public String addedAuthor(@ModelAttribute Author author)
	{
		da.insertAuthor(author);
		return "redirect:/admin/view-author";
	}
	
	@GetMapping("/admin/view-author")
	public String viewAuthorAdmin(Model model)
	{
		ArrayList<Author> authors = da.getAllAuthors();
		model.addAttribute("authors", authors);
		return "admin/view-author";
	}
	
	@GetMapping("/permission-denied")
	public String error()
	{
		return "error/permission-denied";
	}
	
	@GetMapping("/admin/deleteAuth/{id}")
	public String deleteAuth(@PathVariable int id)
	{
		da.deleteAuthorById(id);
		return "redirect:/admin/view-author";
	}
	
	@GetMapping("/secure/view-book")
	public String viewBook(Model model)
	{
		ArrayList<Book> books = da.getAllBooks();
		System.out.println(books);
		model.addAttribute("book", books);
		return "secure/view-book";
	}
	
	@GetMapping("/secure/view-author")
	public String viewAuthor(Model model)
	{
		ArrayList<Author> authors= da.getAllAuthors();
		model.addAttribute("author", authors);
		return "secure/view-book";
	}
	
	@GetMapping("/admin/view-book")
	public String viewBookAsAdmin(Model model)
	{
		ArrayList<Book> books = da.getAllBooks();
		System.out.println(books);
		model.addAttribute("book", books);
		return "admin/view-book";
	}
	
	@GetMapping("/admin/delete/{id}")
	public String deleteBookById(@PathVariable int id)
	{
		da.deleteBookById(id);
		return "redirect:/admin/view-book";
	}
	
	@GetMapping("/admin/home")
	public String adminHome(Model model)
	{
		ArrayList<User> users = da.getAllUsers();
		model.addAttribute("users", users);
		return "admin/admin";
	}
	
	@GetMapping("/secure/view-authors")
	public String viewAuthorsSecure(Model model)
	{
		ArrayList<Author> a = da.getAllAuthors();
		model.addAttribute("authors", a);
		return "secure/view-author";
	}
	
}
