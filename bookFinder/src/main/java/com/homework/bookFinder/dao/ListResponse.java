package com.homework.bookFinder.dao;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.homework.bookFinder.model.Book;

public class ListResponse {
    int total;
    List<Book> books;

    public ListResponse(@JsonProperty("total") int total, @JsonProperty("books") List<Book> books) {
        this.total = total;
        this.books = books;
    }

    public int getTotal() {
        return total;
    }

    public List<Book> getBooks() {
        return books;
    }
}
