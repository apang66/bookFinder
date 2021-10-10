package com.homework.bookFinder.dao;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import com.homework.bookFinder.model.Book;
import com.homework.bookFinder.model.BookSearchResult;
import com.homework.bookFinder.model.ListResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository("googleDao")
public class GoogleBookDataAccessService implements BookDao {

    @Value("${api.key")
    private String apiKey;

    private static Set<Book> BOOK_HISTORY = new TreeSet<Book>(new BookComparator());
    private static List<Book> CURRENT_SEARCH = new ArrayList<Book>();

    @Override
    public ListResponse selectBookHistory(int pageNumber) {
        List<Book> allBooks = BOOK_HISTORY.stream().collect(Collectors.toList());
        int start = pageNumber * 20;
        int end = (start + 20) < allBooks.size() ? start + 20 : allBooks.size();
        return new ListResponse(BOOK_HISTORY.size(), allBooks.subList((pageNumber * 20), end));
    }

    @Override
    public ListResponse selectBookSearchResults(String searchTerm, int pageSize) {
        // We need to do two queries to get 50 results because we can only get up to 40
        // at a time
        List<Book> searchResults = doBookSearch(searchTerm, 0);
        searchResults.addAll(doBookSearch(searchTerm, 25));

        CURRENT_SEARCH = searchResults;
        return new ListResponse(searchResults.size(), searchResults.subList(0, pageSize));
    }

    @Override
    public ListResponse selectBookSearchResultsPage(int pageSize, int pageNumber) {
        int start = pageNumber * 20;
        int end = (start + 20) < CURRENT_SEARCH.size() ? start + 20 : CURRENT_SEARCH.size();
        return new ListResponse(CURRENT_SEARCH.size(), CURRENT_SEARCH.subList((pageNumber * 20), end));
    }

    private void insertBook(Book book) {
        BOOK_HISTORY.add(book);
    }

    private List<Book> doBookSearch(String searchTerm, int start) {
        String apiUrl = "https://www.googleapis.com/books/v1/volumes?orderBy=relevance&maxResults=25&startIndex="
                + start + "&q=" + searchTerm;
        RestTemplate restTemplate = new RestTemplate();
        BookSearchResult result = restTemplate.getForObject(apiUrl, BookSearchResult.class);

        return result.getBookEntries().stream()
                .map(entry -> new Book(entry.getId(), entry.getBookInfo().getTitle(), entry.getBookInfo().getAuthors()))
                .peek(book -> insertBook(book)).collect(Collectors.toList());
    }

    static class BookComparator implements Comparator<Book> {
        @Override
        public int compare(Book b1, Book b2) {
            String title1 = b1.getTitle().trim();
            String title2 = b2.getTitle().trim();
            Set<String> authors1 = b1.getAuthors();
            Set<String> authors2 = b2.getAuthors();

            boolean authorsEqual = false;
            if ((authors1 != null && authors2 != null && authors1.containsAll(authors2)
                    && authors2.containsAll(authors1)) || (authors1 == null && authors2 == null))
                authorsEqual = true;

            if (title1.equals(title2) && authorsEqual)
                return 0;
            else
                return 1;
        }
    }
}
