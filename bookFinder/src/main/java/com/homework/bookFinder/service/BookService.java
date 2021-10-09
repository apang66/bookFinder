package com.homework.bookFinder.service;

import java.util.List;
import java.util.Set;

import com.homework.bookFinder.dao.BookDao;
import com.homework.bookFinder.model.Book;

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

    public Set<Book> getAllBooks() {
        return bookDao.selectAllBooks();
    }

    public List<Book> getBookSearchResults(String searchTerm, int pageSize, int pageNumber) {
        return bookDao.selectBookSearchResults(searchTerm, pageSize, pageNumber);
    }
}
