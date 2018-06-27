package com.library.api.dto;

import com.library.api.domain.BookCopy;

import java.util.List;

public class BookTitleDto {

    private long bookTitleId;
    private List<BookCopyDto> listOfCopies;
    private String title;
    private String author;
    private int yearOfPublishing;

    public BookTitleDto(String title, String author, int yearOfPublishing) {
        this.title = title;
        this.author = author;
        this.yearOfPublishing = yearOfPublishing;
    }

    public BookTitleDto(long bookTitleId, List<BookCopyDto> listOfCopies, String title, String author, int yearOfPublishing) {
        this.bookTitleId = bookTitleId;
        this.listOfCopies = listOfCopies;
        this.title = title;
        this.author = author;
        this.yearOfPublishing = yearOfPublishing;
    }

    public BookTitleDto(long bookTitleId, String title, String author, int yearOfPublishing) {
        this.bookTitleId = bookTitleId;
        this.title = title;
        this.author = author;
        this.yearOfPublishing = yearOfPublishing;
    }

    public BookTitleDto(){
    }

    public long getBookTitleId() {
        return bookTitleId;
    }

    public List<BookCopyDto> getListOfCopies() {
        return listOfCopies;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearOfPublishing() {
        return yearOfPublishing;
    }

    public void setBookTitleId(long bookTitleId) {
        this.bookTitleId = bookTitleId;
    }

    public void setListOfCopies(List<BookCopyDto> listOfCopies) {
        this.listOfCopies = listOfCopies;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setYearOfPublishing(int yearOfPublishing) {
        this.yearOfPublishing = yearOfPublishing;
    }
}
