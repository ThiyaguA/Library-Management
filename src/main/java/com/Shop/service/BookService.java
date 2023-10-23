package com.Shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Shop.entity.BookEntity;
import com.Shop.repo.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	public void save(BookEntity bookEntity) {
		bookRepository.save(bookEntity);
	}
	
	public List<BookEntity> getAllBooks(){
		return bookRepository.findAll();
	}
	
	public BookEntity getBookbyID(int id) {
		return bookRepository.findById(id).get();
	}
	
	public void deleteBookinBH(int id) {
		bookRepository.deleteById(id);
	}
}
