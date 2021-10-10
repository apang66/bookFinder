package com.homework.bookFinder.dao;

public interface BookDao {
    ListResponse selectBookHistory(int pageNumber);

    ListResponse selectBookSearchResults(String searchTerm, int pageSize);

    ListResponse selectBookSearchResultsPage(int pageSize, int pageNumber);
}
