package com.library.api.dto;

import com.library.api.domain.Loan;

public class BookCopyDto {

    private long bookCopyId;
    private Loan loan;
    private BookTitleDto bookTitleDto;
    private boolean isAvailable;

    public BookCopyDto(BookTitleDto bookTitleDto) {
        this.bookTitleDto = bookTitleDto;
    }

    public BookCopyDto(long bookCopyId, Loan loan, BookTitleDto bookTitleDto, boolean isAvailable) {
        this.bookCopyId = bookCopyId;
        this.loan = loan;
        this.bookTitleDto = bookTitleDto;
        this.isAvailable = isAvailable;
    }

    public BookCopyDto(Loan loan, BookTitleDto bookTitleDto, boolean isAvailable) {
        this.loan = loan;
        this.bookTitleDto = bookTitleDto;
        this.isAvailable = isAvailable;
    }


    public BookCopyDto(){
    }

    public long getBookCopyId() {
        return bookCopyId;
    }

    public Loan getLoan() {
        return loan;
    }

    public BookTitleDto getBookTitleDto() {
        return bookTitleDto;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
}
