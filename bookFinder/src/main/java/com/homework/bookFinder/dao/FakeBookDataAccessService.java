package com.homework.bookFinder.dao;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.homework.bookFinder.model.Book;
import com.homework.bookFinder.model.ListResponse;

import org.springframework.stereotype.Repository;

@Repository("fakeDao")
public class FakeBookDataAccessService implements BookDao {

    private static Set<Book> DB = new HashSet<Book>();

    @Override
    public ListResponse selectBookHistory(int pageNumber) {
        return new ListResponse(0, DB.stream().collect(Collectors.toList()));
    }

    @Override
    public ListResponse selectBookSearchResults(String searchTerm, int pageSize) {
        return new ListResponse(0, new ArrayList<>());
    }

    class BookComparator implements Comparator<Book> {
        @Override
        public int compare(Book b1, Book b2) {
            if (b1.getTitle().trim().equals(b2.getTitle().trim()) && b1.getAuthors().equals(b2.getAuthors()))
                return 0;
            else
                return 1;
        }
    }

    @Override
    public ListResponse selectBookSearchResultsPage(int pageSize, int pageNumber) {
        return new ListResponse(0, DB.stream().collect(Collectors.toList()));
    }
}
