package com.homework.bookFinder.dao;

public interface BookDao {
    ListResponse selectAllBooks(int pageNumber);

    ListResponse selectBookSearchResults(String searchTerm, int pageSize, int pageNumber);
}
