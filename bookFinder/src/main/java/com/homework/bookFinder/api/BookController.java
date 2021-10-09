package com.homework.bookFinder.api;

import java.util.List;
import java.util.Set;

import com.homework.bookFinder.model.Book;
import com.homework.bookFinder.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/v1/book")
@RestController
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public Set<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping(value = "/search/")
    public List<Book> getBookSearchResults(@RequestParam("term") String searchTerm,
            @RequestParam("pageSize") int pageSize, @RequestParam("pageNumber") int pageNumber) {
        return bookService.getBookSearchResults(searchTerm, pageSize, pageNumber);
    }
}
