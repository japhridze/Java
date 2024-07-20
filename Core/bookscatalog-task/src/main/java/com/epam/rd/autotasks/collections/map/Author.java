package com.epam.rd.autotasks.collections.map;

import java.util.Objects;

public class Author implements Comparable<Author> {
    private final String firstName;
    private final String lastName;

    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public int compareTo(Author o) {
        int firstNameComparison = this.firstName.compareToIgnoreCase(o.firstName);
        return (firstNameComparison != 0) ? firstNameComparison : this.lastName.compareToIgnoreCase(o.lastName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Author)) return false;
        Author author = (Author) o;
        return firstName.equals(author.firstName) && lastName.equals(author.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}