package com.Shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.Shop.entity.BookEntity;
import com.Shop.entity.MyBooks;
import com.Shop.service.BookService;
import com.Shop.service.MyBooks_Service;

@Controller
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private MyBooks_Service myBooks_Service;
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/registration")
	public String bookRegister() {
		return "register";
	}
	
	@GetMapping("/availableBooks")
	public ModelAndView Availability() {
		List<BookEntity> list = bookService.getAllBooks();
//		ModelAndView m = new ModelAndView();
//		m.setViewName("availableBook");			We can Also Use this Instead of creating new in Return Statement
//		m.addObject("book",list);
		return new ModelAndView("availableBook","book",list);
	}
	
	@PostMapping("/save")
	public String addBook(@ModelAttribute BookEntity bookEntity) {
		bookService.save(bookEntity);
		return "redirect:/availableBooks";
	}
	
	@GetMapping("/my_books")
	public String getMyBooks(Model model) {
		List<MyBooks> list = myBooks_Service.getAllBooksofMine();
		
		model.addAttribute("book",list);
		return "myBooks";
	}
	
	@RequestMapping("/mylist/{id}")
	public String getNamebyID(@PathVariable("id") int id) {
		BookEntity b = bookService.getBookbyID(id);
		MyBooks mb = new MyBooks(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
		myBooks_Service.saveMyBooks(mb);
		return "redirect:/my_books";
	}
	
	@RequestMapping("/editABbookHUb/{id}")
	public String editBook(@PathVariable ("id") int id ,Model model) {
		BookEntity b = bookService.getBookbyID(id);
		model.addAttribute("book",b);
		return "edit_n_availableBooks";
	}
	
	@RequestMapping("/deleteABbookHUb/{id}")
	public String deleteBook(@PathVariable ("id") int id) {
		bookService.deleteBookinBH(id);
		return "redirect:/availableBooks";
	}
}
