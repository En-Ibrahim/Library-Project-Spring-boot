package com.library.services;

import com.library.entity.Author;
import com.library.repo.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServices {

    @Autowired
    private AuthorRepo authorRepo;

    //CRUD

    public  Author addAuthor(Author author){
        return authorRepo.save(author);
    }

    public Author update (Author author){

        Author author1 =authorRepo.findById(author.getId()).orElseThrow();

        if(author1!=null)
            authorRepo.save(author);
        else{
            throw new IllegalArgumentException("Author not found ");
        }
            return author;
    }

    public Author getAuthorByID(Long id){
        return authorRepo.findById(id).orElseThrow();
    }

    public List<Author> getAllAuthors(){
        return authorRepo.findAll();
    }

    public void deleteByID(Long id ){
        Author author= authorRepo.findById(id).orElseThrow();
        if(author!=null)
                authorRepo.deleteById(id);
        else
            throw new IllegalArgumentException("this Author is already deleted");
    }

}
