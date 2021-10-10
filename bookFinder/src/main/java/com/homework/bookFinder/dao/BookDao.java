package com.homework.bookFinder.dao;

import com.homework.bookFinder.model.ListResponse;

public interface BookDao {
    ListResponse selectBookHistory(int pageNumber);

    ListResponse selectBookSearchResults(String searchTerm, int pageSize);

    ListResponse selectBookSearchResultsPage(int pageSize, int pageNumber);
}
