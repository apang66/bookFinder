package com.homework.bookFinder.dao;

import java.util.List;
import java.util.Set;

import com.homework.bookFinder.model.Book;

public interface BookDao {
    Set<Book> selectAllBooks();

    List<Book> selectBookSearchResults(String searchTerm, int pageSize, int pageNumber);
}
