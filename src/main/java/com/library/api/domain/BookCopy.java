package com.library.api.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NamedQuery(
        name = "BookCopy.getBookCopiesByAvailable",
        query = "FROM BookCopy WHERE isAvailable = TRUE"
)
@Entity
@Table(name = "BOOK_COPIES")
public class BookCopy {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "BOOK_COPY_ID", unique = true)
    private long bookCopyId;

    @ManyToOne
    @JoinColumn(name = "LOAN_COPIES")
    private Loan loan;

    @ManyToOne
    @JoinColumn(name = "TITLE_COPIES")
    private BookTitle bookTitle;

    @Column(name = "LOAN_STATUS")
    private boolean isAvailable;

    public BookCopy (BookTitle bookTitle) {
        this.bookTitle = bookTitle;
        this.isAvailable = true;
    }

    public BookCopy(Loan loan, BookTitle bookTitle, boolean isAvailable) {
        this.loan = loan;
        this.bookTitle = bookTitle;
        this.isAvailable = isAvailable;
    }

    public BookCopy(Long bookCopyId, Loan loan, BookTitle bookTitle, boolean isAvailable) {
        this.bookCopyId = bookCopyId;
        this.loan = loan;
        this.bookTitle = bookTitle;
        this.isAvailable = isAvailable;
    }

    public BookCopy() {
    }

    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }

    public BookTitle getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(BookTitle bookTitle) {
        this.bookTitle = bookTitle;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public long getBookCopyId() {
        return bookCopyId;
    }
}

