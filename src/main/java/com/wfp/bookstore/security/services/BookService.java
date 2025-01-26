package com.wfp.bookstore.security.services;


import org.springframework.stereotype.*;

import com.wfp.bookstore.entity.Book;
import com.wfp.bookstore.repository.BookRepository;

import java.util.*;


@Service
public class BookService {
    
    private final BookRepository bookRepository;
    
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book save(Book book) {
        return bookRepository.save(book);
    }
    
    public void update(Book book) {
        bookRepository.saveAndFlush(book);
    }

    public Book findById(Integer bookId) {
        Optional<Book> book=bookRepository.findById(bookId);
        return book.get();
    }
    
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public void delete(Integer bookId) {
        bookRepository.deleteById(bookId);
    }
 
}
