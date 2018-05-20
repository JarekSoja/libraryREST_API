package com.library.rest_api.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "BOOK_COPIES")
class NewBookCopy {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "BOOK_COPY_ID", unique = true)
    private long bookCopyId;

    @ManyToOne
    @JoinColumn (name = "LOAN_COPIES")
    private NewLoan newLoan;

    @ManyToOne
    @JoinColumn (name = "TITLE_COPIES")
    private NewBookTitle bookTitle;

    @Column(name = "LOAN_STATUS")
    private boolean isAvailable;
}

