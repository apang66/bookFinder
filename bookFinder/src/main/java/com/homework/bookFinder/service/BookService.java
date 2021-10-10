package com.homework.bookFinder.service;

import com.homework.bookFinder.dao.BookDao;
import com.homework.bookFinder.model.ListResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private final BookDao bookDao;

    @Autowired
    public BookService(@Qualifier("googleDao") BookDao bookDao) {
        this.bookDao = bookDao;
    }

    /**
     * Get all the books that have matched the user's searches.
     */
    public ListResponse getBookHistory(int pageNumber) {
        return bookDao.selectBookHistory(pageNumber);
    }

    /**
     * Get the results of a new search.
     */
    public ListResponse getBookSearchResults(String searchTerm, int pageSize) {
        return bookDao.selectBookSearchResults(searchTerm, pageSize);
    }

    /**
     * Get a page of the current search results.
     */
    public ListResponse getBookSearchResultsPage(int pageSize, int pageNumber) {
        return bookDao.selectBookSearchResultsPage(pageSize, pageNumber);
    }
}
