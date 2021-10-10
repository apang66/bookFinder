package com.homework.bookFinder.service;

import com.homework.bookFinder.dao.BookDao;
import com.homework.bookFinder.dao.ListResponse;

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

    public ListResponse getAllBooks(int pageNumber) {
        return bookDao.selectAllBooks(pageNumber);
    }

    public ListResponse getBookSearchResults(String searchTerm, int pageSize, int pageNumber) {
        return bookDao.selectBookSearchResults(searchTerm, pageSize, pageNumber);
    }
}
