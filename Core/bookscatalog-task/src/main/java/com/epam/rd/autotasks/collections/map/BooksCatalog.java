package com.epam.rd.autotasks.collections.map;

import java.math.BigDecimal;
import java.util.*;
import java.util.regex.Pattern;

public class BooksCatalog {
    private final TreeMap<Author, List<Book>> catalog;

    public BooksCatalog() {
        this.catalog = new TreeMap<>();
    }

    public BooksCatalog(Map<Author, List<Book>> catalog) {
        this.catalog = new TreeMap<>(catalog);
    }

    public List<Book> findByAuthor(Author author) {
        if (author == null) throw new NullPointerException();
        return catalog.get(author);
    }

    public String getAllAuthors() {
        StringBuilder authorsList = new StringBuilder();
        for (Author author : catalog.keySet()) {
            if (authorsList.length() > 0) {
                authorsList.append(System.lineSeparator());
            }
            authorsList.append(author.toString());
        }
        return authorsList.toString();
    }

    public Map<Book, List<Author>> findAuthorsByBookTitle(String pattern) {
        if (pattern == null) throw new NullPointerException();
        Map<Book, List<Author>> result = new TreeMap<>();
        Pattern p = Pattern.compile(Pattern.quote(pattern), Pattern.CASE_INSENSITIVE);

        for (Map.Entry<Author, List<Book>> entry : catalog.entrySet()) {
            for (Book book : entry.getValue()) {
                if (p.matcher(book.getTitle()).find()) {
                    result.computeIfAbsent(book, k -> new ArrayList<>()).add(entry.getKey());
                }
            }
        }

        return result;
    }

    public Set<Book> findBooksByGenre(String pattern) {
        if (pattern == null) throw new NullPointerException();
        Pattern p = Pattern.compile(Pattern.quote(pattern), Pattern.CASE_INSENSITIVE);
        Set<Book> result = new TreeSet<>();

        for (List<Book> books : catalog.values()) {
            for (Book book : books) {
                for (String genre : book.getGenres()) {
                    if (p.matcher(genre).find()) {
                        result.add(book);
                        break;
                    }
                }
            }
        }

        return result;
    }

    public List<Author> findAuthorsByBook(Book book) {
        if (book == null) throw new NullPointerException();
        List<Author> authors = new ArrayList<>();

        for (Map.Entry<Author, List<Book>> entry : catalog.entrySet()) {
            if (entry.getValue().contains(book)) {
                authors.add(entry.getKey());
            }
        }

        return authors.isEmpty() ? null : authors;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Author, List<Book>> entry : catalog.entrySet()) {
            sb.append(entry.getKey()).append(":\n");
            for (Book book : entry.getValue()) {
                sb.append("\t").append(book).append("\n");
            }
        }
        return sb.toString();
    }
}