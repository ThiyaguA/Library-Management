package com.Shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Shop.repo.MyBooks_Repo;

@Controller
public class MyBook_Controller {

	@Autowired
	private MyBooks_Repo myBooks_Repo;
	
	@RequestMapping("/deleteMyBook/{id}")
	public String deleteMyBook(@PathVariable("id") int id) {
		myBooks_Repo.deleteById(id);
		return "redirect:/my_books";
	}
}
