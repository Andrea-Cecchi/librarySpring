package com.example.formvalidation.controller;


import com.example.formvalidation.Dao.BookDao;
import com.example.formvalidation.model.Book;
import com.example.formvalidation.model.BooksResponse;
import com.example.formvalidation.model.GoogleBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


@RestController
public class ApiController {

    @Autowired
    private BookDao bookRepository;

    @GetMapping("/libri")
    public ArrayList<Book> libri(){
        return (ArrayList<Book>) bookRepository.findAll();

    }

    @GetMapping("/libro")
    public Book libro(@RequestParam(value = "title") String title){
        return bookRepository.findByTitolo(title);
    }

    @GetMapping("/sincronizza")
    public String sincronizza(){
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://www.googleapis.com/books/v1/volumes?q=\"\"&maxResults=40";
        ResponseEntity<BooksResponse> response = restTemplate.getForEntity(url, BooksResponse.class);
        ArrayList<GoogleBook.Root> libri = response.getBody().getItems();
        for (GoogleBook.Root b: libri
             ) {
            String pattern = "dd/MM/yyyy";
            DateFormat df = new SimpleDateFormat(pattern);
            bookRepository.save(new Book(b.volumeInfo.title, b.volumeInfo.authors.get(0), df.format(b.volumeInfo.publishedDate.getTime()), b.saleInfo.retailPrice == null ? 0 : (int)b.saleInfo.retailPrice.amount ));
        }
        return "ok";

    }
}
