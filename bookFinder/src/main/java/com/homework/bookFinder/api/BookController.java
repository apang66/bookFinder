package com.homework.bookFinder.api;

import com.homework.bookFinder.model.ListResponse;
import com.homework.bookFinder.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RequestMapping("api/v1/book")
@RestController
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ListResponse getBookHistory(@RequestParam("pageNumber") int pageNumber) {
        return bookService.getBookHistory(pageNumber);
    }

    @GetMapping(value = "/search/")
    public ListResponse getBookSearchResults(@RequestParam("term") String searchTerm,
            @RequestParam("pageSize") int pageSize) {
        return bookService.getBookSearchResults(searchTerm, pageSize);
    }

    @GetMapping(value = "/page/")
    public ListResponse getBookSearchResultsPage(@RequestParam("pageSize") int pageSize,
            @RequestParam("pageNumber") int pageNumber) {
        return bookService.getBookSearchResultsPage(pageSize, pageNumber);
    }
}
