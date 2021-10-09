package com.homework.bookFinder.dao;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.homework.bookFinder.model.Book;

import org.springframework.stereotype.Repository;

@Repository("fakeDao")
public class FakeBookDataAccessService implements BookDao {

    private static Set<Book> DB = new HashSet<Book>();

    @Override
    public Set<Book> selectAllBooks() {
        return DB;
    }

    @Override
    public List<Book> selectBookSearchResults(String searchTerm, int pageSize, int pageNumber) {
        return new ArrayList<Book>();
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
}
