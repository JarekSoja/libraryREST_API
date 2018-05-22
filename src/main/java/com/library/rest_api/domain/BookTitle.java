package com.library.rest_api.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

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

}
