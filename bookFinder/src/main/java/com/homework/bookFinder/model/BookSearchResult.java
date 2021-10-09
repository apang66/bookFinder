package com.homework.bookFinder.model;

import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BookSearchResult {
    @JsonProperty("totalItems")
    private int total;

    @JsonProperty("items")
    private List<BookEntry> bookEntries;

    public int getTotal() {
        return total;
    }

    public List<BookEntry> getBookEntries() {
        return bookEntries;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setbookEntries(List<BookEntry> bookEntries) {
        this.bookEntries = bookEntries;
    }

    public static class BookEntry {
        @JsonProperty("id")
        private String id;

        @JsonProperty("volumeInfo")
        private BookInfo bookInfo;

        public String getId() {
            return id;
        }

        public BookInfo getBookInfo() {
            return bookInfo;
        }

        public void setId(String id) {
            this.id = id;
        }

        public void setBookInfo(BookInfo bookInfo) {
            this.bookInfo = bookInfo;
        }
    }

    public static class BookInfo {
        @JsonProperty("title")
        private String title;

        @JsonProperty("authors")
        private Set<String> authors;

        public String getTitle() {
            return title;
        }

        public Set<String> getAuthors() {
            return authors;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setAuthors(Set<String> authors) {
            this.authors = authors;
        }
    }
}
