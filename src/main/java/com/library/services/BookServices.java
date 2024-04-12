package com.library.services;

import com.library.entity.Author;
import com.library.entity.Book;
import com.library.repo.AuthorRepo;
import com.library.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServices {

    @Autowired
    private BookRepo bookRepo;

    //CRUD

    public  Book addBook(Book book){
        return bookRepo.save(book);
    }

    public Book update (Book book){

        Book book1 =bookRepo.findById(book.getId()).orElseThrow();

        if(book1!=null)
            bookRepo.save(book);
        else{
            throw new IllegalArgumentException("Author not found ");
        }
            return book;
    }

    public Book getBookByID(Long id){
        return bookRepo.findById(id).orElseThrow();
    }

    public List<Book> getAllBooks(){
        return bookRepo.findAll();
    }

    public void deleteByID(Long id ){
        Book book= bookRepo.findById(id).orElseThrow();
        if(book!=null)
            bookRepo.deleteById(id);
        else
            throw new IllegalArgumentException("this Author is already deleted");
    }

}
