package com.library.controll;

import com.library.entity.Author;
import com.library.services.AuthorServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/author")
public class AuthorControl {

    @Autowired
    private AuthorServices authorServices;

    @PostMapping
    public ResponseEntity<?> addAuthor(@RequestBody Author author){
        return ResponseEntity.ok(authorServices.addAuthor(author));
    }

    @PutMapping
    public ResponseEntity<?> updateAuthor(@RequestBody Author author){
        return ResponseEntity.ok(authorServices.update(author));
    }


    @GetMapping()
    public ResponseEntity<?> getAllAuthor(){
        return ResponseEntity.ok(authorServices.getAllAuthors());
    }

    @GetMapping("/id")
    public ResponseEntity<?> getAuthorBuId(@Param("id") Long id){
        return ResponseEntity.ok(authorServices.getAuthorByID(id));
    }

    @DeleteMapping
    public ResponseEntity<?> deleteAuthor(@Param("id") Long id){
        authorServices.deleteByID(id);
        return ResponseEntity.ok(true);
    }


}
