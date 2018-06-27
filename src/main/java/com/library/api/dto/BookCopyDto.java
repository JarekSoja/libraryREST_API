package com.library.api.dto;

public class BookCopyDto {

    private long bookCopyId;
    private LoanDto loanDto;
    private BookTitleDto bookTitleDto;
    private boolean isAvailable;

    public BookCopyDto(BookTitleDto bookTitleDto) {
        this.bookTitleDto = bookTitleDto;
    }

    public BookCopyDto(long bookCopyId, LoanDto loanDto, BookTitleDto bookTitleDto, boolean isAvailable) {
        this.bookCopyId = bookCopyId;
        this.loanDto = loanDto;
        this.bookTitleDto = bookTitleDto;
        this.isAvailable = isAvailable;
    }

    public BookCopyDto(LoanDto loanDto, BookTitleDto bookTitleDto, boolean isAvailable) {
        this.loanDto = loanDto;
        this.bookTitleDto = bookTitleDto;
        this.isAvailable = isAvailable;
    }


    public BookCopyDto(){
    }

    public long getBookCopyId() {
        return bookCopyId;
    }

    public LoanDto getLoanDto() {
        return loanDto;
    }

    public BookTitleDto getBookTitleDto() {
        return bookTitleDto;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
}
