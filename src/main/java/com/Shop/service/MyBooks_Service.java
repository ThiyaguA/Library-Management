package com.Shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Shop.entity.MyBooks;
import com.Shop.repo.MyBooks_Repo;

@Service
public class MyBooks_Service {
	
	@Autowired
	private MyBooks_Repo repo;
	
	public void saveMyBooks(MyBooks myBooks) {
		repo.save(myBooks);
	}

	public List<MyBooks> getAllBooksofMine(){
		return repo.findAll();
	}
	
	public void deleteMyBook(int id) {
		repo.deleteById(id);
	}
}
