package com.library.api.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
@NamedNativeQuery(
        name = "BookTitle.retrieveBookTitlesWithAvailableCopies",
        query = "SELECT * FROM BOOK_TITLES, BOOK_COPIES WHERE BOOK_COPIES.LOAN_STATUS = TRUE",
        resultClass = BookTitle.class
)
@Entity
@Table(name = "BOOK_TITLES")
public class BookTitle {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "BOOK_TITLE_ID", unique = true)
    private long bookTitleId;

    @OneToMany(
            targetEntity = BookCopy.class,
            mappedBy = "bookTitle",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY

    )
    private List<BookCopy> listOfCopies;

    @Column(name = "BOOK_TITLE")
    private String title;

    @Column(name = "AUTHOR_NAME")
    private String author;

    @Column(name = "YEAR_OF_PUBLISHING")
    private int yearOfPublishing;

    public BookTitle(String title, String author, int yearOfPublishing) {
        this.title = title;
        this.author = author;
        this.yearOfPublishing = yearOfPublishing;
    }

    public BookTitle(Long bookTitleId, String title, String author, int yearOfPublishing) {
        this.bookTitleId = bookTitleId;
        this.title = title;
        this.author = author;
        this.yearOfPublishing = yearOfPublishing;
    }

    public BookTitle() {
    }

    public long getBookTitleId() {
        return bookTitleId;
    }

    public List<BookCopy> getListOfCopies() {
        return listOfCopies;
    }

    public void setListOfCopies(List<BookCopy> listOfCopies) {
        this.listOfCopies = listOfCopies;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYearOfPublishing() {
        return yearOfPublishing;
    }

    public void setYearOfPublishing(int yearOfPublishing) {
        this.yearOfPublishing = yearOfPublishing;
    }
}
