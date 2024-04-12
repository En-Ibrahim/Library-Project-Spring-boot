package com.library.controll;

import com.library.entity.Book;

import com.library.services.BookServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookControl {

    @Autowired
    private BookServices bookServices;

    //CRUD

    @PostMapping
    public ResponseEntity<?> addBook(@RequestBody Book book){
        return ResponseEntity.ok(bookServices.addBook(book));
    }
    @PutMapping
    public ResponseEntity<?> update (@RequestBody Book book){

        return ResponseEntity.ok(bookServices.update(book));
    }

    @GetMapping("/id")
    public ResponseEntity<?> getBookByID(@Param("id") Long id){
        return  ResponseEntity.ok(bookServices.getBookByID(id));
    }
    @GetMapping
    public ResponseEntity<?> getAllBooks(){
        return  ResponseEntity.ok(bookServices.getAllBooks());
    }
    @DeleteMapping
    public ResponseEntity<?> deleteByID(@Param("id") Long id ){
        bookServices.deleteByID(id);
        return  ResponseEntity.ok(true);
    }

}
