package com.library.rest_api.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NamedQuery(
        name = "BookCopy.fetchAllAvailableCopies",
        query = "FROM BookCopy WHERE isAvailalbe = TRUE"
)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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

}

