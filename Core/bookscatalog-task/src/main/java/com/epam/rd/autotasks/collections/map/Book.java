package com.epam.rd.autotasks.collections.map;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public class Book implements Comparable<Book> {
    private final String title;
    private final List<String> genres;
    private final BigDecimal cost;

    public Book(String title, List<String> genres, BigDecimal cost) {
        this.title = title;
        this.genres = genres;
        this.cost = cost;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getGenres() {
        return genres;
    }

    public BigDecimal getCost() {
        return cost;
    }

    @Override
    public int compareTo(Book o) {
        int titleComparison = this.title.compareToIgnoreCase(o.title);
        if (titleComparison != 0) {
            return titleComparison;
        } else {
            return this.cost.compareTo(o.cost);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return title.equals(book.title) && Objects.equals(genres, book.genres) && Objects.equals(cost, book.cost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, genres, cost);
    }

    @Override
    public String toString() {
        return "Book{" + "title='" + title + '\'' + ", genres=" + genres + ", cost=" + cost + '}';
    }
}