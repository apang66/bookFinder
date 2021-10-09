package com.homework.bookFinder.model;

import java.util.Set;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Book {
    private String id;

    @NotBlank
    private String title;

    @NotBlank
    private Set<String> authors;

    public Book() {
        // empty constructor because google said it was needed
    }

    public Book(@JsonProperty("id") String id, @JsonProperty("title") String title,
            @JsonProperty("authors") Set<String> authors) {
        this.id = id;
        this.title = title;
        this.authors = authors;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Set<String> getAuthors() {
        return authors;
    }

    @Override
    public String toString() {
        return "Book [id=" + id + ", title=" + title + ", authors=" + authors + "]";
    }
}
